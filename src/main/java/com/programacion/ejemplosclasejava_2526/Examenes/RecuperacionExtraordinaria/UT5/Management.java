package gimnasio;

import gimnasio.excepciones.DatosNoValidosException;
import gimnasio.excepciones.SalaNoDisponibleException;
import gimnasio.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Management {

    public static void main(String[] args) {

        try {

            // ── 1. Actividades disponibles en el gimnasio ─────────
            Actividad yoga     = new Actividad("Yoga",     15.0);
            Actividad spinning = new Actividad("Spinning", 12.0);
            Actividad pilates  = new Actividad("Pilates",  10.0);
            Actividad zumba    = new Actividad("Zumba",    12.0);
            Actividad boxeo    = new Actividad("Boxeo",    18.0);

            List<Actividad> actividadesDisponibles = new ArrayList<>();
            actividadesDisponibles.add(yoga);
            actividadesDisponibles.add(spinning);
            actividadesDisponibles.add(pilates);
            actividadesDisponibles.add(zumba);
            actividadesDisponibles.add(boxeo);

            // ── 2. Monitores ──────────────────────────────────────
            Monitor sergio = new Monitor("Sergio");  // id = 1
            Monitor vanesa = new Monitor("Vanesa");  // id = 2

            // ── 3. Sala 20 ────────────────────────────────────────
            Sala sala20 = new Sala();  // numeroSala = 20

            // Socios de la sala 20
            Socio miguel = new Socio("Miguel", "699100100", "miguel@email.com");
            Socio laura  = new Socio("Laura",  "699200200", "laura@email.com");
            sala20.anadirSocio(miguel);
            sala20.anadirSocio(laura);

            // Actividades consumidas en la sala 20
            sala20.agregarActividad(yoga);
            sala20.agregarActividad(spinning);
            sala20.agregarActividad(pilates);

            // Monitor asignado a la sala 20
            sala20.setMonitorAsignado(sergio);

            // ── 4. Sala 21 ────────────────────────────────────────
            Sala sala21 = new Sala();  // numeroSala = 21

            // Socios de la sala 21
            Socio beatriz = new Socio("Beatriz", "699300300", "beatriz@email.com");
            Socio adrian  = new Socio("Adrián",  "699400400", "adrian@email.com");
            Socio lucia   = new Socio("Lucía",   "699500500", "lucia@email.com");
            sala21.anadirSocio(beatriz);
            sala21.anadirSocio(adrian);
            sala21.anadirSocio(lucia);

            // Actividades consumidas en la sala 21
            sala21.agregarActividad(zumba);
            sala21.agregarActividad(boxeo);

            // Monitor asignado a la sala 21
            sala21.setMonitorAsignado(vanesa);

            // ── 5. Lista de salas ─────────────────────────────────
            List<Sala> salas = new ArrayList<>();
            salas.add(sala20);
            salas.add(sala21);

            // ── 6. Gimnasio ───────────────────────────────────────
            Gimnasio gimnasio = new Gimnasio(
                    "Gimnasio DAW",
                    actividadesDisponibles,
                    salas);

            // ── 7. Mostrar información de todas las salas ─────────
            gimnasio.mostrarInformacionSalas();

            // ── 8. Búsqueda de sala existente ─────────────────────
            System.out.println("--- Búsqueda de sala existente (20) ---");
            Sala encontrada = gimnasio.buscarSala(20);
            System.out.println("Sala encontrada: Mesa - "
                    + encontrada.getNumeroSala());
            System.out.println();

            // ── 9. Búsqueda de sala inexistente ───────────────────
            System.out.println("--- Búsqueda de sala inexistente (99) ---");
            gimnasio.buscarSala(99);

        } catch (DatosNoValidosException e) {
            System.out.println("Error de datos: " + e.getMessage());
        } catch (SalaNoDisponibleException e) {
            System.out.println("Error de sala:  " + e.getMessage());
        }
    }
}
