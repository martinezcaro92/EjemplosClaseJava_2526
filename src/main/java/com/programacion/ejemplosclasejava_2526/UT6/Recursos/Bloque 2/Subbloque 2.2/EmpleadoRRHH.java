import java.io.Serializable;

/**
 * Clase de dominio EmpleadoRRHH para el Subbloque 2.2.
 * Debe estar en el mismo directorio que Ejercicio2.java / ... / Ejercicio5.java.
 */
public class EmpleadoRRHH implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dni;
    private String nombre;
    private String departamento;
    private double salario;

    public EmpleadoRRHH(String dni, String nombre, String departamento, double salario) {
        this.dni = dni; this.nombre = nombre;
        this.departamento = departamento; this.salario = salario;
    }
    public String getDni()          { return dni; }
    public String getNombre()       { return nombre; }
    public String getDepartamento() { return departamento; }
    public double getSalario()      { return salario; }
    @Override
    public String toString() {
        return String.format("%-12s %-20s %-18s %-8.2f", dni, nombre, departamento, salario);
    }
}
