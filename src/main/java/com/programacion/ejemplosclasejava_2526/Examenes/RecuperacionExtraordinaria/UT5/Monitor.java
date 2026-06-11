package gimnasio.modelo;

import gimnasio.excepciones.DatosNoValidosException;

public class Monitor extends Persona {

    private static int contadorId = 1;

    private int id;

    public Monitor(String nombre) throws DatosNoValidosException {
        super(nombre);
        this.id = contadorId++;
    }

    // ── Getter ────────────────────────────────────────────────────

    public int getId() {
        return id;
    }

    // ── toString ──────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Monitor{id=" + id +
               ", nombre='"  + getNombre() + "'}";
    }
}
