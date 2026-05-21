import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Genera ficheros .dat de ejemplo para los ejercicios del Subbloque 2.3.
 * EJECUTAR ANTES de los Ejercicios 2-5.
 * Asegurarse de que las clases de dominio están en el mismo directorio.
 */
public class GenerarDatIniciales {

    public static void main(String[] args) {
        new File("src/datos").mkdirs();

        // --- productos_stock.dat ---
        escribir("src/datos/productos_stock.dat", new Object[]{
            new ProductoStock("A001", "Leche entera 1L",  200, 0.95),
            new ProductoStock("A002", "Pan de molde",     150, 1.30),
            new ProductoStock("A003", "Aceite oliva 1L",   80, 4.50),
            new ProductoStock("A004", "Arroz largo 1kg",  120, 1.20),
        });

        // --- jugadores.dat ---
        escribir("src/datos/jugadores.dat", new Object[]{
            new Jugador(10, "Carlos Fernandez", "Delantero",  5),
            new Jugador( 1, "Mario Ruiz",       "Portero",    8),
            new Jugador( 5, "Pedro Sanchez",    "Defensa",    3),
        });

        // --- suscriptores.dat ---
        escribir("src/datos/suscriptores.dat", new Object[]{
            new Suscriptor(1, "Ana Garcia",   "Premium", "2024-01-10"),
            new Suscriptor(2, "Luis Perez",   "Basico",  "2024-03-15"),
            new Suscriptor(3, "Marta Torres", "Premium", "2024-06-01"),
        });

        // --- turnos.dat ---
        escribir("src/datos/turnos.dat", new Object[]{
            new Turno("Ana Garcia",  "2025-01-13", "08:00", "16:00", "Maniana"),
            new Turno("Luis Perez",  "2025-01-13", "16:00", "00:00", "Tarde"),
            new Turno("Carmen Ruiz", "2025-01-13", "00:00", "08:00", "Noche"),
        });
    }

    private static void escribir(String path, Object[] objetos) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            for (Object o : objetos) oos.writeObject(o);
            System.out.println("Generado: " + path);
        } catch (IOException e) {
            System.out.println("Error generando " + path + ": " + e.getMessage());
        } finally {
            try { if (oos != null) oos.close(); } catch (IOException e) { }
        }
    }
}
