package com.programacion.examenes_2526.RecuperaciónExtraordinaria.UT6;

import java.io.Serializable;

/**
 * ============================================================
 *  Clase de dominio: Hotel
 * ============================================================
 * Representa un hotel del catálogo de la agencia de viajes.
 *
 * IMPLEMENTA Serializable:
 *   Requisito obligatorio para que los objetos Hotel puedan
 *   escribirse y leerse desde un fichero binario (.dat).
 *   Sin esta interfaz, Java lanzaría NotSerializableException
 *   al intentar serializar el objeto.
 * ============================================================
 */
public class Hotel implements Serializable {

    // ── serialVersionUID ──────────────────────────────────────
    // Identificador de versión para la serialización.
    // IMPORTANTE: debe coincidir exactamente con el valor usado
    // al generar el fichero hoteles.dat proporcionado.
    // Si se modifica, Java lanzará InvalidClassException al leer.
    private static final long serialVersionUID = 1L;

    // ── Variable auxiliar para el autoincremento ──────────────
    // 'static': compartida por TODOS los objetos Hotel.
    // Cada vez que se crea un Hotel, idCount sube en 1.
    // Así cada hotel recibe un identificador único y consecutivo.
    private static int idCount = 1;

    // ── Atributos privados ────────────────────────────────────
    // Encapsulados con private: solo accesibles mediante getters.
    private int     hotel_id;             // ID autoincremental
    private String  nombre;              // Nombre comercial
    private String  ciudad;              // Ciudad de ubicación
    private int     categoria_estrellas; // Categoría: 1 a 5 estrellas
    private double  precio_noche;        // Precio por noche en euros
    private boolean tiene_piscina;       // true = tiene piscina

    // ── Constructor completo ──────────────────────────────────
    /**
     * Crea un nuevo objeto Hotel con los 5 parámetros indicados.
     * El campo hotel_id se asigna automáticamente con idCount:
     *   1. Se fija el valor actual de idCount como hotel_id.
     *   2. Se incrementa idCount para el siguiente objeto.
     *
     * @param nombre              Nombre comercial del hotel
     * @param ciudad              Ciudad donde se ubica
     * @param categoria_estrellas Número de estrellas (1 a 5)
     * @param precio_noche        Precio por noche en euros
     * @param tiene_piscina       true si dispone de piscina
     */
    public Hotel(String nombre, String ciudad,
                 int categoria_estrellas,
                 double precio_noche,
                 boolean tiene_piscina) {

        this.hotel_id            = idCount++;  // Asignar y luego incrementar
        this.nombre              = nombre;
        this.ciudad              = ciudad;
        this.categoria_estrellas = categoria_estrellas;
        this.precio_noche        = precio_noche;
        this.tiene_piscina       = tiene_piscina;
    }

    // ── Getters ───────────────────────────────────────────────
    // No se definen setters: los atributos se asignan únicamente
    // en el constructor, garantizando la inmutabilidad del objeto.

    /** @return Identificador único autoincremental del hotel */
    public int getHotel_id() {
        return hotel_id;
    }

    /** @return Nombre comercial del hotel */
    public String getNombre() {
        return nombre;
    }

    /** @return Ciudad donde se ubica el hotel */
    public String getCiudad() {
        return ciudad;
    }

    /** @return Categoría del hotel en número de estrellas (1-5) */
    public int getCategoria_estrellas() {
        return categoria_estrellas;
    }

    /** @return Precio por noche en euros */
    public double getPrecio_noche() {
        return precio_noche;
    }

    /** @return true si el hotel dispone de piscina, false si no */
    public boolean isTiene_piscina() {
        return tiene_piscina;
    }

    // ── toString ──────────────────────────────────────────────
    /**
     * Devuelve una representación formateada del hotel lista para
     * imprimirse como fila dentro de una tabla en la terminal.
     *
     * Se usa String.format() con anchos fijos para alinear columnas:
     *   %-5d    → hotel_id,            izquierda,  5 chars
     *   %-30s   → nombre,              izquierda, 30 chars
     *   %-25s   → ciudad,              izquierda, 25 chars
     *   %-10d   → categoria_estrellas, izquierda, 10 chars
     *   %-14.2f → precio_noche,        2 decimales, 14 chars
     *   %-6s    → tiene_piscina,       "Sí"/"No",  6 chars
     *
     * Este método es llamado en leerHoteles() para imprimir
     * cada fila sin necesidad de acceder a los atributos uno a uno.
     */
    @Override
    public String toString() {
        return String.format("%-5d %-30s %-25s %-10d %-14.2f %-6s",
                hotel_id,
                nombre,
                ciudad,
                categoria_estrellas,
                precio_noche,
                tiene_piscina ? "Sí" : "No");
    }
}
