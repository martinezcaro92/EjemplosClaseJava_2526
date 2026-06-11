package com.programacion.examenes_2526.Recuperacion3T.ZZoriginal;
/*
 * =============================================================================
 * Clase: Vehiculo
 * Descripción: Clase de dominio que representa un vehículo del stock de
 *              un concesionario. Implementa Serializable para poder
 *              persistir objetos de esta clase en un fichero binario (.dat).
 *
 *              El campo vehiculo_id es autoincremental: se gestiona mediante
 *              la variable de clase estática idCount, que se incrementa
 *              automáticamente cada vez que se crea un nuevo objeto.
 *
 * Módulo: Programación · CFGS DAW · Curso 2025-26
 * =============================================================================
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Vehiculo implements Serializable {

    // serialVersionUID es obligatorio al implementar Serializable.
    // Si no se define, la JVM genera uno automáticamente que puede cambiar
    // entre compilaciones, causando InvalidClassException al deserializar.
    private static final long serialVersionUID = 1L;

    // =========================================================================
    // VARIABLE DE CLASE: idCount
    // Es static porque pertenece a la clase, no a cada instancia.
    // Se comparte entre todos los objetos Vehiculo y garantiza que cada
    // vehículo recibe un id único y consecutivo.
    // =========================================================================
    private static int idCount = 1;

    // =========================================================================
    // VARIABLE GLOBAL: vehiculos
    // ArrayList estático para almacenar los vehículos leídos del fichero
    // binario. Al ser static, es accesible desde GestorVehiculos sin
    // necesidad de instanciar la clase Vehiculo.
    // =========================================================================
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    // ── Atributos privados ────────────────────────────────────────────────────
    private int     vehiculo_id;   // Identificador único autoincremental
    private String  matricula;     // Matrícula del vehículo (ej: 1234ABC)
    private String  marca;         // Marca del fabricante
    private String  modelo;        // Modelo comercial
    private int     anio;          // Año de fabricación
    private String  tipo;          // Turismo, SUV, Utilitario...
    private String  combustible;   // Gasolina, Diesel, Híbrido, Eléctrico
    private int     kilometros;    // Kilómetros recorridos (0 si es nuevo)
    private double  precio;        // Precio de venta al público (PVP)
    private String  condicion;     // "nuevo" o "segunda_mano"
    private String  color;         // Color de la carrocería
    private int     num_puertas;   // Número de puertas
    private int     potencia_cv;   // Potencia en caballos de vapor
    private String  proveedor;     // Proveedor o importador del vehículo
    private boolean disponible;    // true si está disponible para la venta


    // =========================================================================
    // CONSTRUCTOR
    // Descripción: Inicializa todos los atributos del vehículo excepto
    //              vehiculo_id, que se asigna automáticamente con el valor
    //              actual de idCount y luego se incrementa en una unidad.
    //              De esta forma cada vehículo recibe un id único.
    // =========================================================================
    public Vehiculo(String  matricula,
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

        // Asignar el id actual y luego incrementar para el siguiente objeto
        this.vehiculo_id = idCount++;

        this.matricula   = matricula;
        this.marca       = marca;
        this.modelo      = modelo;
        this.anio        = anio;
        this.tipo        = tipo;
        this.combustible = combustible;
        this.kilometros  = kilometros;
        this.precio      = precio;
        this.condicion   = condicion;
        this.color       = color;
        this.num_puertas = num_puertas;
        this.potencia_cv = potencia_cv;
        this.proveedor   = proveedor;
        this.disponible  = disponible;
    }


    // =========================================================================
    // MÉTODOS GETTER
    // Descripción: Permiten acceder a los atributos privados desde otras
    //              clases sin exponer directamente los campos.
    // =========================================================================
    public int     getVehiculoId()  { return vehiculo_id; }
    public String  getMatricula()   { return matricula;   }
    public String  getMarca()       { return marca;       }
    public String  getModelo()      { return modelo;      }
    public int     getAnio()        { return anio;        }
    public String  getTipo()        { return tipo;        }
    public String  getCombustible() { return combustible; }
    public int     getKilometros()  { return kilometros;  }
    public double  getPrecio()      { return precio;      }
    public String  getCondicion()   { return condicion;   }
    public String  getColor()       { return color;       }
    public int     getNumPuertas()  { return num_puertas; }
    public int     getPotenciaCv()  { return potencia_cv; }
    public String  getProveedor()   { return proveedor;   }
    public boolean isDisponible()   { return disponible;  }


    // =========================================================================
    // MÉTODO: toString
    // Descripción: Devuelve una representación del objeto con campos de
    //              ancho fijo usando String.format(), de forma que al
    //              imprimir cada vehículo en la tabla las columnas queden
    //              alineadas. El campo disponible se muestra como SI/NO.
    // =========================================================================
    @Override
    public String toString() {
        return String.format(
            "%-5d %-9s %-11s %-11s %-6d %-11s %-10s %-8d %-10.2f %-12s %-8s %-6d %-5d %-18s %-5s",
            vehiculo_id,
            matricula,
            marca,
            modelo,
            anio,
            tipo,
            combustible,
            kilometros,
            precio,
            condicion,
            color,
            num_puertas,
            potencia_cv,
            proveedor,
            disponible ? "SI" : "NO"  // Convertir boolean a texto legible
        );
    }
}