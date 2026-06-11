package gimnasio.modelo;

import gimnasio.excepciones.DatosNoValidosException;

public class Actividad {

    private String nombre;
    private double precio;

    public Actividad(String nombre, double precio)
            throws DatosNoValidosException {
        setNombre(nombre);
        setPrecio(precio);
    }

    // ── Getters ───────────────────────────────────────────────────

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // ── Setters con validación ────────────────────────────────────

    public void setNombre(String nombre) throws DatosNoValidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosNoValidosException(
                    "El nombre de la actividad no puede ser nulo ni estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setPrecio(double precio) throws DatosNoValidosException {
        if (precio < 0) {
            throw new DatosNoValidosException(
                    "El precio de la actividad no puede ser negativo.");
        }
        this.precio = precio;
    }

    // ── toString ──────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Actividad{nombre='" + nombre +
               "', precio="         + precio + "}";
    }
}
