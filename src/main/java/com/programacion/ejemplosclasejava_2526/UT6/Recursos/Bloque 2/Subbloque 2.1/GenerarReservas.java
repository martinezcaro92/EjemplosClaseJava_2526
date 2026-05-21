import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * EJECUTAR ESTE FICHERO ANTES DE Ejercicio4.java
 * Genera reservas.dat con objetos Reserva serializados.
 */
public class GenerarReservas {
    public static void main(String[] args) {
        String fullName = "src/datos/reservas.dat";
        new File("src/datos").mkdirs();

        Reserva[] reservas = {
            new Reserva("RES001", "Carlos Mendez",   101, "2025-02-14", "2025-02-17"),
            new Reserva("RES002", "Lucia Fernandez", 205, "2025-02-20", "2025-02-22"),
            new Reserva("RES003", "Pedro Sanchez",   312, "2025-03-01", "2025-03-05"),
            new Reserva("RES004", "Ana Torres",      101, "2025-03-10", "2025-03-12"),
            new Reserva("RES005", "Jorge Blanco",    408, "2025-03-15", "2025-03-20"),
        };

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fullName));
            for (Reserva r : reservas) oos.writeObject(r);
            System.out.println("Fichero reservas.dat generado.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try { if (oos != null) oos.close(); } catch (IOException e) { }
        }
    }
}
