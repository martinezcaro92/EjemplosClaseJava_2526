import java.io.Serializable;
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String empleado;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private String tipoTurno;
    public Turno(String empleado, String fecha, String horaInicio, String horaFin, String tipoTurno) {
        this.empleado = empleado; this.fecha = fecha; this.horaInicio = horaInicio;
        this.horaFin = horaFin; this.tipoTurno = tipoTurno;
    }
    public String getEmpleado()   { return empleado; }
    public String getFecha()      { return fecha; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin()    { return horaFin; }
    public String getTipoTurno()  { return tipoTurno; }
    @Override
    public String toString() {
        return String.format("%-18s %-12s %-10s %-10s %-8s",
                empleado, fecha, horaInicio, horaFin, tipoTurno);
    }
}
