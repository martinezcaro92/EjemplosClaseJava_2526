package com.programacion.ejemplosclasejava_2526.BBDD.EjemploConexion;
import java.sql.*;

/**
 * Ejemplo de acceso a una base de datos MySQL desde Java.
 *
 * Se muestran cuatro formas distintas de realizar un INSERT y dos formas
 * de realizar un SELECT, todo ello sobre la tabla 'Personas' de la BD 'personas'.
 *
 * REQUISITOS PREVIOS:
 *   - MySQL en ejecución en localhost:3306.
 *   - Base de datos 'personas' creada con la tabla 'Personas' que tenga las
 *     columnas: id (INT AUTO_INCREMENT PRIMARY KEY), nombre (VARCHAR),
 *              apellidos (VARCHAR), edad (INT).
 *   - Usuario y contraseña correctos en las variables url/username/password.
 */
public class EjemploAccesoBD {

    public static void main(String[] args) throws SQLException {

        // ─────────────────────────────────────────────────────────────────────
        // CONFIGURACIÓN DE LA CONEXIÓN
        // ─────────────────────────────────────────────────────────────────────

        // Cadena de conexión JDBC: define el protocolo (jdbc:mysql), el host
        // (localhost), el puerto (3306) y el nombre de la base de datos (personas)
        String url = "jdbc:mysql://localhost:3306/personas";

        // Credenciales del usuario con permisos sobre la base de datos
        String username = "root";
        String password = "RootPass123!";

        // Statement: objeto que envía sentencias SQL al servidor de base de datos.
        // Se declara fuera del try para poder cerrarlo en el bloque finally.
        Statement statement = null;

        // ResultSet: objeto que almacena las filas devueltas por un SELECT.
        // También se declara fuera del try para cerrarlo de forma segura en finally.
        ResultSet rs = null;

        // try-with-resources: garantiza que la conexión (conn) se cierre
        // automáticamente al salir del bloque, aunque se produzca una excepción.
        // DriverManager.getConnection() lanza SQLException si no puede conectar.
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            System.out.println("Conexión exitosa a MySQL.\n");

            // Creamos el Statement a partir de la conexión activa.
            // Este objeto será el que ejecute las sentencias SQL.
            statement = conn.createStatement();


            // =================================================================
            // CASO 1 — INSERT: Sentencia SQL escrita como String literal (fijo)
            // =================================================================
            // La forma más directa: toda la sentencia está escrita a mano.
            // - executeUpdate() se usa para INSERT, UPDATE y DELETE (no devuelve filas).
            // - NULL en 'id' indica que MySQL debe asignar el valor automáticamente
            //   gracias a la propiedad AUTO_INCREMENT de esa columna.
            statement.executeUpdate("INSERT INTO Personas VALUES(NULL,'David','Costa',19)");
            System.out.println("CASO 1: Registro 'David Costa' insertado.");


            // =================================================================
            // CASO 2 — INSERT: Construcción del SQL con String.format()
            // =================================================================
            // Cuando los valores vienen de variables Java, String.format() permite
            // construir la sentencia de forma más legible usando marcadores:
            //   %s  → se sustituye por el valor de un String
            //   %d  → se sustituye por el valor de un entero (int)
            // Las comillas simples alrededor de %s son necesarias en SQL para
            // delimitar los valores de tipo texto.
            String nombre   = "Martita";
            String apellido = "Gris";
            int edad        = 20;

            String sql = String.format(
                "INSERT INTO Personas VALUES (NULL,'%s','%s',%d)",
                nombre, apellido, edad
            );
            statement.executeUpdate(sql);
            System.out.println("CASO 2: Registro '" + nombre + " " + apellido + "' insertado con String.format().");


            // =================================================================
            // CASO 3 — INSERT: Construcción del SQL con concatenación (+)
            // =================================================================
            // Otra forma habitual de insertar variables en una cadena SQL.
            // Se "pegan" partes fijas del String con los valores de las variables
            // usando el operador +.
            // AVISO: si los valores provinieran de un usuario externo, este método
            // sería vulnerable a SQL Injection. En producción se usa PreparedStatement.
            statement.executeUpdate(
                "INSERT INTO Personas VALUES (NULL,'" + nombre + "','" + apellido + "'," + edad + ")"
            );
            System.out.println("CASO 3: Registro '" + nombre + " " + apellido + "' insertado con concatenación (+).");


            // =================================================================
            // CASO 4 — INSERT: Inserción múltiple recorriendo arrays con un bucle
            // =================================================================
            // Cuando hay varios registros a insertar, usar arrays + bucle evita
            // repetir la sentencia executeUpdate() una vez por cada fila.
            //
            // Se usa null en Java para representar el valor SQL NULL (ausencia de dato).
            // Al concatenar null con un String en Java, el resultado es la cadena "null",
            // que el motor SQL interpreta como el valor NULL (sin comillas, sin texto).
            String[] nombres   = {"Alfredo", "Dario",  "Jose Manuel"};  // La columna nombre no puede tomar valores nulos
            String[] apellidos = {"Perez",   "Olmos",  null};   // null → SQL NULL
            String[] edades    = {"19",       "56",    null};   // null → SQL NULL

            System.out.println("CASO 4: Insertando múltiples registros...");
            for (int i = 0; i < nombres.length; i++) {

                if (apellidos[i] == null) {
                    // Cuando el apellido es null se escribe directamente (sin comillas)
                    // para que SQL lo trate como NULL y no como el texto "null"
                    statement.executeUpdate(
                        "INSERT INTO Personas VALUES (NULL, '" + nombres[i] + "',"
                        + apellidos[i] + "," + edades[i] + ")"
                    );
                } else {
                    // Cuando el apellido tiene valor real se rodea de comillas simples
                    statement.executeUpdate(
                        "INSERT INTO Personas VALUES (NULL, '" + nombres[i] + "','"
                        + apellidos[i] + "'," + edades[i] + ")"
                    );
                }
                System.out.println("  → Registro '" + nombres[i] + "' insertado.");
            }


            // =================================================================
            // CASO 5 — SELECT: Obtener TODOS los campos con SELECT *
            // =================================================================
            // executeQuery() se usa para sentencias SELECT; devuelve un ResultSet
            // con todas las filas que cumplen la condición (aquí, todas las filas).
            //
            // SELECT * recupera TODAS las columnas de la tabla.
            //
            // El cursor del ResultSet empieza ANTES de la primera fila.
            // rs.next() lo avanza a la siguiente fila y devuelve:
            //   true  → hay fila disponible (se entra en el cuerpo del while)
            //   false → no quedan más filas (el bucle termina)
            //
            // rs.getInt("columna")    → obtiene el valor entero de la columna indicada
            // rs.getString("columna") → obtiene el valor texto de la columna indicada
            System.out.println("\n--- CASO 5: SELECT * (todos los campos) ---");
            rs = statement.executeQuery("SELECT * FROM Personas");
            while (rs.next()) {
                int id             = rs.getInt("id");
                String nombreSel   = rs.getString("nombre");
                String apellidoSel = rs.getString("apellidos");
                int edadSel        = rs.getInt("edad");
                System.out.printf("%d : %s %s, %d años%n", id, nombreSel, apellidoSel, edadSel);
            }
            // Cerramos el ResultSet antes de reutilizar la variable 'rs' en el siguiente caso
            rs.close();


            // =================================================================
            // CASO 6 — SELECT: Obtener únicamente campos concretos
            // =================================================================
            // En lugar de *, se listan exactamente las columnas que necesitamos.
            // Ventaja: más eficiente en tablas con muchas columnas, ya que el
            // servidor solo transmite los datos realmente necesarios.
            // En este caso se omite la columna 'edad' intencionalmente.
            System.out.println("\n--- CASO 6: SELECT con campos concretos (sin columna edad) ---");
            rs = statement.executeQuery("SELECT id, nombre, apellidos FROM Personas");
            while (rs.next()) {
                int id             = rs.getInt("id");
                String nombreSel   = rs.getString("nombre");
                String apellidoSel = rs.getString("apellidos");
                System.out.printf("%d : %s %s%n", id, nombreSel, apellidoSel);
            }

        } catch (SQLException ex) {
            // SQLException se lanza cuando algo falla en la comunicación con la BD:
            // credenciales incorrectas, tabla inexistente, sintaxis SQL errónea, etc.
            // ex.getMessage() devuelve una descripción legible del error.
            System.out.println("Error al conectar o ejecutar SQL: " + ex.getMessage());

        } finally {
            // El bloque finally se ejecuta SIEMPRE, haya excepción o no.
            // Aquí liberamos los recursos de la BD para evitar fugas de memoria
            // y conexiones colgadas en el servidor.
            if (rs != null)        rs.close();
            if (statement != null) statement.close();
        }
    }
}
