package com.programacion.examenes_2526.Recuperacion3T.ZZoriginal;

/*
 * =============================================================================
 * Clase: GestorVehiculos
 * Descripción: Gestiona el stock de vehículos de un concesionario.
 *              Lee datos desde un fichero CSV (vehiculos.csv), construye
 *              objetos Vehiculo serializables y los persiste en un fichero
 *              binario (vehiculos.dat). Permite además consultar el catálogo
 *              completo en formato tabla y añadir nuevos vehículos por teclado.
 *
 *              Trabaja en conjunto con la clase Vehiculo, que debe estar
 *              en el mismo paquete para poder ser referenciada directamente.
 *
 * Módulo: Programación · CFGS DAW · Curso 2025-26
 * =============================================================================
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class GestorVehiculos {

    // =========================================================================
    // MÉTODO: leerCsvTabla
    // Descripción: Lee el fichero vehiculos.csv y muestra su contenido
    //              completo en formato tabla. La primera línea del CSV
    //              se trata como cabecera; el resto son filas de datos.
    //              El ancho de columna se calcula dinámicamente a partir
    //              del número de campos de la cabecera.
    // Parámetros:
    //   fullName - ruta completa al fichero vehiculos.csv
    // =========================================================================
    public static void leerCsvTabla(String fullName) {
        try {
            Scanner scan = new Scanner(new FileReader(fullName));

            // Leer y procesar la primera línea como cabecera
            String   cabecera = scan.nextLine();
            String[] campos   = cabecera.split(",");

            int anchoCampo = 16; // Ancho fijo por columna para alinear la tabla

            // Imprimir separador y cabecera en mayúsculas
            System.out.println("=".repeat(anchoCampo * campos.length));
            for (String campo : campos) {
                System.out.printf("%-" + anchoCampo + "s", campo.toUpperCase());
            }
            System.out.println();
            System.out.println("=".repeat(anchoCampo * campos.length));

            int numFilas = 0;

            // Iterar todas las líneas de datos del CSV
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue; // Ignorar líneas vacías

                // Separar los valores de la fila usando la coma como delimitador
                // -1 en el límite conserva los campos vacíos al final de la línea
                String[] valores = linea.split(",", -1);

                for (int i = 0; i < campos.length; i++) {
                    // Si la fila tiene menos campos que la cabecera, mostrar "N/A"
                    String valor = (i < valores.length && !valores[i].isBlank())
                                   ? valores[i] : "N/A";
                    System.out.printf("%-" + anchoCampo + "s", valor);
                }
                System.out.println();
                numFilas++;
            }

            System.out.println("=".repeat(anchoCampo * campos.length));
            System.out.println("Total de vehículos en el CSV: " + numFilas);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero CSV no encontrado en " + fullName);
        } catch (Exception e) {
            System.out.println("Error genérico en leerCsvTabla: " + e.getMessage());
        }
    }


    // =========================================================================
    // MÉTODO: generarVehiculo
    // Descripción: Crea y devuelve un objeto Vehiculo a partir de los
    //              argumentos proporcionados. Actúa como factoría: separa
    //              la creación del objeto de la lógica de lectura del CSV
    //              o de la recogida de datos por teclado.
    // Parámetros:   todos los atributos de la clase Vehiculo excepto vehiculo_id
    // Retorno:      nuevo objeto Vehiculo con los datos recibidos
    // =========================================================================
    public static Vehiculo generarVehiculo(String  matricula,
                                           String  marca,
                                           String  modelo,
                                           int     anio,
                                           String  tipo,
                                           String  combustible,
                                           int     kilometros,
                                           double  precio,
                                           String  condicion,
                                           String  color,
                                           int     num_puertas,
                                           int     potencia_cv,
                                           String  proveedor,
                                           boolean disponible) {
        // El constructor de Vehiculo asigna el vehiculo_id automáticamente
        return new Vehiculo(matricula, marca, modelo, anio, tipo, combustible,
                            kilometros, precio, condicion, color,
                            num_puertas, potencia_cv, proveedor, disponible);
    }


    // =========================================================================
    // MÉTODO: leerCsvBinario
    // Descripción: Lee el fichero CSV y por cada fila de datos:
    //                1. Llama a generarVehiculo() para construir el objeto
    //                2. Añade el objeto al ArrayList global Vehiculo.vehiculos
    //              El método NO serializa los objetos al fichero .dat;
    //              esa responsabilidad recae en escribirVehiculo().
    // Parámetros:
    //   fullNameCsv - ruta completa al fichero vehiculos.csv
    //   fullNameDat - ruta completa al fichero vehiculos.dat (para referencia)
    // =========================================================================
    public static void leerCsvBinario(String fullNameCsv, String fullNameDat) {
        try {
            Scanner scan = new Scanner(new FileReader(fullNameCsv));

            // Descartar la primera línea (cabecera del CSV)
            scan.nextLine();

            int contador = 0;

            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;

                // El CSV tiene 15 columnas; campos[0] es vehiculo_id del CSV
                // y se ignora porque el constructor asigna el id con idCount
                String[] campos = linea.split(",");

                // Parsear cada campo al tipo correcto antes de llamar a generarVehiculo
                String  matricula   = campos[1].trim();
                String  marca       = campos[2].trim();
                String  modelo      = campos[3].trim();
                int     anio        = Integer.parseInt(campos[4].trim());
                String  tipo        = campos[5].trim();
                String  combustible = campos[6].trim();
                int     kilometros  = Integer.parseInt(campos[7].trim());
                double  precio      = Double.parseDouble(campos[8].trim());
                String  condicion   = campos[9].trim();
                String  color       = campos[10].trim();
                int     numPuertas  = Integer.parseInt(campos[11].trim());
                int     potenciaCv  = Integer.parseInt(campos[12].trim());
                String  proveedor   = campos[13].trim();
                // Boolean.parseBoolean("true") → true; cualquier otro valor → false
                boolean disponible  = Boolean.parseBoolean(campos[14].trim());

                // Crear el objeto Vehiculo usando el método factoría
                Vehiculo v = generarVehiculo(matricula, marca, modelo, anio, tipo,
                                             combustible, kilometros, precio, condicion,
                                             color, numPuertas, potenciaCv,
                                             proveedor, disponible);

                // Añadir el vehículo al ArrayList global
                Vehiculo.vehiculos.add(v);
                System.out.println("  Leído del CSV: " + v.getMarca() + " " + v.getModelo());
                contador++;
            }

            System.out.println("Total vehículos cargados desde CSV: " + contador);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero CSV no encontrado. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir un campo numérico: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico en leerCsvBinario: " + e.getMessage());
        }
    }


    // =========================================================================
    // MÉTODO: datosVehiculo
    // Descripción: Solicita al usuario los datos de un vehículo por teclado,
    //              construye el objeto con generarVehiculo() y lo añade
    //              al ArrayList global Vehiculo.vehiculos.
    // Retorno:      objeto Vehiculo con los datos introducidos por el usuario
    // =========================================================================
    public static Vehiculo datosVehiculo() {
        // Usamos System.in para leer desde la terminal
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- Introduce los datos del nuevo vehículo ---");

        System.out.print("Matrícula: ");
        String matricula = teclado.nextLine();

        System.out.print("Marca: ");
        String marca = teclado.nextLine();

        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();

        System.out.print("Año de fabricación: ");
        int anio = Integer.parseInt(teclado.nextLine().trim());

        System.out.print("Tipo (Turismo/SUV/Utilitario...): ");
        String tipo = teclado.nextLine();

        System.out.print("Combustible (Gasolina/Diesel/Híbrido/Eléctrico): ");
        String combustible = teclado.nextLine();

        System.out.print("Kilómetros: ");
        int kilometros = Integer.parseInt(teclado.nextLine().trim());

        System.out.print("Precio (PVP en euros): ");
        double precio = Double.parseDouble(teclado.nextLine().trim());

        System.out.print("Condición (nuevo/segunda_mano): ");
        String condicion = teclado.nextLine();

        System.out.print("Color: ");
        String color = teclado.nextLine();

        System.out.print("Número de puertas: ");
        int numPuertas = Integer.parseInt(teclado.nextLine().trim());

        System.out.print("Potencia (CV): ");
        int potenciaCv = Integer.parseInt(teclado.nextLine().trim());

        System.out.print("Proveedor: ");
        String proveedor = teclado.nextLine();

        System.out.print("¿Disponible para la venta? (true/false): ");
        // Boolean.parseBoolean acepta "true" (insensible a mayúsculas); todo lo demás es false
        boolean disponible = Boolean.parseBoolean(teclado.nextLine().trim());

        // Crear y devolver el objeto Vehiculo usando el método factoría
        Vehiculo v = generarVehiculo(matricula, marca, modelo, anio, tipo, combustible,
                                     kilometros, precio, condicion, color,
                                     numPuertas, potenciaCv, proveedor, disponible);

        // Añadir el nuevo vehículo al ArrayList global para mantener la lista actualizada
        Vehiculo.vehiculos.add(v);

        return v;
    }


    // =========================================================================
    // MÉTODO: leerVehiculos
    // Descripción: Lee todos los objetos Vehiculo del fichero binario .dat,
    //              los almacena en el ArrayList global Vehiculo.vehiculos y
    //              los muestra en formato tabla por consola.
    //              Si el fichero no existe, muestra un mensaje informativo.
    //              La lectura termina al capturar EOFException, que indica
    //              que no quedan más objetos en el flujo binario.
    // Parámetros:
    //   fullName - ruta completa al fichero vehiculos.dat
    // =========================================================================
    public static void leerVehiculos(String fullName) {

        // ── Paso 1: Comprobar existencia del fichero ANTES de abrirlo ─────────
        // Si no se comprueba aquí, se lanzaría FileNotFoundException dentro del try
        // en lugar de mostrar el mensaje amigable al usuario.
        File archivo = new File(fullName);
        if (!archivo.exists()) {
            System.out.println("No existen datos por el momento.");
            return; // Salir del método sin intentar abrir el stream
        }

        // Limpiar el ArrayList global antes de leer para evitar duplicados
        // si este método se llama varias veces en la misma ejecución
        Vehiculo.vehiculos.clear();

        int contador = 0;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));

            // Imprimir cabecera de la tabla con printf()
            System.out.println("=".repeat(155));
            System.out.printf(
                "%-5s %-9s %-11s %-11s %-6s %-11s %-10s %-8s %-10s %-12s %-8s %-6s %-5s %-18s %-5s%n",
                "ID","MATRIC.","MARCA","MODELO","AÑO","TIPO","COMB.",
                "KM","PRECIO","CONDICION","COLOR","PTAS","CV","PROVEEDOR","DISP."
            );
            System.out.println("=".repeat(155));

            // Leer objetos en bucle infinito hasta que EOFException indique el fin
            while (true) {
                // El cast a Vehiculo puede lanzar ClassNotFoundException si la clase
                // no está disponible; se captura en el bloque catch genérico
                Vehiculo v = (Vehiculo) ois.readObject();

                // Almacenar en el ArrayList global
                Vehiculo.vehiculos.add(v);

                // Imprimir la fila usando el toString() formateado del objeto
                System.out.println(v.toString());
                contador++;
            }

        } catch (EOFException e) {
            // EOFException es la forma normal de finalizar la lectura de un .dat;
            // no es un error, por lo que no se imprime ningún mensaje de fallo
            System.out.println("=".repeat(155));
            System.out.println("Total de vehículos leídos del fichero binario: " + contador);

        } catch (FileNotFoundException e) {
            // Este catch no debería alcanzarse gracias a la comprobación inicial,
            // pero se incluye como salvaguarda
            System.out.println("Error: fichero no encontrado. " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error genérico en leerVehiculos: " + e.getMessage());

        } finally {
            // Cerrar el stream en finally para garantizar la liberación de recursos
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar ObjectInputStream: " + e.getMessage());
            }
        }
    }


    // =========================================================================
    // MÉTODO: escribirVehiculo
    // Descripción: Serializa el vehículo recibido junto con todos los
    //              vehículos existentes en el ArrayList global.
    //              Proceso:
    //                1. El vehículo nuevo YA debe estar en Vehiculo.vehiculos
    //                   (añadido por datosVehiculo() antes de llamar aquí)
    //                2. Se abre el fichero en modo sobreescritura (append=false)
    //                3. Se serializa TODO el ArrayList, reemplazando el .dat anterior
    //              Esto garantiza que el fichero binario siempre refleja el
    //              estado completo y actualizado de la lista.
    // Parámetros:
    //   fullName - ruta completa al fichero vehiculos.dat
    //   vehiculo - objeto Vehiculo a añadir (ya incluido en Vehiculo.vehiculos)
    // =========================================================================
    public static void escribirVehiculo(String fullName, Vehiculo vehiculo) {
        ObjectOutputStream oos = null;

        try {
            // false en FileOutputStream → sobreescribir el fichero desde cero
            // Esto reemplaza el contenido anterior con la lista actualizada completa
            oos = new ObjectOutputStream(new FileOutputStream(fullName, false));

            // Serializar todos los vehículos del ArrayList (incluido el nuevo)
            for (Vehiculo v : Vehiculo.vehiculos) {
                oos.writeObject(v);
            }

            System.out.println("Fichero " + fullName + " actualizado. " +
                               "Total de vehículos: " + Vehiculo.vehiculos.size());

        } catch (FileNotFoundException e) {
            System.out.println("Error: ruta no encontrada. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero binario: " + e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar ObjectOutputStream: " + e.getMessage());
            }
        }
    }


    // =========================================================================
    // MÉTODO: main
    // Descripción: Punto de entrada de la aplicación. Ejecuta el flujo
    //              completo de gestión del catálogo de vehículos:
    //                a) Mostrar CSV en tabla
    //                b) Intentar leer el .dat (a priori no existe)
    //                c) Importar CSV al .dat
    //                d) Mostrar el .dat actualizado y verificar que hay datos
    //                e) Permitir añadir nuevos vehículos de forma interactiva
    // =========================================================================
    public static void main(String[] args) {

        // ── Rutas de ficheros (ajustar según la estructura del proyecto) ──────
        String rutaCsv = "src/main/resources/vehiculos.csv";
        String rutaDat = "src/main/resources/vehiculos.dat";

        Scanner teclado = new Scanner(System.in);

        // ── PASO a: Mostrar el contenido del fichero CSV en tabla ─────────────
        System.out.println("\n===== CONTENIDO DEL FICHERO CSV =====");
        leerCsvTabla(rutaCsv);

        // ── PASO b: Intentar leer el fichero binario (a priori no existe) ─────
        System.out.println("\n===== LEYENDO FICHERO BINARIO (estado inicial) =====");
        leerVehiculos(rutaDat); // Debe mostrar "No existen datos por el momento."

        // ── PASO c: Importar los datos del CSV al ArrayList y persistirlos ────
        System.out.println("\n===== IMPORTANDO CSV AL FICHERO BINARIO =====");
        leerCsvBinario(rutaCsv, rutaDat);

        // Después de leerCsvBinario el ArrayList tiene los vehículos del CSV;
        // hay que persistirlos en el .dat escribiendo el ArrayList completo.
        // Usamos el primer elemento como referencia (el .dat aún no existe)
        if (!Vehiculo.vehiculos.isEmpty()) {
            // Crear el fichero .dat con todos los vehículos del ArrayList
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(
                          new FileOutputStream(rutaDat, false));
                for (Vehiculo v : Vehiculo.vehiculos) {
                    oos.writeObject(v);
                }
                System.out.println("Fichero vehiculos.dat creado con " +
                                   Vehiculo.vehiculos.size() + " vehículos.");
            } catch (IOException e) {
                System.out.println("Error al crear vehiculos.dat: " + e.getMessage());
            } finally {
                try { if (oos != null) oos.close(); } catch (IOException e) { }
            }
        }

        // ── PASO d: Leer el .dat actualizado y verificar que hay datos ────────
        System.out.println("\n===== LEYENDO FICHERO BINARIO (tras importación) =====");
        leerVehiculos(rutaDat);

        // Verificar que el ArrayList no está vacío tras la importación
        if (Vehiculo.vehiculos.size() > 0) {
            System.out.println("Verificación OK: " + Vehiculo.vehiculos.size() +
                               " vehículos cargados en memoria.");
        } else {
            System.out.println("Verificación FALLIDA: no hay vehículos en memoria.");
        }

        // ── PASO e: Bucle interactivo para añadir nuevos vehículos ────────────
        String respuesta;
        do {
            System.out.print("\n¿Desea generar nuevos vehiculos (s/n)? ");
            respuesta = teclado.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                // datosVehiculo() recoge los datos, crea el objeto y lo añade
                // automáticamente al ArrayList global Vehiculo.vehiculos
                Vehiculo nuevoVehiculo = datosVehiculo();

                // Persistir el ArrayList completo (con el nuevo vehículo incluido)
                // en el fichero binario, sobreescribiéndolo por completo
                escribirVehiculo(rutaDat, nuevoVehiculo);

                // Confirmar la adición mostrando el catálogo actualizado
                System.out.println("\n--- Catálogo actualizado ---");
                leerVehiculos(rutaDat);
            }

        } while (respuesta.equalsIgnoreCase("s"));

        // Mensaje de cierre al salir del bucle
        System.out.println("Programa finalizado. Hasta pronto.");
        teclado.close();
    }
}