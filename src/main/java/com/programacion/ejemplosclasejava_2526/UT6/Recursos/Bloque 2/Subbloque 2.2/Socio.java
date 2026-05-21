import java.io.Serializable;

/**
 * Clase de dominio Socio para el Subbloque 2.2.
 * Debe estar en el mismo directorio que Ejercicio2.java / ... / Ejercicio5.java.
 */
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numSocio;
    private String nombre;
    private String apellidos;
    private String fechaAlta;

    public Socio(int numSocio, String nombre, String apellidos, String fechaAlta) {
        this.numSocio = numSocio; this.nombre = nombre;
        this.apellidos = apellidos; this.fechaAlta = fechaAlta;
    }
    public int getNumSocio()     { return numSocio; }
    public String getNombre()    { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getFechaAlta() { return fechaAlta; }
    @Override
    public String toString() {
        return String.format("%-6d %-20s %-20s %-12s", numSocio, nombre, apellidos, fechaAlta);
    }
}
