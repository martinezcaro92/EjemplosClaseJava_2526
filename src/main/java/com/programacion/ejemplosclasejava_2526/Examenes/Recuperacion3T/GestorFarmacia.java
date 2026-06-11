package com.programacion.examenes_2526.Recuperacion3T.ZZoriginal;
/*
 * =============================================================================
 * Clase: GestorFarmacia
 * Descripción: Gestiona el inventario de una empresa farmacéutica.
 *              Lee los datos del fichero farmacia.json, crea y gestiona
 *              la base de datos MySQL correspondiente, e inserta los
 *              productos de forma dinámica a partir del contenido del JSON.
 *
 * Recursos necesarios en pom.xml:
 *   - org.json:json:20240303          (lectura y escritura de JSON)
 *   - mysql:mysql-connector-java:8.0.33 (conexión con MySQL)
 *
 * Módulo: Programación · CFGS DAW · Curso 2025-26
 * =============================================================================
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

public class GestorFarmacia {

    // =========================================================================
    // CONSTANTES GLOBALES DE CONEXIÓN
    // URL apunta al servidor sin especificar BD, para poder crear/eliminar BDs.
    // Los métodos que operan sobre una BD concreta concatenarán el nombre.
    // =========================================================================
    private static final String URL      = "jdbc:mysql://localhost:3306/";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";


    // =========================================================================
    // MÉTODO: leerJsonTabla
    // Descripción: Lee el fichero farmacia.json y muestra su contenido
    //              en formato tabla por consola. La cabecera se obtiene
    //              dinámicamente de las claves del primer objeto JSON,
    //              por lo que el método se adapta a cualquier estructura.
    // Parámetros:
    //   fullName - ruta completa al fichero farmacia.json
    // =========================================================================
    public static void leerJsonTabla(String fullName) {
        try {
            // Leer el contenido completo del fichero como String
            String contenido = new String(Files.readAllBytes(Paths.get(fullName)));

            // Parsear el String como JSONArray (array de objetos)
            JSONArray productos = new JSONArray(contenido);

            if (productos.isEmpty()) {
                System.out.println("El fichero JSON no contiene registros.");
                return;
            }

            // Obtener las claves del primer objeto para construir la cabecera
            JSONObject primero   = productos.getJSONObject(0);
            String[]   claves    = primero.keySet().toArray(new String[0]);
            int        anchoCampo = 22; // Ancho fijo por columna

            // Imprimir línea separadora superior
            System.out.println("=".repeat(anchoCampo * claves.length));

            // Imprimir cabecera con los nombres de los campos en mayúsculas
            for (String clave : claves) {
                System.out.printf("%-" + anchoCampo + "s", clave.toUpperCase());
            }
            System.out.println();
            System.out.println("=".repeat(anchoCampo * claves.length));

            // Iterar cada objeto del JSONArray e imprimir sus valores
            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);
                for (String clave : claves) {
                    // optString devuelve "" si la clave no existe, evitando NullPointerException
                    System.out.printf("%-" + anchoCampo + "s", producto.optString(clave, "N/A"));
                }
                System.out.println();
            }

            System.out.println("=".repeat(anchoCampo * claves.length));
            System.out.println("Total de productos leídos: " + productos.length());

        } catch (IOException e) {
            System.out.println("Error al leer el fichero JSON: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico en leerJsonTabla: " + e.getMessage());
        }
    }


    // =========================================================================
    // MÉTODO: conexionSeleccion
    // Descripción: Método genérico que ejecuta una sentencia SELECT sobre
    //              la BD y devuelve el ResultSet resultante.
    //              IMPORTANTE: La conexión y el Statement NO se cierran aquí
    //              porque el ResultSet depende de ellos. El método que llame
    //              a éste es responsable de cerrar los recursos al terminar.
    //              Se usa la URL base del servidor sin nombre de BD; el
    //              llamador debe concatenar la BD en la URL si es necesario.
    // Parámetros:
    //   sql - sentencia SELECT completa a ejecutar
    // Retorno:
    //   ResultSet con los resultados, o null si se produce un error
    // =========================================================================
    public static ResultSet conexionSeleccion(String sql) {
        ResultSet rs = null;
        try {
            // Abrimos conexión al servidor; los métodos que necesiten una BD
            // específica deben usar una URL con la BD concatenada
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement  st   = conn.createStatement();

            // executeQuery() se usa exclusivamente para SELECT
            rs = st.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("Error en conexionSeleccion: " + e.getMessage());
        }
        // Se devuelve el ResultSet abierto; el llamador debe cerrarlo
        return rs;
    }


    // =========================================================================
    // MÉTODO: conexionPeticion
    // Descripción: Método genérico que ejecuta sentencias DDL (CREATE, DROP)
    //              y DML de escritura (INSERT, DELETE, UPDATE) sobre la BD.
    //              Cada llamada abre y cierra su propia conexión de forma
    //              segura mediante try-with-resources.
    // Parámetros:
    //   sql - sentencia SQL a ejecutar (CREATE, DROP, INSERT, DELETE...)
    // Retorno:
    //   true  si la sentencia se ejecutó correctamente
    //   false si se produjo algún error
    // =========================================================================
    public static boolean conexionPeticion(String sql) {
        // try-with-resources garantiza el cierre de Connection y Statement
        // aunque se lance una excepción
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement  st   = conn.createStatement()) {

            // executeUpdate() se usa para DDL y DML sin resultado de filas
            st.executeUpdate(sql);
            return true; // Ejecución correcta

        } catch (SQLException e) {
            System.out.println("Error en conexionPeticion: " + e.getMessage());
            return false; // Error en la ejecución
        }
    }


    // =========================================================================
    // MÉTODO: eliminarBbdd
    // Descripción: Elimina la base de datos indicada si existe en el servidor.
    //              Hace uso del método genérico conexionPeticion() para
    //              lanzar la sentencia DROP DATABASE IF EXISTS.
    // Parámetros:
    //   databaseName - nombre de la BD a eliminar
    // Retorno:
    //   true  si la BD fue eliminada (o no existía)
    //   false si se produjo un error
    // =========================================================================
    public static boolean eliminarBbdd(String databaseName) {
        // IF EXISTS evita error si la BD no existía previamente
        String sql    = "DROP DATABASE IF EXISTS " + databaseName;
        boolean exito = conexionPeticion(sql);

        // Informar del resultado por consola
        if (exito) {
            System.out.println("Base de datos '" + databaseName + "' eliminada (o no existía).");
        } else {
            System.out.println("Error al eliminar la base de datos '" + databaseName + "'.");
        }
        return exito;
    }


    // =========================================================================
    // MÉTODO: generarBbdd
    // Descripción: Crea la base de datos indicada en el servidor MySQL.
    //              Usa UTF-8 (utf8mb4) para soportar caracteres especiales.
    //              Hace uso del método genérico conexionPeticion().
    // Parámetros:
    //   databaseName - nombre de la nueva BD a crear
    // Retorno:
    //   true  si la BD fue creada correctamente
    //   false si se produjo un error
    // =========================================================================
    public static boolean generarBbdd(String databaseName) {
        // CHARACTER SET utf8mb4 permite almacenar tildes y caracteres especiales
        String sql    = "CREATE DATABASE " + databaseName + " CHARACTER SET utf8mb4";
        boolean exito = conexionPeticion(sql);

        if (exito) {
            System.out.println("Base de datos '" + databaseName + "' creada correctamente.");
        } else {
            System.out.println("Error al crear la base de datos '" + databaseName + "'.");
        }
        return exito;
    }


    // =========================================================================
    // MÉTODO: generarTabla
    // Descripción: Ejecuta la sentencia CREATE TABLE recibida como argumento.
    //              El llamador es responsable de construir la sentencia SQL
    //              completa con todos los campos y restricciones necesarios.
    //              Hace uso del método genérico conexionPeticion().
    // Parámetros:
    //   sql - sentencia CREATE TABLE completa
    // Retorno:
    //   true  si la tabla fue creada correctamente
    //   false si se produjo un error
    // =========================================================================
    public static boolean generarTabla(String sql) {
        boolean exito = conexionPeticion(sql);

        if (exito) {
            System.out.println("Tabla creada correctamente.");
        } else {
            System.out.println("Error al crear la tabla.");
        }
        return exito;
    }


    // =========================================================================
    // MÉTODO: generarInsertPorProducto
    // Descripción: Construye y devuelve una sentencia INSERT completa para
    //              un producto de la farmacia. Los valores se insertan de
    //              forma dinámica usando String.format().
    //              El campo producto_id se omite porque es AUTO_INCREMENT
    //              en la definición de la tabla: MySQL lo asigna solo.
    //              Este método es llamado una vez por cada objeto del JSON.
    // Parámetros:
    //   codigo_barras    - código EAN del producto
    //   nombre           - nombre comercial
    //   categoria        - grupo terapéutico
    //   principio_activo - sustancia activa del medicamento
    //   precio           - PVP en euros
    //   stock            - unidades disponibles
    //   requiere_receta  - true si necesita prescripción médica
    //   laboratorio      - fabricante o distribuidor
    //   fecha_caducidad  - fecha en formato YYYY-MM-DD
    //   formato          - presentación del producto
    // Retorno:
    //   String con la sentencia INSERT completa lista para ejecutar
    // =========================================================================
    public static String generarInsertPorProducto(
            String  codigo_barras,
            String  nombre,
            String  categoria,
            String  principio_activo,
            double  precio,
            int     stock,
            boolean requiere_receta,
            String  laboratorio,
            String  fecha_caducidad,
            String  formato) {

        // String.format() construye el INSERT de forma dinámica.
        // Los valores de tipo texto van entre comillas simples en SQL.
        // %s → String, %.2f → double con 2 decimales, %d → int, %b → boolean
        return String.format(
            "INSERT INTO producto " +
            "(codigo_barras, nombre, categoria, principio_activo, precio, " +
            " stock, requiere_receta, laboratorio, fecha_caducidad, formato) " +
            "VALUES ('%s', '%s', '%s', '%s', %.2f, %d, %b, '%s', '%s', '%s')",
            codigo_barras,
            nombre,
            categoria,
            principio_activo,
            precio,
            stock,
            requiere_receta,
            laboratorio,
            fecha_caducidad,
            formato
        );
    }


    // =========================================================================
    // MÉTODO: leerJsonInsertar
    // Descripción: Lee el fichero JSON indicado, itera sobre cada objeto
    //              del array y lo inserta en la tabla de la BD especificada.
    //              Por cada objeto:
    //                1. Extrae los campos con optString/optDouble/optInt/optBoolean
    //                2. Llama a generarInsertPorProducto() para construir el SQL
    //                3. Llama a conexionPeticion() para ejecutar el INSERT
    //              Los argumentos databaseName y tableName permiten que el método
    //              sea reutilizable con distintas BDs y tablas sin modificar el código.
    // Parámetros:
    //   fullNameJson  - ruta completa al fichero JSON de entrada
    //   databaseName  - nombre de la BD destino (para informar en los mensajes)
    //   tableName     - nombre de la tabla destino (para informar en los mensajes)
    // =========================================================================
    public static void leerJsonInsertar(String fullNameJson,
                                        String databaseName,
                                        String tableName) {
        try {
            // Leer el fichero JSON completo en un String
            String contenido = new String(Files.readAllBytes(Paths.get(fullNameJson)));

            // Parsear el contenido como JSONArray
            JSONArray productos = new JSONArray(contenido);

            System.out.println("Iniciando inserción de " + productos.length() +
                               " productos en " + databaseName + "." + tableName + "...");

            int insertados = 0;

            // Recorrer todos los objetos del JSONArray
            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);

                // Extraer cada campo con el método opt apropiado según su tipo.
                // optString devuelve "" si la clave no existe (evita NullPointerException).
                String  codigoBarras   = producto.optString("codigo_barras",    "");
                String  nombre         = producto.optString("nombre",           "");
                String  categoria      = producto.optString("categoria",        "");
                String  principioActivo= producto.optString("principio_activo", "");
                double  precio         = producto.optDouble("precio",            0.0);
                int     stock          = producto.optInt("stock",               0);
                boolean requiereReceta = producto.optBoolean("requiere_receta", false);
                String  laboratorio    = producto.optString("laboratorio",      "");
                String  fechaCaducidad = producto.optString("fecha_caducidad",  "");
                String  formato        = producto.optString("formato",          "");

                // Generar la sentencia INSERT dinámicamente
                String sql = generarInsertPorProducto(
                    codigoBarras, nombre, categoria, principioActivo,
                    precio, stock, requiereReceta, laboratorio,
                    fechaCaducidad, formato
                );

                // Ejecutar el INSERT usando el método genérico conexionPeticion()
                boolean exito = conexionPeticion(sql);

                if (exito) {
                    System.out.println("  [OK] Producto insertado: " + nombre);
                    insertados++;
                } else {
                    System.out.println("  [ERROR] No se pudo insertar: " + nombre);
                }
            }

            System.out.println("Inserción completada: " + insertados + "/" +
                               productos.length() + " productos insertados.");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero JSON: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico en leerJsonInsertar: " + e.getMessage());
        }
    }


    // =========================================================================
    // MÉTODO: main
    // Descripción: Punto de entrada de la aplicación. Ejecuta la secuencia
    //              completa de operaciones:
    //                1. Eliminar la BD farmacia si existe
    //                2. Crear la BD farmacia desde cero
    //                3. Crear la tabla producto
    //                4. Insertar los productos desde el JSON
    //                5. Verificar la importación con SELECT COUNT(*)
    // =========================================================================
    public static void main(String[] args) {

        // ── Rutas de ficheros (ajustar según la estructura del proyecto) ──────
        String rutaJson = "src/main/resources/farmacia.json";
        String nombreBD = "farmacia";
        String nombreTabla = "producto";

        // ── Sentencia SQL de creación de la tabla producto ────────────────────
        // Se construye como String para pasarla como argumento a generarTabla()
        String sqlCrearTabla =
            "CREATE TABLE " + nombreBD + "." + nombreTabla + " (" +
            "  producto_id      INT UNSIGNED     NOT NULL AUTO_INCREMENT," +
            "  codigo_barras    VARCHAR(20)      NOT NULL," +
            "  nombre           VARCHAR(120)     NOT NULL," +
            "  categoria        VARCHAR(80)," +
            "  principio_activo VARCHAR(100)," +
            "  precio           DECIMAL(7,2)     NOT NULL," +
            "  stock            INT UNSIGNED     DEFAULT 0," +
            "  requiere_receta  BOOLEAN          DEFAULT FALSE," +
            "  laboratorio      VARCHAR(100)," +
            "  fecha_caducidad  DATE," +
            "  formato          VARCHAR(100)," +
            "  PRIMARY KEY (producto_id)" +
            ")";

        // ── PASO 1: Mostrar el JSON en tabla antes de procesar ─────────────────
        System.out.println("\n===== CONTENIDO DEL FICHERO JSON =====");
        leerJsonTabla(rutaJson);

        // ── PASO 2: Eliminar la BD farmacia si ya existía ─────────────────────
        System.out.println("\n===== ELIMINANDO BASE DE DATOS =====");
        eliminarBbdd(nombreBD);

        // ── PASO 3: Crear la BD farmacia nueva ────────────────────────────────
        System.out.println("\n===== CREANDO BASE DE DATOS =====");
        generarBbdd(nombreBD);

        // ── PASO 4: Crear la tabla producto ───────────────────────────────────
        System.out.println("\n===== CREANDO TABLA =====");
        generarTabla(sqlCrearTabla);

        // ── PASO 5: Leer el JSON e insertar los productos en la BD ────────────
        System.out.println("\n===== INSERTANDO PRODUCTOS =====");
        leerJsonInsertar(rutaJson, nombreBD, nombreTabla);

        // ── PASO 6: Verificar la importación con SELECT COUNT(*) ──────────────
        // Para este SELECT necesitamos conectarnos a la BD 'farmacia' directamente.
        // Se usa una URL específica con la BD concatenada, distinta de la constante URL.
        System.out.println("\n===== VERIFICANDO IMPORTACIÓN =====");
        String urlConBD = URL + nombreBD; // jdbc:mysql://localhost:3306/farmacia
        String sqlCount = "SELECT COUNT(*) AS total FROM " + nombreTabla;

        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(urlConBD, USER, PASSWORD);
             Statement  st   = conn.createStatement()) {

            rs = st.executeQuery(sqlCount);

            if (rs.next()) {
                // getInt("total") lee el alias definido en el SELECT COUNT(*) AS total
                int total = rs.getInt("total");
                System.out.println("Productos importados en la BD: " + total);
            }

        } catch (SQLException e) {
            System.out.println("Error al verificar la importación: " + e.getMessage());
        } finally {
            // Cerrar el ResultSet en finally para garantizar la liberación del recurso
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el ResultSet: " + e.getMessage());
            }
        }
    }
}