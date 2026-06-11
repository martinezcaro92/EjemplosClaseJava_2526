package gimnasio.modelo;

import gimnasio.excepciones.DatosNoValidosException;

public class Socio extends Persona {

    private String telefono;
    private String email;

    public Socio(String nombre, String telefono, String email)
            throws DatosNoValidosException {
        super(nombre);
        setTelefono(telefono);
        setEmail(email);
    }

    // ── Getters ───────────────────────────────────────────────────

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // ── Setters con validación ────────────────────────────────────

    public void setTelefono(String telefono) throws DatosNoValidosException {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new DatosNoValidosException(
                    "El teléfono no puede ser nulo ni estar vacío.");
        }
        this.telefono = telefono;
    }

    public void setEmail(String email) throws DatosNoValidosException {
        if (email == null || email.trim().isEmpty()) {
            throw new DatosNoValidosException(
                    "El email no puede ser nulo ni estar vacío.");
        }
        this.email = email;
    }

    // ── toString ──────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Socio{nombre='" + getNombre() +
               "', telefono='"  + telefono    +
               "', email='"     + email       + "'}";
    }
}
