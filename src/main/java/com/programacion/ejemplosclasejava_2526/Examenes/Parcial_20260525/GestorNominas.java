package com.programacion.examenes_2526.Parcial_20260525;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * =============================================================================
 * EJERCICIO 1 – Gestión de Nóminas
 * CFGS DAW | Módulo: Programación
 * =============================================================================
 *
 * Descripción general:
 *   Clase que gestiona la carga de nóminas de empleados desde un fichero CSV
 *   hacia una base de datos MySQL llamada 'empresa_nominas'.
 *
 *   El fichero CSV (nominas.csv) tiene como primera línea la cabecera:
 *     empleado_id;nombre;apellidos;departamento;puesto;
 *     salario_base;complementos;fecha_alta;activo
 *
 * Requisitos previos:
 *   - MySQL en ejecución en localhost:3306
 *   - Conector JDBC en el classpath (mysql-connector-j-X.X.X.jar)
 *   - Fichero nominas.csv en la ruta indicada al llamar los métodos
 *
 * =============================================================================
 */
public class GestorNominas {

    // =========================================================================
    // 1. CONSTANTES GLOBALES DE CONEXIÓN
    //
    //    Se declaran como 'private static final' para que:
    //      · 'private'  → solo sean accesibles dentro de esta clase
    //      · 'static'   → pertenezcan a la clase, no a una instancia concreta,
    //                     lo que permite usarlas desde métodos static (main, etc.)
    //      · 'final'    → su valor no pueda modificarse una vez asignado
    //
    //    Ajusta USUARIO y PASSWORD a los de tu instalación de MySQL.
    // =========================================================================

    private static final String HOST     = "localhost";
    private static final String PUERTO   = "3306";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "";

    /**
     * URL sin base de datos seleccionada.
     * Se usa para ejecutar DROP DATABASE e CREATE DATABASE, operaciones que
     * no pueden realizarse cuando ya hay una BD seleccionada en la URL.
     */
    private static final String URL_SIN_BD ="jdbc:mysql://localhost:3306/";

    /**
     * URL con la base de datos 'empresa_nominas' ya seleccionada.
     * Se usa para todas las operaciones sobre tablas (CREATE TABLE, INSERT…).
     */
    private static final String URL_CON_BD = URL_SIN_BD + "empresa_nominas";


    // =========================================================================
    // MÉTODO MAIN
    //
    //   Orquesta la secuencia completa de operaciones indicada en el enunciado:
    //     1. Eliminar la BD empresa_nominas (si existe)
    //     2. Crear la BD empresa_nominas
    //     3. Crear la tabla nominas con todos sus campos
    //     4. Mostrar el CSV en formato tabla (visualización previa a la carga)
    //     5. Leer el CSV e insertar cada fila en la BD
    // =========================================================================
    public static void main(String[] args) {

        // Ruta al fichero CSV. Ajusta si está en otra carpeta.
        String rutaCsv = "src\\main\\java\\com\\programacion\\nominas.csv";
        // Modificar la línea anterior para adaptar a tu contexto

        System.out.println("══════════════════════════════════════");
        System.out.println("        GESTOR DE NÓMINAS  (DAW)      ");
        System.out.println("══════════════════════════════════════\n");

        // Paso 1 ── Eliminar BD previa para partir de un estado limpio
        boolean eliminada = eliminarBbdd("empresa_nominas");
        System.out.println("· BD eliminada:    " + eliminada);

        // Paso 2 ── Crear la BD vacía
        boolean creada = generarBbdd("empresa_nominas");
        System.out.println("· BD creada:       " + creada);

        // Paso 3 ── Crear la tabla con el esquema correcto
        boolean tablaOk = generarTabla("nominas");
        System.out.println("· Tabla creada:    " + tablaOk);

        // Paso 4 ── Mostrar el contenido del CSV en terminal (solo visualización)
        System.out.println("\n── Contenido del fichero CSV ──");
        leerCsvTabla(rutaCsv);

        // Paso 5 ── Insertar los datos del CSV en la base de datos
        System.out.println("\n── Insertando datos en la BD ──");
        leerCsvInsertar(rutaCsv, "empresa_nominas", "nominas");

        System.out.println("\n¡Proceso completado correctamente!");
    }

    // =========================================================================
    // 2. MÉTODO leerCsvTabla
    //
    //    Lee el fichero CSV indicado línea a línea e imprime su contenido en
    //    formato tabla en la terminal.
    //
    //    La tabla es DINÁMICA: el número de columnas y sus nombres se extraen
    //    automáticamente de la primera línea (cabecera) del CSV, por lo que
    //    el método funciona con cualquier fichero CSV, no solo nominas.csv.
    //
    //    Pasos internos:
    //      1. Leer la primera línea → dividirla → imprimir cabecera
    //      2. Para cada línea de datos → dividirla → imprimir fila
    //
    //    @param fullName  Ruta completa (o relativa) al fichero CSV
    // =========================================================================
    public static void leerCsvTabla(String fullName) {

        // Anchura fija asignada a cada columna para mantener la alineación
        final int ANCHO = 18;

        // try-with-resources garantiza que el BufferedReader se cierra siempre
        try (Scanner sc = new Scanner(new FileReader(fullName))) {

            String  linea;
            boolean esCabecera = true;

            while (sc.hasNextLine()) {
                linea = sc.nextLine();

                // Separamos los campos por ";" (cambiar a "," si el CSV lo usa)
                String[] campos = linea.split(";");

                if (esCabecera) {
                    // ── Línea superior de la tabla ──
                    System.out.println("=".repeat(ANCHO * campos.length));

                    // ── Nombres de columna en mayúsculas, alineados a la izquierda ──
                    for (String campo : campos) {
                        System.out.printf("%-" + ANCHO + "s", campo.toUpperCase().trim());
                    }
                    System.out.println();

                    // ── Línea separadora tras la cabecera ──
                    System.out.println("=".repeat(ANCHO * campos.length));

                    esCabecera = false; // El resto de líneas son datos

                } else {
                    // ── Fila de datos ──
                    for (String campo : campos) {
                        System.out.printf("%-" + ANCHO + "s", campo.trim());
                    }
                    System.out.println();
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero CSV: " + e.getMessage());
        }
    }

    // =========================================================================
    // 3a. MÉTODO eliminarBbdd
    //
    //    Elimina la base de datos indicada si existe.
    //    Usa "DROP DATABASE IF EXISTS" para evitar errores si no existe.
    //    La conexión se realiza SIN base de datos seleccionada (URL_SIN_BD).
    //
    //    @param  databaseName  Nombre de la base de datos a eliminar
    //    @return true  → eliminada correctamente
    //            false → ocurrió algún error (se imprime el mensaje)
    // =========================================================================
    public static boolean eliminarBbdd(String databaseName) {

        String sql = "DROP DATABASE IF EXISTS " + databaseName + ";";

        try (Connection con = DriverManager.getConnection(URL_SIN_BD, USUARIO, PASSWORD);
             Statement  st  = con.createStatement()) {

            st.executeUpdate(sql);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar BD '" + databaseName + "': " + e.getMessage());
            return false;
        }
    }


    // =========================================================================
    // 3b. MÉTODO generarBbdd
    //
    //    Crea una nueva base de datos con el nombre indicado y charset utf8mb4
    //    (necesario para soportar caracteres especiales del español).
    //    También usa URL_SIN_BD para la conexión.
    //
    //    @param  databaseName  Nombre de la base de datos a crear
    //    @return true  → creada correctamente
    //            false → ocurrió algún error
    // =========================================================================
    public static boolean generarBbdd(String databaseName) {

        String sql = "CREATE DATABASE " + databaseName + " CHARACTER SET utf8mb4;";

        try (Connection con = DriverManager.getConnection(URL_SIN_BD, USUARIO, PASSWORD);
             Statement  st  = con.createStatement()) {

            st.executeUpdate(sql);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al crear BD '" + databaseName + "': " + e.getMessage());
            return false;
        }
    }


    // =========================================================================
    // 3c. MÉTODO generarTabla
    //
    //    Crea la tabla 'nominas' con el esquema que corresponde a los campos
    //    del fichero CSV. Los tipos de datos están elegidos para representar
    //    correctamente cada campo:
    //      · VARCHAR  → texto de longitud variable
    //      · DECIMAL  → números con decimales (dinero)
    //      · DATE     → fechas en formato YYYY-MM-DD
    //      · TINYINT  → booleano en MySQL (0 = false, 1 = true)
    //
    //    La conexión ya incluye la BD seleccionada (URL_CON_BD).
    //
    //    @param  tableName  Nombre de la tabla a crear
    //    @return true  → tabla creada correctamente
    //            false → ocurrió algún error
    // =========================================================================
    public static boolean generarTabla(String tableName) {

        String sql =
            "CREATE TABLE " + tableName + " (" +
            "  empleado_id   INT            NOT NULL, "  +
            "  nombre        VARCHAR(50)    NOT NULL, "  +
            "  apellidos     VARCHAR(100)   NOT NULL, "  +
            "  departamento  VARCHAR(50)    NOT NULL, "  +
            "  puesto        VARCHAR(50)    NOT NULL, "  +
            "  salario_base  DECIMAL(10,2)  NOT NULL, "  +
            "  complementos  DECIMAL(10,2)  NOT NULL, "  +
            "  fecha_alta    DATE           NOT NULL, "  +
            "  activo        TINYINT(1)     NOT NULL, "  + // 1=activo, 0=inactivo
            "  PRIMARY KEY (empleado_id)"                +
            ")";

        try (Connection con = DriverManager.getConnection(URL_CON_BD, USUARIO, PASSWORD);
             Statement  st  = con.createStatement()) {

            st.executeUpdate(sql);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al crear tabla '" + tableName + "': " + e.getMessage());
            return false;
        }
    }


    // =========================================================================
    // 3d. MÉTODO generarInsertPorEmpleado
    //
    //    Construye y DEVUELVE la sentencia INSERT SQL para un empleado.
    //    IMPORTANTE: este método NO ejecuta nada contra la BD; solo genera
    //    el texto SQL. La ejecución la realiza leerCsvInsertar().
    //
    //    Usa String.format() para sustituir los placeholders (%s, %.2f, %d)
    //    por los valores reales recibidos como parámetros.
    //
    //    Conversión boolean → int:
    //      MySQL no tiene tipo BOOLEAN nativo; se almacena como TINYINT(1).
    //      true  → 1
    //      false → 0
    //
    //    @param nombre        Nombre del empleado
    //    @param apellidos     Apellidos del empleado
    //    @param departamento  Departamento
    //    @param puesto        Puesto de trabajo
    //    @param salarioBase   Salario base (decimal)
    //    @param complementos  Complementos salariales (decimal)
    //    @param fechaAlta     Fecha de alta en formato YYYY-MM-DD
    //    @param activo        Estado laboral actual
    //    @return              String con el INSERT completo listo para ejecutar
    // =========================================================================
    public static String generarInsertPorEmpleado(
            String  nombre,
            String  apellidos,
            String  departamento,
            String  puesto,
            double  salarioBase,
            double  complementos,
            String  fechaAlta,
            boolean activo) {

        // Convertimos boolean a entero para que MySQL lo acepte en TINYINT(1)
        int activoInt;
        if (activo) {
            activoInt = 1;
        } else {
            activoInt = 0;
        }

        // String.format sustituye en orden los marcadores:
        //   %s   → String (entre comillas simples en el SQL)
        //   %.2f → double con 2 decimales
        //   %d   → entero
        return String.format(
            "INSERT INTO nominas " +
            "(nombre, apellidos, departamento, puesto, salario_base, complementos, fecha_alta, activo) " +
            "VALUES ('%s', '%s', '%s', '%s', %.2f, %.2f, '%s', %d)",
            nombre, apellidos, departamento, puesto,
            salarioBase, complementos, fechaAlta, activoInt
        );
    }


    // =========================================================================
    // 3e. MÉTODO leerCsvInsertar
    //
    //    Lee el fichero CSV línea a línea, parsea cada campo, llama a
    //    generarInsertPorEmpleado() para obtener la sentencia SQL y la ejecuta
    //    contra la base de datos.
    //
    //    Flujo por cada línea de datos:
    //      1. Dividir la línea en campos (split por ";")
    //      2. Parsear cada campo al tipo Java correcto
    //      3. Llamar a generarInsertPorEmpleado() → obtener String SQL
    //      4. Ejecutar el INSERT con Statement.executeUpdate()
    //
    //    @param fullName      Ruta al fichero CSV
    //    @param databaseName  Nombre de la BD (recibido por parámetro según
    //                         el enunciado; ya está incluido en URL_CON_BD)
    //    @param tableName     Nombre de la tabla destino
    // =========================================================================
    public static void leerCsvInsertar(String fullName, String databaseName, String tableName) {

        // Abrimos el CSV y la conexión a la BD en el mismo try-with-resources
        try (BufferedReader br  = new BufferedReader(new FileReader(fullName));
             Connection     con = DriverManager.getConnection(URL_CON_BD, USUARIO, PASSWORD);
             Statement      st  = con.createStatement()) {

            String  linea;
            boolean esCabecera = true;
            int     insertados = 0;

            while ((linea = br.readLine()) != null) {

                // La primera línea es la cabecera → la saltamos
                if (esCabecera) {
                    esCabecera = false;
                    continue;
                }

                // Ignoramos líneas vacías
                if (linea.isBlank()) continue;

                // Dividimos la línea en sus campos
                String[] campos = linea.split(";");

                // Si la línea no tiene los 9 campos esperados, la ignoramos
                if (campos.length < 9) continue;

                // ── Parseamos cada campo a su tipo Java correspondiente ──

                // Posición 0: empleado_id (entero)
                int empleadoId = Integer.parseInt(campos[0].trim());

                // Posición 1: nombre (String)
                String nombre = campos[1].trim();

                // Posición 2: apellidos (String)
                String apellidos = campos[2].trim();

                // Posición 3: departamento (String)
                String departamento = campos[3].trim();

                // Posición 4: puesto (String)
                String puesto = campos[4].trim();

                // Posición 5: salario_base (double)
                double salarioBase = Double.parseDouble(campos[5].trim().replace(",", "."));

                // Posición 6: complementos (double)
                double complementos = Double.parseDouble(campos[6].trim().replace(",", "."));

                // Posición 7: fecha_alta (String en formato YYYY-MM-DD para MySQL)
                String fechaAlta = campos[7].trim();

                // Posición 8: activo (boolean) → acepta "true"/"false" o "1"/"0"
                boolean activo = campos[8].trim().equalsIgnoreCase("true")
                              || campos[8].trim().equals("1");

                // ── Generamos la sentencia INSERT llamando al método dedicado ──
                String sqlInsert = generarInsertPorEmpleado(
                    nombre, apellidos, departamento, puesto,
                    salarioBase, complementos, fechaAlta, activo
                );

                // También se puede poner haciendo uso de campos directamente:
                /*

                int activoInt;
                if (campos[8].trim().equalsIgnoreCase("true") || campos[8].trim().equals("1")) {
                    activoInt = 1;
                } else {
                    activoInt = 0;
                }
                String sqlInsert = String.format(
                    "INSERT INTO nominas " +
                    "(nombre, apellidos, departamento, puesto, salario_base, complementos, fecha_alta, activo) " +
                    "VALUES ('%s', '%s', '%s', '%s', %.2f, %.2f, '%s', %d)",
                    campos[1].trim(),  // nombre
                    campos[2].trim(),  // apellidos
                    campos[3].trim(),  // departamento
                    campos[4].trim(),  // puesto
                    Double.parseDouble(campos[5].trim().replace(",", ".")), // salario_base
                    Double.parseDouble(campos[6].trim().replace(",", ".")), // complementos
                    campos[7].trim(),  // fecha_alta
                    activoInt // activo

                );
                */

                // Mostramos el SQL generado para facilitar la depuración
                System.out.println("  → " + sqlInsert);

                // Ejecutamos el INSERT en la BD
                st.executeUpdate(sqlInsert);
                insertados++;
            }

            System.out.println("\nTotal de empleados insertados: " + insertados);

        } catch (IOException e) {
            System.out.println("Error al leer el CSV: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al insertar en BD: " + e.getMessage());
        }
    }
}