import java.io.Serializable;

/**
 * Clase de dominio Incidencia para el Subbloque 2.2.
 * Debe estar en el mismo directorio que Ejercicio2.java / ... / Ejercicio5.java.
 */
public class Incidencia implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descripcion;
    private String prioridad;
    private String tecnicoAsignado;
    private String fecha;

    public Incidencia(String descripcion, String prioridad, String tecnicoAsignado, String fecha) {
        this.descripcion = descripcion; this.prioridad = prioridad;
        this.tecnicoAsignado = tecnicoAsignado; this.fecha = fecha;
    }
    public String getDescripcion()      { return descripcion; }
    public String getPrioridad()        { return prioridad; }
    public String getTecnicoAsignado()  { return tecnicoAsignado; }
    public String getFecha()            { return fecha; }
    @Override
    public String toString() {
        return String.format("%-25s %-8s %-18s %-12s", descripcion, prioridad, tecnicoAsignado, fecha);
    }
}
