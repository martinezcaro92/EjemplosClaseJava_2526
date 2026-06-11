package gimnasio.modelo;

import gimnasio.excepciones.DatosNoValidosException;

public class Persona {

    private String nombre;

    public Persona(String nombre) throws DatosNoValidosException {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatosNoValidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosNoValidosException(
                    "El nombre no puede ser nulo ni estar vacío.");
        }
        this.nombre = nombre;
    }
}
