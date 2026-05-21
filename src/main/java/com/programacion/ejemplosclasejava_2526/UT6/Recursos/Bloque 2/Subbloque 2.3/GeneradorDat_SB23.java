import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * PROGRAMA AUXILIAR - Genera los ficheros .dat de partida para SB2.3.
 * Ejecutar UNA vez antes de los ejercicios para tener datos iniciales.
 * Los ejercicios leerán estos datos y permitirán añadir más registros.
 */
public class GeneradorDat_SB23 {

    private static final String CARPETA = "src/datos/";

    static class ClienteGen implements Serializable {
        private static final long serialVersionUID = 1L;
        int numCliente; String nombre; String apellidos; String email;
        ClienteGen(int n,String no,String ap,String e){numCliente=n;nombre=no;apellidos=ap;email=e;}
        public String toString(){return numCliente+" | "+nombre+" | "+apellidos+" | "+email;}
    }

    static class ProductoStockGen implements Serializable {
        private static final long serialVersionUID = 1L;
        String referencia; String descripcion; int cantidad; double precio;
        ProductoStockGen(String r,String d,int c,double p){referencia=r;descripcion=d;cantidad=c;precio=p;}
        public String toString(){return referencia+" | "+descripcion+" | "+cantidad+" | "+precio;}
    }

    static class JugadorGen implements Serializable {
        private static final long serialVersionUID = 1L;
        int dorsal; String nombre; String posicion; int aniosFederado;
        JugadorGen(int d,String n,String p,int a){dorsal=d;nombre=n;posicion=p;aniosFederado=a;}
        public String toString(){return dorsal+" | "+nombre+" | "+posicion+" | "+aniosFederado;}
    }

    static class SuscriptorGen implements Serializable {
        private static final long serialVersionUID = 1L;
        int id; String nombre; String plan; String fechaInicio;
        SuscriptorGen(int i,String n,String p,String f){id=i;nombre=n;plan=p;fechaInicio=f;}
        public String toString(){return id+" | "+nombre+" | "+plan+" | "+fechaInicio;}
    }

    static class TurnoGen implements Serializable {
        private static final long serialVersionUID = 1L;
        String empleado; String fecha; String horaInicio; String horaFin; String tipoTurno;
        TurnoGen(String em,String fe,String hi,String hf,String t){
            empleado=em;fecha=fe;horaInicio=hi;horaFin=hf;tipoTurno=t;
        }
        public String toString(){return empleado+" | "+fecha+" | "+horaInicio+" - "+horaFin+" | "+tipoTurno;}
    }

    static void escribir(String fichero, Object[] objetos) {
        new File(CARPETA).mkdirs();
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(CARPETA + fichero))) {
            for (Object o : objetos) oos.writeObject(o);
            System.out.println("Generado: " + CARPETA + fichero + " (" + objetos.length + " registros)");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // clientes.dat  (Ejercicio 1)
        escribir("clientes.dat", new Object[]{
            new ClienteGen(1,"Ana",    "Garcia Lopez",  "ana@agenciaviajes.com"),
            new ClienteGen(2,"Luis",   "Perez Ruiz",    "luis@correo.es"),
            new ClienteGen(3,"Marta",  "Sanz Molina",   "marta.sanz@email.net"),
            new ClienteGen(4,"David",  "Ruiz Castillo", "david.r@web.com"),
        });

        // productos_stock.dat  (Ejercicio 2)
        escribir("productos_stock.dat", new Object[]{
            new ProductoStockGen("LECHE001","Leche entera 1L",    150, 0.95),
            new ProductoStockGen("PAN001",  "Pan de molde 500g",  200, 1.35),
            new ProductoStockGen("ARROZ001","Arroz largo 1kg",     80, 1.20),
            new ProductoStockGen("ACEITE01","Aceite oliva 750ml",  60, 5.49),
            new ProductoStockGen("PASTA001","Espaguetis 500g",    120, 0.89),
        });

        // jugadores.dat  (Ejercicio 3)
        escribir("jugadores.dat", new Object[]{
            new JugadorGen(10,"Carlos Ruiz",   "Delantero",  5),
            new JugadorGen( 4,"Ana Martinez",  "Defensa",    8),
            new JugadorGen( 7,"Pablo Torres",  "Mediocampista", 3),
            new JugadorGen( 1,"Sofia Blanco",  "Portera",    10),
            new JugadorGen( 9,"Mario Lopez",   "Delantero",  2),
        });

        // suscriptores.dat  (Ejercicio 4)
        escribir("suscriptores.dat", new Object[]{
            new SuscriptorGen(1,"Elena Ruiz",    "Premium",  "2024-06-01"),
            new SuscriptorGen(2,"Tomas Gil",     "Basico",   "2024-09-15"),
            new SuscriptorGen(3,"Rosa Navarro",  "Premium",  "2024-11-20"),
            new SuscriptorGen(4,"Andres Vega",   "Familiar", "2025-01-05"),
        });

        // turnos.dat  (Ejercicio 5)
        escribir("turnos.dat", new Object[]{
            new TurnoGen("Ana Garcia",  "2025-01-13","08:00","16:00","Maniana"),
            new TurnoGen("Luis Perez",  "2025-01-13","16:00","00:00","Tarde"),
            new TurnoGen("Marta Sanz",  "2025-01-14","00:00","08:00","Noche"),
            new TurnoGen("David Ruiz",  "2025-01-14","08:00","16:00","Maniana"),
            new TurnoGen("Carmen Lopez","2025-01-15","16:00","00:00","Tarde"),
        });

        System.out.println("\nFicheros .dat de SB2.3 generados en " + CARPETA);
    }
}
