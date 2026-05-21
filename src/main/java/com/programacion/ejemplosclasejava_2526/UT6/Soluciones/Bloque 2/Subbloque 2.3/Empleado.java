import java.io.Serializable;

/**
 * Clase de dominio Empleado - necesaria para los ejercicios del Bloque 2.
 * Debe estar en el mismo paquete/directorio que los ejercicios.
 */
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dni;
    private String nombre;
    private int numEmpleado;
    private String departamento;

    public Empleado(String dni, String nombre, int numEmpleado, String departamento) {
        this.dni          = dni;
        this.nombre       = nombre;
        this.numEmpleado  = numEmpleado;
        this.departamento = departamento;
    }

    public String getDni()          { return dni; }
    public String getNombre()       { return nombre; }
    public int    getNumEmpleado()  { return numEmpleado; }
    public String getDepartamento() { return departamento; }

    @Override
    public String toString() {
        return dni + " | " + nombre + " | " + numEmpleado + " | " + departamento;
    }
}
