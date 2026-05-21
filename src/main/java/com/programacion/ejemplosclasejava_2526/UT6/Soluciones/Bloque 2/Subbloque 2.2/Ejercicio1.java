import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Subbloque 2.2 - Ejercicio 1
 * Alta de nuevos vehículos en un concesionario
 * Recoge datos por teclado y serializa objetos Vehiculo en vehiculos.dat.
 */
public class Ejercicio1 {

    public static Vehiculo pedirDatosVehiculo(Scanner teclado) {
        System.out.print("Matrícula: ");  String mat    = teclado.nextLine();
        System.out.print("Marca: ");      String marca  = teclado.nextLine();
        System.out.print("Modelo: ");     String modelo = teclado.nextLine();
        System.out.print("Precio (€): "); double precio = Double.parseDouble(teclado.nextLine().trim());
        return new Vehiculo(mat, marca, modelo, precio);
    }

    public static void escribirVehiculo(File archivo, Vehiculo v) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(archivo, true));
            oos.writeObject(v);
            System.out.println("Vehículo registrado: " + v.getMatricula());
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (oos != null) oos.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.2\\vehiculos.dat");
        Scanner teclado = new Scanner(System.in);

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un vehículo? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                Vehiculo v = pedirDatosVehiculo(teclado);
                try { escribirVehiculo(archivo, v); }
                catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
            }
        } while (respuesta.equalsIgnoreCase("s"));

        teclado.close();
    }
}
