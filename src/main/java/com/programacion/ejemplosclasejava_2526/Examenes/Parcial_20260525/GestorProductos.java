package com.programacion.examenes_2526.Parcial_20260525;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * =============================================================================
 * EJERCICIO 3 – Gestor de Productos (ficheros binarios)
 * CFGS DAW | Módulo: Programación
 * =============================================================================
 *
 * Descripción general:
 *   Clase principal que gestiona el catálogo de productos de una tienda de
 *   electrónica. Los productos se persisten en un fichero binario (productos.dat)
 *   mediante serialización Java (ObjectOutputStream / ObjectInputStream).
 *
 * ¿Qué es la serialización?
 *   Proceso de convertir un objeto Java en una secuencia de bytes para
 *   guardarlo en disco o transmitirlo. La deserialización es el proceso inverso.
 *   Requiere que la clase del objeto implemente java.io.Serializable.
 *
 * Ficheros del ejercicio:
 *   · Producto.java        → clase modelo (datos + getters + toString)
 *   · GestorProductos.java → lógica principal (este fichero)
 *   · productos.dat        → fichero binario generado en ejecución
 *
 * =============================================================================
 */
public class GestorProductos {

    // =========================================================================
    // RUTA DEL FICHERO BINARIO
    //   Se define como constante para poder cambiarla fácilmente en un solo punto.
    //   El fichero se creará en el directorio de trabajo actual (donde se ejecuta).
    // =========================================================================
    private static final String RUTA_FICHERO = "src\\main\\java\\com\\programacion\\productos.dat";
    private static ArrayList<Producto> productos = new ArrayList<>();

    // =========================================================================
    // MÉTODO MAIN
    //
    //   Flujo completo según el enunciado:
    //
    //   a) Comprobar si el fichero productos.dat existe:
    //        · Sí existe → leerProductos() para cargar datos previos
    //        · No existe → mensaje informativo
    //
    //   b) Bucle que pregunta "¿Desea generar nuevos productos (s/n)?"
    //        · "s" / "S" → pedirDatosProducto() → escribirProducto()
    //        · "n" / cualquier otra → salir del bucle
    //
    //   c) Los datos de prueba del enunciado se introducen por teclado cuando
    //      el programa está en ejecución.
    // =========================================================================
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("══════════════════════════════════════");
        System.out.println("    GESTOR DE PRODUCTOS  (DAW)        ");
        System.out.println("══════════════════════════════════════\n");

        // ── a) Comprobar si el fichero de datos existe ──────────────────────
        File fichero = new File(RUTA_FICHERO);

        if (fichero.exists()) {
            // El fichero existe → cargamos los productos previos en productos
            System.out.println("Fichero encontrado. Cargando productos existentes…\n");
            leerProductos(RUTA_FICHERO);
        } else {
            // El fichero no existe todavía → primera ejecución
            System.out.println("No existen datos por el momento.\n");
        }

        // ── b) Bucle de alta de nuevos productos ─────────────────────────────
        String respuesta;
        do {
            System.out.print("\n¿Desea generar nuevos productos (s/n)? ");
            respuesta = teclado.nextLine().trim(); //El trim es recomendable pero puede funcionar el código sin él

            if (respuesta.equalsIgnoreCase("s")) {

                // Recogemos los datos del nuevo producto por teclado
                Producto nuevo = pedirDatosProducto(teclado);

                // Lo añadimos a la lista estática de Producto
                productos.add(nuevo);

                // Reescribimos el fichero completo (lista + nuevo producto)
                escribirProducto(RUTA_FICHERO, nuevo);

                System.out.println("\nProducto guardado. Listado actualizado:\n");
                leerProductos(RUTA_FICHERO);

            } else if (!respuesta.equalsIgnoreCase("n")) {
                System.out.println("Respuesta no reconocida. Escribe 's' o 'n'.");
            }

        } while (respuesta.equalsIgnoreCase("s"));

        System.out.println("\nSaliendo del programa. ¡Hasta pronto!");
        teclado.close();
    }


    // =========================================================================
    // MÉTODO pedirDatosProducto
    //
    //   Solicita por teclado todos los atributos de un producto (excepto el id,
    //   que es autoincremental y se asigna automáticamente en el constructor).
    //
    //   Validaciones básicas incluidas:
    //     · precio y stock se parsean a double/int; si el usuario introduce
    //       texto no numérico se muestra un error y se usa valor por defecto.
    //
    //   @param  teclado  Scanner ya abierto sobre System.in
    //   @return          Nuevo objeto Producto con los datos introducidos
    // =========================================================================
    public static Producto pedirDatosProducto(Scanner teclado) {

        System.out.println("\n── Introduce los datos del nuevo producto ──");

        System.out.print("Referencia (ej: REF-001): ");
        String referencia = teclado.nextLine().trim();

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine().trim();

        System.out.print("Categoría: ");
        String categoria = teclado.nextLine().trim();

        // Precio con manejo de error de formato
        int precio = 0;
        System.out.print("Precio (ej: 999): ");
        try {
            precio = Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  Precio inválido, se usará 0");
            precio = 0;
        }

        // Stock con manejo de error de formato
        int stock = 0;
        System.out.print("Stock (unidades): ");
        try {
            stock = Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  Stock inválido, se usará 0.");
        }

        System.out.print("Proveedor: ");
        String proveedor = teclado.nextLine().trim();

        // Disponible → se acepta "s"/"S" para true, cualquier otra cosa es false
        System.out.print("¿Disponible? (s/n): ");
        boolean disponible = teclado.nextLine().trim().equalsIgnoreCase("s");

        // El constructor de Producto asigna el id automáticamente (idCount++)
        return new Producto(referencia, nombre, categoria, precio, stock, proveedor, disponible);
    }


    // =========================================================================
    // MÉTODO escribirProducto
    //
    //   Serializa la lista COMPLETA de productos en el fichero binario.
    //
    //   ¿Por qué reescribimos todo el fichero y no añadimos al final?
    //   ObjectOutputStream añade una cabecera de stream al inicio del fichero.
    //   Si abriéramos con 'append = true' y escribiéramos más objetos,
    //   el fichero tendría múltiples cabeceras y ObjectInputStream fallaría.
    //   La solución es reescribir el fichero entero en cada llamada.
    //
    //   Flujo:
    //     1. Añadimos el nuevo producto a productos (si no estaba ya)
    //     2. Abrimos el fichero en modo escritura (sobreescritura total)
    //     3. Iteramos productos y serializamos cada objeto
    //
    //   @param fullName  Ruta del fichero binario de destino
    //   @param producto  Nuevo producto a añadir (ya debe estar en la lista)
    // =========================================================================
    public static void escribirProducto(String fullName, Producto producto) {

        // Aseguramos que el producto nuevo está en la lista antes de escribir
        if (!productos.contains(producto)) {
            productos.add(producto);
        }

        // FileOutputStream con append=false → sobreescribe el fichero completo
        // ObjectOutputStream → serializa objetos Java a bytes
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(fullName, false))) {

            // Escribimos todos los productos de la lista (incluido el nuevo)
            for (Producto p : productos) {
                oos.writeObject(p);
            }

            System.out.println("  Fichero '" + fullName + "' actualizado (" +
                               productos.size() + " productos).");

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
        }
    }


    // =========================================================================
    // MÉTODO leerProductos
    //
    //   Lee todos los objetos Producto del fichero binario, los guarda en la
    //   lista estática productos y los muestra en formato tabla.
    //
    //   ¿Cómo se sabe cuándo termina el fichero?
    //   ObjectInputStream.readObject() lanza EOFException (End Of File) cuando
    //   no quedan más objetos. La capturamos para terminar el bucle limpiamente.
    //   No es un error; es la forma estándar de detectar el fin del stream.
    //
    //   Cálculos al final:
    //     · Total de productos leídos
    //     · Valor total del inventario = suma(precio × stock) de todos los productos
    //
    //   @param fullName  Ruta del fichero binario a leer
    // =========================================================================
    public static void leerProductos(String fullName) {

        // Limpiamos la lista antes de rellenarla con los datos del fichero
        productos.clear();

        // ObjectInputStream → deserializa los bytes del fichero a objetos Java
        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(fullName))) {

            // ── Cabecera de la tabla (printf para alineación fija) ──
            System.out.println("=".repeat(72));
            System.out.printf("%-5s %-10s %-14s %-12s %-8s %-7s %-10s%n",
                    "ID", "REF", "NOMBRE", "CATEG.", "PRECIO", "STOCK", "DISPONIBLE");
            System.out.println("=".repeat(72));

            int valorInventario = 0;

            // Leemos objetos hasta que el fichero se acabe (EOFException)
            while (true) {
                try {
                    // readObject() devuelve Object → hacemos cast a Producto
                    Producto p = (Producto) ois.readObject();

                    // Guardamos en la lista estática
                    productos.add(p);

                    // Mostramos la fila usando el toString() de Producto
                    System.out.println(p.toString());

                    // Acumulamos el valor del inventario
                    valorInventario += p.getPrecio() * p.getStock();

                } catch (EOFException eof) {
                    // Fin del fichero alcanzado → salimos del bucle normalmente
                    System.out.println("\nFin del fichero alcanzado.");
                    break;
                } catch (ClassNotFoundException cnf) {
                    // La clase Producto no se encontró durante la deserialización
                    System.out.println("Error: clase Producto no encontrada. " + cnf.getMessage());
                    break;
                }
            }

            // ── Pie de tabla con totales ──
            System.out.println("=".repeat(72));
            System.out.println("Total de productos: " + productos.size());
            System.out.printf("Valor total del inventario: %.2f EUR%n", valorInventario);

        } catch (FileNotFoundException e) {
            System.out.println("El fichero '" + fullName + "' no existe todavía.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}