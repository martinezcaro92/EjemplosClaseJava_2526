import java.io.Serializable;
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigoReserva;
    private String cliente;
    private int habitacion;
    private String fechaEntrada;
    private String fechaSalida;
    public Reserva(String codigoReserva, String cliente, int habitacion, String fechaEntrada, String fechaSalida) {
        this.codigoReserva = codigoReserva; this.cliente = cliente;
        this.habitacion = habitacion; this.fechaEntrada = fechaEntrada; this.fechaSalida = fechaSalida;
    }
    public String getCodigoReserva() { return codigoReserva; }
    public String getCliente()       { return cliente; }
    public int    getHabitacion()    { return habitacion; }
    public String getFechaEntrada()  { return fechaEntrada; }
    public String getFechaSalida()   { return fechaSalida; }
    @Override
    public String toString() {
        return String.format("%-12s %-20s %-10d %-12s %-12s",
                codigoReserva, cliente, habitacion, fechaEntrada, fechaSalida);
    }
}
