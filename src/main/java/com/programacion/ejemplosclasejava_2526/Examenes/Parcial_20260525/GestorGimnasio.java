package com.programacion.examenes_2526.Parcial_20260525;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// La librería org.json debe estar en el classpath.
// Descárgala desde: https://mvnrepository.com/artifact/org.json/json
// y añádela al proyecto en NetBeans como "jar/folder".
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * =============================================================================
 * EJERCICIO 2 – Gestor de Gimnasios
 * CFGS DAW | Módulo: Programación
 * =============================================================================
 *
 * Descripción general:
 *   Clase que realiza consultas SQL sobre la base de datos 'red_gimnasios'
 *   (ya importada en Adminer/MySQL) y exporta datos en formato JSON.
 *
 *   La BD contiene al menos las tablas:
 *     · gimnasio  (id, nombre, ciudad, capacidad, …)
 *     · socio     (id, nombre, apellidos, …)
 *
 * Requisitos previos:
 *   - MySQL en ejecución; BD 'red_gimnasios' importada desde red_gimnasios.sql
 *   - Conector JDBC + librería org.json en el classpath
 *
 * =============================================================================
 */
public class GestorGimnasio {

    // =========================================================================
    // CONSTANTES DE CONEXIÓN
    //   La BD 'red_gimnasios' debe estar ya creada y poblada con el script SQL.
    // =========================================================================
    private static final String URL      = "jdbc:mysql://localhost:3306";
    private static final String URL_BBDD = "jdbc:mysql://localhost:3306/red_gimnasios";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "";

    private static final String rutaJson = "src\\main\\java\\com\\programacion\\socios_NombreCompletoEstudiante.json"; 
    // Modificar la línea anterior para adaptar a tu contexto

    // =========================================================================
    // MÉTODO MAIN
    //
    //   Ejecuta todas las operaciones requeridas por el enunciado:
    //     1. Gimnasios en Lorca, ordenados por capacidad DESC
    //     2. Gimnasios en Cartagena, ordenados por capacidad ASC
    //     3. Socios cuyo nombre contiene "Nuria"
    //     4. Socios cuyo nombre contiene "Luis"
    //     5. Exportar la tabla 'socio' a un fichero JSON
    // =========================================================================
    public static void main(String[] args) {

        System.out.println("══════════════════════════════════════");
        System.out.println("       GESTOR DE GIMNASIOS  (DAW)     ");
        System.out.println("══════════════════════════════════════\n");

        // 1 ── Gimnasios de Lorca ordenados por capacidad descendente
        System.out.println("── Gimnasios en Lorca (capacidad DESC) ──");
        todosGimnasios("Lorca", "DESC");

        // 2 ── Gimnasios de Cartagena ordenados por capacidad ascendente
        System.out.println("\n── Gimnasios en Cartagena (capacidad ASC) ──");
        todosGimnasios("Cartagena", "ASC");

        // 3 ── Socios que se llaman Nuria
        System.out.println("\n── Socios con nombre 'Nuria' ──");
        sociosPorNombre("Nuria");

        // 4 ── Socios que se llaman Luis
        System.out.println("\n── Socios con nombre 'Luis' ──");
        sociosPorNombre("Luis");

        // 5 ── Exportar tabla 'socio' a fichero JSON
        //      El fichero se guardará en el mismo directorio que el .java
        System.out.println("\n── Exportando tabla 'socio' a JSON ──");
        codificarInfoJson(rutaJson, "socio");
        System.out.println("Fichero JSON generado en: " + rutaJson);
    }


    // =========================================================================
    // MÉTODO ejecutarConsulta
    //
    //   Método GENÉRICO que centraliza toda la lógica de conexión y consulta.
    //   El resto de métodos de la clase solo construyen la sentencia SQL y
    //   delegan en éste la ejecución y visualización de resultados.
    //
    //   Ventajas de este diseño:
    //     · Un único punto donde se abre/cierra la conexión (try-with-resources)
    //     · Cualquier cambio en el formato de salida se hace aquí, una sola vez
    //     · Los métodos específicos quedan limpios: solo construyen el SQL
    //
    //   Cómo funciona:
    //     1. Abre conexión + Statement con try-with-resources
    //     2. Ejecuta el SELECT → obtiene el ResultSet
    //     3. Lee los metadatos del ResultSet para conocer el nº de columnas
    //        y sus nombres (así la tabla es completamente dinámica)
    //     4. Imprime cabecera y filas con printf
    //     5. Al salir del try, los recursos se cierran automáticamente
    //
    //   @param sql  Sentencia SQL SELECT completa y lista para ejecutar
    // =========================================================================
    public static void ejecutarConsulta(String sql) {

        // Anchura fija de cada columna para mantener la alineación
        final int ANCHO = 20;

        try (Connection con = DriverManager.getConnection(URL_BBDD, USUARIO, PASSWORD);
             Statement  st  = con.createStatement();
             ResultSet  rs  = st.executeQuery(sql)) {

            // ResultSetMetaData contiene información sobre las columnas devueltas
            // (nombres, tipos, número de columnas…) sin necesidad de conocerlas a priori
            ResultSetMetaData meta     = rs.getMetaData();
            int               numCols  = meta.getColumnCount();

            // ── Cabecera de la tabla (forma dinámica) - podría realizarse de forma estática ──
            System.out.println("─".repeat(ANCHO * numCols));
            for (int i = 1; i <= numCols; i++) {
                // getColumnName(i) devuelve el nombre de la columna i (indexado en 1)
                System.out.printf("%-" + ANCHO + "s", meta.getColumnName(i).toUpperCase());
            }
            System.out.println();
            System.out.println("─".repeat(ANCHO * numCols));

            // ── Filas de datos ──
            int filas = 0;
            while (rs.next()) {
                for (int i = 1; i <= numCols; i++) {
                    // getString(i) convierte cualquier tipo SQL a String para mostrar
                    String valor = rs.getString(i);
                    String valorStr;
                    if (valor == null) {
                        valorStr = "NULL"; // Representamos los NULL de BD como texto "NULL"
                    } else {
                        valorStr = valor;
                    }
                    System.out.printf("%-" + ANCHO + "s", valorStr);
                }
                System.out.println();
                filas++;
            }

            System.out.println("─".repeat(ANCHO * numCols));
            System.out.println("Registros encontrados: " + filas);

        } catch (SQLException e) {
            System.out.println("Error al ejecutar consulta: " + e.getMessage());
        }
    }


    // =========================================================================
    // MÉTODO todosGimnasios
    //
    //   Consulta todos los gimnasios de una ciudad concreta y los ordena por
    //   capacidad de forma ascendente o descendente según el parámetro recibido.
    //
    //   Construye la sentencia SQL dinámicamente y delega la ejecución en
    //   ejecutarConsulta().
    //
    //   Sentencia base (del enunciado):
    //     SELECT * FROM gimnasio
    //     WHERE ciudad = '<ciudad>'
    //     ORDER BY capacidad <ASC|DESC>;
    //
    //   @param ciudad    Nombre de la ciudad a filtrar (ej: "Lorca", "Cartagena")
    //   @param ascDesc   Dirección del orden: "ASC" o "DESC"
    // =========================================================================
    public static void todosGimnasios(String ciudad, String ascDesc) {

        // Validamos que el parámetro ascDesc sea "ASC" o "DESC"
        // para evitar inyecciones SQL por este campo
        if (!ascDesc.equalsIgnoreCase("ASC") && !ascDesc.equalsIgnoreCase("DESC")) {
            System.out.println("Parámetro ascDesc inválido. Usa 'ASC' o 'DESC'.");
            return;
        }

        // Construimos la sentencia SQL insertando los parámetros dinámicamente.
        // La ciudad va entre comillas simples porque es un valor de texto en SQL.
        String sql = String.format(
            "SELECT * FROM gimnasio WHERE ciudad = '%s' ORDER BY capacidad %s",
            ciudad, ascDesc.toUpperCase()
        );

        // Delegamos la ejecución y visualización en el método genérico
        ejecutarConsulta(sql);
    }


    // =========================================================================
    // MÉTODO sociosPorNombre
    //
    //   Busca socios cuyo nombre contenga la cadena indicada (búsqueda parcial).
    //   Usa el operador LIKE con comodines '%' a ambos lados para buscar el
    //   texto en cualquier posición del nombre.
    //
    //   Sentencia base (del enunciado):
    //     SELECT * FROM socio WHERE nombre LIKE '%<nombre>%';
    //
    //   @param nombre  Texto a buscar dentro del campo 'nombre' de la tabla socio
    // =========================================================================
    public static void sociosPorNombre(String nombre) {

        // El operador LIKE con % permite búsqueda parcial:
        //   '%Nuria%' encuentra "Nuria", "María Nuria", "Nuria García", etc.
        String sql = String.format(
            "SELECT * FROM socio WHERE nombre LIKE '%%%s%%'",
            nombre
        );
        // Nota: en String.format, "%%" produce un literal "%" en el resultado

        ejecutarConsulta(sql);
    }


    // =========================================================================
    // MÉTODO codificarInfoJson
    //
    //   Consulta todos los registros de la tabla indicada y los escribe en un
    //   fichero JSON usando la librería org.json.
    //
    //   Estructura del JSON generado:
    //   [
    //     { "columna1": "valor1", "columna2": "valor2", … },
    //     { "columna1": "valor1", "columna2": "valor2", … },
    //     …
    //   ]
    //
    //   Cómo funciona:
    //     1. Ejecuta SELECT * FROM <tableName>
    //     2. Para cada fila, crea un JSONObject con pares clave-valor
    //        (clave = nombre de columna, valor = dato de la celda)
    //     3. Añade cada JSONObject a un JSONArray
    //     4. Escribe el JSONArray completo en el fichero de texto indicado
    //
    //   @param fullName   Ruta y nombre del fichero JSON de salida
    //   @param tableName  Nombre de la tabla de la BD a exportar
    // =========================================================================
    public static void codificarInfoJson(String fullName, String tableName) {

        String sql = "SELECT * FROM " + tableName;

        // JSONArray actúa como el array raíz del fichero JSON
        JSONArray jsonArray = new JSONArray();

        try (Connection con = DriverManager.getConnection(URL_BBDD, USUARIO, PASSWORD);
             Statement  st  = con.createStatement();
             ResultSet  rs  = st.executeQuery(sql)) {

            ResultSetMetaData meta    = rs.getMetaData();
            int               numCols = meta.getColumnCount();

            // ── Por cada fila del ResultSet creamos un JSONObject ──
            while (rs.next()) {
                JSONObject fila = new JSONObject();

                for (int i = 1; i <= numCols; i++) {
                    String clave = meta.getColumnName(i); // nombre de la columna
                    String valor = rs.getString(i);       // valor como texto

                    if (valor == null) {
                        fila.put(clave, JSONObject.NULL); // Representamos los NULL de BD como JSON null
                    } else {
                        fila.put(clave, valor);
                    }
                }

                // Añadimos el objeto de esta fila al array
                jsonArray.put(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar BD para JSON: " + e.getMessage());
            return;
        }

        // ── Escribimos el JSONArray en el fichero ──
        // toString(2) formatea el JSON con indentación de 2 espacios (legible)
        try (PrintWriter pw = new PrintWriter(new FileWriter(fullName))) {
            pw.println(jsonArray.toString(2));
            System.out.println("JSON escrito correctamente (" +
                               jsonArray.length() + " registros).");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero JSON: " + e.getMessage());
        }
    }
}