import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Subbloque 2.1 - Ejercicio 4
 * Registro de reservas de un hotel
 * Lee objetos Reserva de reservas.dat: codigoReserva, cliente, habitacion,
 * fechaEntrada, fechaSalida. Muestra los datos en tabla y cuenta el total.
 */
public class Ejercicio4 {

    public static void leerReservas(File archivo) throws IOException {
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            System.out.println("=".repeat(90));
            System.out.printf("%-14s %-20s %-10s %-14s %-14s%n",
                    "CODIGO", "CLIENTE", "HABITACION", "F.ENTRADA", "F.SALIDA");
            System.out.println("=".repeat(90));
            while (true) {
                Object obj = ois.readObject();
                System.out.println(obj.toString());
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (EOFException e) {
            System.out.println("=".repeat(90));
            System.out.println("Total de reservas: " + contador);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        } finally {
            if (ois != null) ois.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.1\\reservas.dat");
        if (!archivo.exists()) { System.out.println("Fichero no encontrado."); return; }
        try { leerReservas(archivo); } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
