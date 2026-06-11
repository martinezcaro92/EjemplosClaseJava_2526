package gimnasio.modelo;

import gimnasio.excepciones.DatosNoValidosException;
import gimnasio.interfaces.ICobrable;
import gimnasio.interfaces.IReservable;

import java.util.ArrayList;
import java.util.List;

public class Sala implements IReservable, ICobrable {

    private static int contadorNumero = 20;

    private int             numeroSala;
    private List<Socio>     socios;
    private List<Actividad> actividadesConsumidas;
    private Monitor         monitorAsignado;

    // Constructor sin argumentos
    public Sala() {
        this.numeroSala           = contadorNumero++;
        this.socios               = new ArrayList<>();
        this.actividadesConsumidas = new ArrayList<>();
        this.monitorAsignado      = null;
    }

    // ── Getters ───────────────────────────────────────────────────

    public int getNumeroSala() {
        return numeroSala;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public List<Actividad> getActividadesConsumidas() {
        return actividadesConsumidas;
    }

    public Monitor getMonitorAsignado() {
        return monitorAsignado;
    }

    // ── Métodos de negocio ────────────────────────────────────────

    public void anadirSocio(Socio socio) throws DatosNoValidosException {
        if (socio == null) {
            throw new DatosNoValidosException(
                    "El socio no puede ser nulo.");
        }
        this.socios.add(socio);
    }

    public void setMonitorAsignado(Monitor monitor)
            throws DatosNoValidosException {
        if (monitor == null) {
            throw new DatosNoValidosException(
                    "El monitor asignado no puede ser nulo.");
        }
        this.monitorAsignado = monitor;
    }

    // ── IReservable ───────────────────────────────────────────────

    @Override
    public void agregarActividad(Actividad actividad) {
        if (actividad != null) {
            this.actividadesConsumidas.add(actividad);
        }
    }

    // ── ICobrable ─────────────────────────────────────────────────

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Actividad a : actividadesConsumidas) {
            total += a.getPrecio();
        }
        return total;
    }

    // ── toString ──────────────────────────────────────────────────

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mesa - ").append(numeroSala).append("\n");
        sb.append("     clientes=[\n");
        for (Socio s : socios) {
            sb.append("          ").append(s).append(",\n");
        }
        if (!socios.isEmpty()) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("     ]\n");
        sb.append("     actividadesConsumidas=[\n");
        for (Actividad a : actividadesConsumidas) {
            sb.append("          ").append(a).append(",\n");
        }
        if (!actividadesConsumidas.isEmpty()) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("     ]\n");
        sb.append("     monitorAsignado=").append(monitorAsignado).append("\n");
        sb.append("     total=").append(calcularTotal()).append("}");
        return sb.toString();
    }
}
