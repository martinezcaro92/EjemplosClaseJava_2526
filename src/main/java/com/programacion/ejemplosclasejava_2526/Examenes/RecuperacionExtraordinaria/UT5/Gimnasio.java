package gimnasio;

import gimnasio.excepciones.DatosNoValidosException;
import gimnasio.excepciones.SalaNoDisponibleException;
import gimnasio.modelo.Actividad;
import gimnasio.modelo.Sala;

import java.util.List;

public class Gimnasio {

    private String          nombre;
    private List<Actividad> actividadesDisponibles;
    private List<Sala>      salas;

    // Constructor
    public Gimnasio(String nombre,
                    List<Actividad> actividadesDisponibles,
                    List<Sala> salas)
            throws DatosNoValidosException {
        setNombre(nombre);
        setActividadesDisponibles(actividadesDisponibles);
        setSalas(salas);
    }

    // ── Getters ───────────────────────────────────────────────────

    public String getNombre() {
        return nombre;
    }

    public List<Actividad> getActividadesDisponibles() {
        return actividadesDisponibles;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    // ── Setters con validación ────────────────────────────────────

    public void setNombre(String nombre) throws DatosNoValidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosNoValidosException(
                    "El nombre del gimnasio no puede ser nulo ni vacío.");
        }
        this.nombre = nombre;
    }

    public void setActividadesDisponibles(List<Actividad> actividadesDisponibles)
            throws DatosNoValidosException {
        if (actividadesDisponibles == null || actividadesDisponibles.isEmpty()) {
            throw new DatosNoValidosException(
                    "La lista de actividades no puede ser nula ni vacía.");
        }
        this.actividadesDisponibles = actividadesDisponibles;
    }

    public void setSalas(List<Sala> salas) throws DatosNoValidosException {
        if (salas == null || salas.isEmpty()) {
            throw new DatosNoValidosException(
                    "La lista de salas no puede ser nula ni vacía.");
        }
        this.salas = salas;
    }

    // ── Métodos de negocio ────────────────────────────────────────

    public Sala buscarSala(int numeroSala) throws SalaNoDisponibleException {
        for (Sala s : salas) {
            if (s.getNumeroSala() == numeroSala) {
                return s;
            }
        }
        throw new SalaNoDisponibleException(
                "No existe ninguna sala con el número: " + numeroSala);
    }

    public void mostrarInformacionSalas() {
        System.out.println("=== INFORMACIÓN DEL GIMNASIO ===");
        System.out.println("Nombre: " + nombre);
        System.out.println();
        for (Sala s : salas) {
            System.out.println(s);
        }
    }

    // ── toString ──────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Gimnasio{nombre='" + nombre + "'}";
    }
}
