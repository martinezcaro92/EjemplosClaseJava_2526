import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Subbloque 2.3 - Ejercicio 1
 * Gestión de clientes de una agencia de viajes
 * Verifica si clientes.dat existe, lee y muestra los clientes en tabla,
 * y permite añadir nuevos clientes al fichero.
 */
public class Ejercicio1 {

    public static void leerClientes(File archivo) throws IOException {
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            System.out.println("=".repeat(70));
            System.out.printf("%-8s %-18s %-18s %-22s%n",
                    "NUM", "NOMBRE", "APELLIDOS", "EMAIL");
            System.out.println("=".repeat(70));
            while (true) {
                Cliente c = (Cliente) ois.readObject();
                System.out.printf("%-8d %-18s %-18s %-22s%n",
                        c.getNumCliente(), c.getNombre(), c.getApellidos(), c.getEmail());
                contador++;
            }
        } catch (EOFException e) {
            System.out.println("=".repeat(70));
            System.out.println("Total de clientes: " + contador);
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        } finally {
            if (ois != null) ois.close();
        }
    }

    public static Cliente pedirDatosCliente(Scanner teclado) {
        System.out.print("Número de cliente: "); int num = Integer.parseInt(teclado.nextLine().trim());
        System.out.print("Nombre: ");            String nombre    = teclado.nextLine();
        System.out.print("Apellidos: ");         String apellidos = teclado.nextLine();
        System.out.print("Email: ");             String email     = teclado.nextLine();
        return new Cliente(num, nombre, apellidos, email);
    }

    public static void escribirCliente(File archivo, Cliente cliente) throws IOException {
        ObjectOutputStream oos = null;
        try {
            if (archivo.exists()) {
                oos = new AppendObjectOutputStream(new FileOutputStream(archivo, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(archivo));
            }
            oos.writeObject(cliente);
            System.out.println("Cliente añadido correctamente.");
        } finally {
            if (oos != null) oos.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.3\\clientes.dat");
        Scanner teclado = new Scanner(System.in);

        if (archivo.exists()) {
            try { leerClientes(archivo); }
            catch (IOException e) { System.out.println("Error al leer: " + e.getMessage()); }
        } else {
            System.out.println("No existe fichero previo. Se creará uno nuevo.");
        }

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un nuevo cliente? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                Cliente c = pedirDatosCliente(teclado);
                try { escribirCliente(archivo, c); }
                catch (IOException e) { System.out.println("Error al escribir: " + e.getMessage()); }
            }
        } while (respuesta.equalsIgnoreCase("s"));

        teclado.close();
    }
}
