import java.io.Serializable;

/**
 * Clase de dominio Medicamento para el Subbloque 2.2.
 * Debe estar en el mismo directorio que Ejercicio2.java / ... / Ejercicio5.java.
 */
public class Medicamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String principioActivo;
    private String dosis;
    private double precio;

    public Medicamento(String nombre, String principioActivo, String dosis, double precio) {
        this.nombre = nombre; this.principioActivo = principioActivo;
        this.dosis = dosis; this.precio = precio;
    }
    public String getNombre()           { return nombre; }
    public String getPrincipioActivo()  { return principioActivo; }
    public String getDosis()            { return dosis; }
    public double getPrecio()           { return precio; }
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-10s %-8.2f", nombre, principioActivo, dosis, precio);
    }
}
