package com.programacion.examenes_2526.RecuperaciónExtraordinaria.UT6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ============================================================
 *  Clase gestora: GestorHoteles
 * ============================================================
 * Centraliza todas las operaciones sobre objetos Hotel:
 *   - Lectura desde fichero binario (.dat)
 *   - Escritura / persistencia en fichero binario
 *   - Recogida de datos por teclado
 *   - Impresión del catálogo en formato tabla
 *
 * Trabaja conjuntamente con Hotel.java, que debe estar en el
 * mismo paquete para poder referenciarse directamente.
 * ============================================================
 */
public class GestorHoteles {

    // ── Constante: ruta del fichero binario ───────────────────
    // Modifica este valor si hoteles.dat está en otra ruta.
    // Durante el desarrollo en NetBeans se recomienda colocar
    // el fichero en el directorio raíz del proyecto y usar
    // una ruta relativa como la que aparece aquí.
    private static final String RUTA_DAT = "src\\main\\java\\com\\programacion\\examenes_2526\\RecuperaciónExtraordinaria\\UT6\\hoteles.dat";

    // ── Scanner global ────────────────────────────────────────
    // Se declara como atributo estático de clase para que todos
    // los métodos compartan el mismo objeto Scanner sobre System.in.
    // Crear varios Scanner sobre System.in provoca conflictos y
    // puede lanzar NoSuchElementException al leer por teclado.
    private static final Scanner sc = new Scanner(System.in);

    // ── Variable global: lista de hoteles en memoria ──────────
    // Almacena los objetos Hotel leídos del fichero .dat.
    // Es la fuente de verdad en memoria durante la ejecución:
    //   - leerHoteles()  la rellena al arrancar.
    //   - datosHotel()   añade nuevos elementos.
    //   - escribirHotel() la recorre para reescribir el fichero.
    private static ArrayList<Hotel> hoteles = new ArrayList<>();


    // =========================================================
    //  MÉTODO: generarHotel
    // =========================================================
    /**
     * Fábrica centralizada de objetos Hotel.
     *
     * Crea y devuelve un nuevo objeto Hotel a partir de los
     * argumentos recibidos. El resto de métodos (datosHotel,
     * leerCsvBinario, etc.) no instancian Hotel directamente,
     * sino que delegan en este método. Así, si la firma del
     * constructor cambia, solo hay que actualizar aquí.
     *
     * @param nombre              Nombre comercial del hotel
     * @param ciudad              Ciudad de ubicación
     * @param categoria_estrellas Número de estrellas (1-5)
     * @param precio_noche        Precio por noche en euros
     * @param tiene_piscina       true si dispone de piscina
     * @return Objeto Hotel construido con los datos recibidos
     */
    public static Hotel generarHotel(String nombre,
                                     String ciudad,
                                     int categoria_estrellas,
                                     double precio_noche,
                                     boolean tiene_piscina) {
        // Delegar la creación al constructor de Hotel
        return new Hotel(nombre, ciudad, categoria_estrellas,
                         precio_noche, tiene_piscina);
    }


    // =========================================================
    //  MÉTODO: leerHoteles
    // =========================================================
    /**
     * Lee todos los objetos Hotel serializados en el fichero
     * binario indicado por fullName, los almacena en la variable
     * global 'hoteles' y los imprime en formato tabla.
     *
     * Flujo interno:
     *   1. Verifica si el fichero existe (File.exists()).
     *      Si no existe → mensaje informativo y retorno.
     *   2. Limpia la lista global para evitar duplicados.
     *   3. Abre ObjectInputStream y lee objetos en bucle.
     *   4. Cada objeto se añade a la lista global.
     *   5. EOFException indica el fin del fichero → rompe bucle.
     *   6. Imprime cabecera con printf() y filas con toString().
     *
     * Por qué EOFException y no un bucle con condición:
     *   La serialización Java no incluye un marcador de "fin de
     *   objetos". La única forma de saber que se ha llegado al
     *   final es capturar EOFException, que Java lanza cuando
     *   readObject() intenta leer más allá del último objeto.
     *
     * @param fullName Ruta completa del fichero hoteles.dat
     */
    public static void leerHoteles(String fullName) {

        // ── 1. Comprobar si el fichero existe ─────────────────
        File fichero = new File(fullName);
        if (!fichero.exists()) {
            // Fichero no encontrado: informar y terminar
            System.out.println("No existen datos por el momento.");
            return;
        }

        // ── 2. Limpiar la lista antes de rellenarla ───────────
        // Evita que al llamar varias veces a leerHoteles()
        // se acumulen duplicados en la variable global.
        hoteles.clear();

        // ── 3. Leer objetos del stream binario ────────────────
        // try-with-resources: cierra el stream automáticamente
        // al salir del bloque, aunque ocurra una excepción.
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fichero))) {

            // Bucle infinito: se rompe al capturar EOFException
            while (true) {
                try {
                    // Leer el siguiente objeto y castearlo a Hotel
                    Hotel h = (Hotel) ois.readObject();
                    // Almacenar en la variable global
                    hoteles.add(h);

                } catch (EOFException eof) {
                    // Fin de fichero alcanzado: salir del bucle
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error de E/S al leer el fichero: "
                    + e.getMessage());
            return;
        } catch (ClassNotFoundException e) {
            // Ocurre si la clase Hotel no coincide con la
            // serializada (serialVersionUID distinto u otra causa)
            System.out.println("Clase Hotel no encontrada: "
                    + e.getMessage());
            return;
        }

        // ── 4. Verificar que se han leído objetos ─────────────
        if (hoteles.isEmpty()) {
            System.out.println("El fichero existe pero no contiene hoteles.");
            return;
        }

        // ── 5. Imprimir en formato tabla ──────────────────────
        // Cabecera con printf() para alinear columnas
        System.out.println();
        System.out.printf("%-5s %-30s %-25s %-10s %-14s %-6s%n",
                "ID", "Nombre", "Ciudad",
                "Estrellas", "Precio/noche", "Piscina");
        System.out.println("=".repeat(95));

        // Cada fila usa el toString() de Hotel, que ya aplica
        // String.format() con anchos fijos idénticos a la cabecera
        for (Hotel h : hoteles) {
            System.out.println(h);
        }

        System.out.println("=".repeat(95));
        System.out.printf("Total hoteles cargados: %d%n%n",
                hoteles.size());
    }


    // =========================================================
    //  MÉTODO: datosHotel
    // =========================================================
    /**
     * Solicita al usuario los datos de un nuevo hotel por teclado,
     * construye el objeto Hotel llamando a generarHotel() y lo
     * añade a la variable global 'hoteles'.
     *
     * Consideraciones de lectura por teclado:
     *   - Se usa el Scanner global 'sc' (no uno nuevo) para
     *     evitar conflictos con System.in.
     *   - nextLine() permite leer cadenas con espacios.
     *   - Integer.parseInt() y Double.parseDouble() sobre
     *     nextLine() evitan el problema del salto de línea
     *     pendiente que ocurre con nextInt() y nextDouble().
     *   - Para el booleano se acepta "s" o "S" como verdadero.
     *
     * @return Objeto Hotel creado con los datos del usuario
     */
    public static Hotel datosHotel() {

        System.out.println();
        System.out.println("=== Registro de nuevo hotel ===");

        // ── Leer nombre ───────────────────────────────────────
        System.out.print("Nombre del hotel         : ");
        String nombre = sc.nextLine().trim();

        // ── Leer ciudad ───────────────────────────────────────
        System.out.print("Ciudad                   : ");
        String ciudad = sc.nextLine().trim();

        // ── Leer categoría (1-5 estrellas) ────────────────────
        System.out.print("Categoría estrellas (1-5): ");
        int categoria = Integer.parseInt(sc.nextLine().trim());

        // ── Leer precio por noche ─────────────────────────────
        System.out.print("Precio por noche (€)     : ");
        double precio = Double.parseDouble(sc.nextLine().trim());

        // ── Leer si tiene piscina ─────────────────────────────
        System.out.print("¿Tiene piscina? (s/n)    : ");
        String respPiscina = sc.nextLine().trim();
        // Se considera afirmativo solo "s" o "S"
        boolean piscina = respPiscina.equalsIgnoreCase("s");

        // ── Crear el objeto Hotel usando generarHotel ─────────
        Hotel nuevoHotel = generarHotel(nombre, ciudad,
                                        categoria, precio, piscina);

        // ── Añadir a la variable global ───────────────────────
        // datosHotel() añade el hotel a 'hoteles' ANTES de que
        // escribirHotel() reescriba el fichero, de modo que la
        // lista ya incluye el nuevo elemento cuando se serializa.
        hoteles.add(nuevoHotel);

        System.out.println("Hotel registrado correctamente.");
        return nuevoHotel;
    }


    // =========================================================
    //  MÉTODO: escribirHotel
    // =========================================================
    /**
     * Serializa TODOS los hoteles de la variable global en el
     * fichero indicado por fullName, sobrescribiendo el contenido
     * anterior por completo.
     *
     * Por qué se reescribe el fichero entero en cada llamada:
     *   La API de serialización Java no permite "añadir" un objeto
     *   al final de un ObjectOutputStream ya existente sin que las
     *   cabeceras del stream queden corruptas. La solución estándar
     *   es sobrescribir el fichero desde cero en cada escritura,
     *   usando la lista global como fuente de todos los datos.
     *
     * Flujo interno:
     *   1. Abre FileOutputStream sin flag 'append' → sobreescribe.
     *   2. Envuelve con ObjectOutputStream para serialización.
     *   3. Recorre 'hoteles' (que ya incluye el nuevo objeto,
     *      añadido previamente en datosHotel()) y serializa cada uno.
     *   4. El stream se cierra automáticamente (try-with-resources).
     *
     * @param fullName Ruta completa del fichero hoteles.dat
     * @param hotel    Último objeto Hotel añadido (ya en la lista)
     */
    public static void escribirHotel(String fullName, Hotel hotel) {

        // try-with-resources: cierra el stream al terminar
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fullName))) {

            // Serializar cada objeto de la lista global
            // (la lista ya incluye el nuevo hotel de datosHotel)
            for (Hotel h : hoteles) {
                oos.writeObject(h);
            }

            System.out.printf(
                "Fichero '%s' actualizado correctamente. " +
                "Total hoteles almacenados: %d%n",
                fullName, hoteles.size());

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: "
                    + e.getMessage());
        }
    }


    // =========================================================
    //  MÉTODO: main
    // =========================================================
    /**
     * Punto de entrada de la aplicación.
     *
     * Secuencia de operaciones:
     *   1. Leer el fichero .dat y mostrar el catálogo existente.
     *   2. Verificar que la lista global no está vacía.
     *   3. Bucle interactivo para registrar nuevos hoteles:
     *        s / si  → datosHotel() + escribirHotel() + mostrar
     *        n / no  → salir del programa
     *        otro    → avisar y repetir la pregunta
     *
     * @param args Argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {

        // ── 1. Leer hoteles del fichero .dat ──────────────────
        // El fichero hoteles.dat proporcionado ya contiene 10
        // objetos Hotel. leerHoteles() los carga en la lista
        // global y los imprime en formato tabla.
        System.out.println("Cargando catálogo de hoteles...");
        leerHoteles(RUTA_DAT);

        // ── 2. Verificar que se han cargado hoteles ───────────
        if (hoteles.isEmpty()) {
            // La lista está vacía: el fichero no existe o está
            // vacío. Se avisa pero el programa continúa para
            // permitir registrar el primer hotel.
            System.out.println("Advertencia: no se han cargado " +
                    "hoteles. Comprueba que hoteles.dat está en: "
                    + RUTA_DAT);
        } else {
            System.out.println("Hoteles cargados en memoria: "
                    + hoteles.size());
        }

        // ── 3. Bucle interactivo ──────────────────────────────
        // Pregunta si se desea registrar un nuevo hotel.
        // Acepta: s, S, si, SI (afirmativo) / n, N, no, NO (negativo)
        String respuesta;
        do {
            System.out.print("¿Desea registrar un nuevo hotel (s/n)? ");
            respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("s") || respuesta.equals("si")) {

                // ── a) Solicitar datos del nuevo hotel ────────
                // datosHotel() lee los campos por teclado,
                // crea el objeto y lo añade a la lista global.
                Hotel nuevoHotel = datosHotel();

                // ── b) Persistir: reescribir el fichero .dat ──
                // escribirHotel() sobreescribe hoteles.dat con
                // todos los elementos de la lista global,
                // incluido el recién creado.
                escribirHotel(RUTA_DAT, nuevoHotel);

                // ── c) Mostrar el catálogo actualizado ────────
                System.out.println("Catálogo actualizado:");
                leerHoteles(RUTA_DAT);

            } else if (respuesta.equals("n")
                    || respuesta.equals("no")) {
                // Respuesta negativa: salir del bucle
                break;

            } else {
                // Respuesta no reconocida: informar y repetir
                System.out.println("Respuesta no válida. " +
                        "Introduzca 's', 'si', 'n' o 'no'.");
            }

        } while (respuesta.equals("s") || respuesta.equals("si"));

        // ── Fin del programa ──────────────────────────────────
        System.out.println("Fin de la ejecución del programa.");
        sc.close();
    }
}
