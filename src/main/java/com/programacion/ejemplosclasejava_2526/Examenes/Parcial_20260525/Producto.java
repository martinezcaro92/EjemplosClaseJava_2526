package com.programacion.examenes_2526.Parcial_20260525;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * =============================================================================
 * EJERCICIO 3 – Clase Producto
 * CFGS DAW | Módulo: Programación
 * =============================================================================
 *
 * Descripción:
 *   Modelo de datos que representa un producto del catálogo de una tienda de
 *   electrónica. Implementa Serializable para poder guardarse en ficheros
 *   binarios (.dat) mediante ObjectOutputStream / ObjectInputStream.
 *
 * Serializable:
 *   Es una interfaz marcador (sin métodos) que le indica a Java que los
 *   objetos de esta clase pueden convertirse a bytes (serialización) para
 *   guardarse en disco o enviarse por red, y luego reconstruirse
 *   (deserialización).
 *
 *   serialVersionUID → identificador de versión. Si la clase cambia y el
 *   valor difiere del fichero guardado, Java lanza InvalidClassException.
 *   Lo fijamos manualmente para tener control total.
 * =============================================================================
 */
public class Producto implements Serializable {


    // =========================================================================
    // VARIABLE AUTOINCREMENTAL ESTÁTICA
    //
    //   'static' → pertenece a la CLASE, no a cada objeto.
    //   Todos los objetos Producto comparten el mismo idCount.
    //   Se inicializa a 1 y se incrementa cada vez que se crea un Producto.
    //
    //   IMPORTANTE: idCount NO se serializa (transient), ya que es un
    //   contador interno de la clase y no un dato del producto.
    // =========================================================================
    private static int idCount = 1;

    // =========================================================================
    // ATRIBUTOS PRIVADOS DE INSTANCIA
    //   Cada objeto Producto tendrá su propia copia de estos valores.
    //   'private' → solo accesibles desde dentro de la clase;
    //               el exterior los lee/modifica a través de getters/setters.
    // =========================================================================

    /** Identificador único autoincremental del producto */
    private int id;

    /** Código de referencia del producto (ej: "REF-001") */
    private String referencia;

    /** Nombre comercial del producto (ej: "iPhone 15") */
    private String nombre;

    /** Categoría a la que pertenece (ej: "Móviles", "Portátiles") */
    private String categoria;

    /** Precio de venta al público con decimales */
    private int precio;

    /** Unidades disponibles en almacén */
    private int stock;

    /** Empresa proveedora del producto */
    private String proveedor;

    /** Indica si el producto está disponible para la venta */
    private boolean disponible;

    // =========================================================================
    // VARIABLE GLOBAL DE PRODUCTOS (ArrayList estático)
    //
    //   'static' → compartida por toda la clase, no por instancia.
    //   Se usa en GestorProductos para acumular los productos leídos del
    //   fichero binario antes de reescribir el fichero completo.
    //
    //   Se declara aquí según el enunciado, aunque su gestión principal
    //   se realiza en GestorProductos.
    // =========================================================================
    public static ArrayList<Producto> productos = new ArrayList<>();


    // =========================================================================
    // CONSTRUCTOR COMPLETO
    //
    //   Recibe todos los atributos EXCEPTO 'productos' (es estático y global)
    //   y EXCEPTO 'id' (es autoincremental → se asigna aquí automáticamente).
    //
    //   Flujo del id autoincremental:
    //     1. Se asigna el valor actual de idCount a this.id
    //     2. Se incrementa idCount en 1 para el siguiente objeto
    //
    //   @param referencia   Código de referencia
    //   @param nombre       Nombre del producto
    //   @param categoria    Categoría
    //   @param precio       Precio de venta
    //   @param stock        Unidades en stock
    //   @param proveedor    Proveedor
    //   @param disponible   true si está disponible, false si no
    // =========================================================================
    public Producto(String referencia, String nombre, String categoria,
                    int precio, int stock, String proveedor, boolean disponible) {

        // Asignamos el id actual y luego incrementamos para el próximo objeto (todo en una misma línea)
        this.id          = idCount++;

        this.referencia  = referencia;
        this.nombre      = nombre;
        this.categoria   = categoria;
        this.precio      = precio;
        this.stock       = stock;
        this.proveedor   = proveedor;
        this.disponible  = disponible;
    }


    // =========================================================================
    // GETTERS
    //   Métodos públicos de solo lectura para cada atributo privado.
    //   Siguen el convenio JavaBeans: get + NombreAtributoConMayúscula.
    //   No hay setters porque los productos no se modifican tras su creación.
    // =========================================================================

    /** @return Identificador único del producto */
    public int getId()             { return id; }

    /** @return Código de referencia */
    public String getReferencia()  { return referencia; }

    /** @return Nombre comercial */
    public String getNombre()      { return nombre; }

    /** @return Categoría */
    public String getCategoria()   { return categoria; }

    /** @return Precio de venta */
    public int getPrecio()      { return precio; }

    /** @return Unidades en stock */
    public int getStock()          { return stock; }

    /** @return Proveedor */
    public String getProveedor()   { return proveedor; }

    /** @return true si está disponible para la venta */
    public boolean isDisponible()  { return disponible; }


    // =========================================================================
    // MÉTODO toString
    //
    //   Devuelve una cadena formateada con los datos del producto en el formato
    //   de tabla indicado en el enunciado. Se usa en leerProductos() junto con
    //   printf() para la cabecera.
    //
    //   Formato de salida (una línea por producto):
    //   ID    REF        NOMBRE       CATEG.       PRECIO  STOCK  DISPONIBLE
    //   1     REF-001    iPhone 15    Moviles      999     12     SI
    //
    //   Nota: 'disponible' se muestra como "SI" o "NO" (más legible que true/false)
    // =========================================================================
    @Override
    public String toString() {
        String disponibleStr;
        if (disponible) {
            disponibleStr = "SI";
        } else {
            disponibleStr = "NO";
        }
        return String.format(
            "%-5d %-10s %-14s %-12s %-8.2f %-7d %-10s",
            id,
            referencia,
            nombre,
            categoria,
            precio,
            stock,
            disponibleStr
        );
    }
} 