import java.io.Serializable;
public class Suscriptor implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String plan;
    private String fechaInicio;
    public Suscriptor(int id, String nombre, String plan, String fechaInicio) {
        this.id = id; this.nombre = nombre; this.plan = plan; this.fechaInicio = fechaInicio;
    }
    public int    getId()          { return id; }
    public String getNombre()      { return nombre; }
    public String getPlan()        { return plan; }
    public String getFechaInicio() { return fechaInicio; }
    @Override
    public String toString() {
        return String.format("%-5d %-22s %-12s %-12s", id, nombre, plan, fechaInicio);
    }
}
