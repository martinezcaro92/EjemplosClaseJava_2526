import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * PROGRAMA AUXILIAR - Genera los ficheros .dat necesarios para los ejercicios
 * del Subbloque 2.1.
 *
 * INSTRUCCIONES:
 *   1. Copia este fichero en tu proyecto NetBeans junto con las clases de dominio.
 *   2. Ejecuta main() UNA sola vez para generar todos los .dat en src/datos/.
 *   3. A partir de ese momento los ejercicios 2.1.E1 a 2.1.E5 podrán leerlos.
 *
 * IMPORTANTE: Las clases internas (EmpleadoGen, PedidoGen, etc.) están definidas
 * aquí para que el generador sea autocontenido. En los ejercicios reales debes
 * usar las clases Empleado, Pedido, Producto, Reserva y Alumno de tu proyecto.
 */
public class GeneradorDat {

    private static final String CARPETA = "src/datos/";

    // ── Clases de dominio internas (autocontenidas para el generador) ──────────

    static class EmpleadoGen implements Serializable {
        private static final long serialVersionUID = 1L;
        String dni; String nombre; int numEmpleado; String departamento;
        EmpleadoGen(String d, String n, int num, String dep) {
            dni=d; nombre=n; numEmpleado=num; departamento=dep;
        }
        public String toString() { return dni+" | "+nombre+" | "+numEmpleado+" | "+departamento; }
    }

    static class PedidoGen implements Serializable {
        private static final long serialVersionUID = 1L;
        int id; String cliente; String producto; int cantidad; double total;
        PedidoGen(int i,String c,String p,int ca,double t){id=i;cliente=c;producto=p;cantidad=ca;total=t;}
        public String toString(){return id+" | "+cliente+" | "+producto+" | "+cantidad+" | "+total;}
    }

    static class ProductoGen implements Serializable {
        private static final long serialVersionUID = 1L;
        String referencia; String descripcion; int cantidad; double precio;
        ProductoGen(String r,String d,int c,double p){referencia=r;descripcion=d;cantidad=c;precio=p;}
        public String toString(){return referencia+" | "+descripcion+" | "+cantidad+" | "+precio;}
    }

    static class ReservaGen implements Serializable {
        private static final long serialVersionUID = 1L;
        String codigoReserva; String cliente; int habitacion; String fechaEntrada; String fechaSalida;
        ReservaGen(String co,String cl,int h,String fi,String fs){
            codigoReserva=co;cliente=cl;habitacion=h;fechaEntrada=fi;fechaSalida=fs;
        }
        public String toString(){return codigoReserva+" | "+cliente+" | "+habitacion+" | "+fechaEntrada+" | "+fechaSalida;}
    }

    static class AlumnoGen implements Serializable {
        private static final long serialVersionUID = 1L;
        String nia; String nombre; String curso; double notaMedia;
        AlumnoGen(String ni,String no,String c,double nm){nia=ni;nombre=no;curso=c;notaMedia=nm;}
        public String toString(){return nia+" | "+nombre+" | "+curso+" | "+notaMedia;}
    }

    // ── Método genérico de escritura ──────────────────────────────────────────

    static void escribir(String fichero, Object[] objetos) {
        File dir = new File(CARPETA);
        if (!dir.exists()) dir.mkdirs();
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(CARPETA + fichero))) {
            for (Object o : objetos) oos.writeObject(o);
            System.out.println("Generado: " + CARPETA + fichero + " (" + objetos.length + " registros)");
        } catch (IOException e) {
            System.out.println("Error generando " + fichero + ": " + e.getMessage());
        }
    }

    // ── Main ─────────────────────────────────────────────────────────────────

    public static void main(String[] args) {

        // empleados.dat  (Ejercicio 1)
        escribir("empleados.dat", new Object[]{
            new EmpleadoGen("12345678A","Ana Garcia",    1001,"Informatica"),
            new EmpleadoGen("87654321B","Luis Perez",    1002,"Recursos Humanos"),
            new EmpleadoGen("11223344C","Marta Sanz",    1003,"Contabilidad"),
            new EmpleadoGen("44332211D","David Ruiz",    1004,"Informatica"),
            new EmpleadoGen("55667788E","Carmen Lopez",  1005,"Marketing"),
            new EmpleadoGen("99887766F","Jorge Blanco",  1006,"Logistica"),
        });

        // pedidos.dat  (Ejercicio 2)
        escribir("pedidos.dat", new Object[]{
            new PedidoGen(1,"Carlos Martinez","Teclado mecanico",   2,  179.98),
            new PedidoGen(2,"Elena Ruiz",     "Monitor 27 pulgadas",1,  299.00),
            new PedidoGen(3,"Tomas Fernandez","Raton inalambrico",  3,  106.50),
            new PedidoGen(4,"Rosa Gimenez",   "Auriculares gaming", 1,   59.99),
            new PedidoGen(5,"Andres Molina",  "Webcam HD",          2,   99.90),
            new PedidoGen(6,"Carlos Martinez","Hub USB-C",          1,   29.99),
            new PedidoGen(7,"Sofia Torres",   "Disco duro externo", 1,   79.00),
        });

        // productos.dat  (Ejercicio 3)
        escribir("productos.dat", new Object[]{
            new ProductoGen("REF001","Caja carton grande",    200, 0.85),
            new ProductoGen("REF002","Palet de madera",        30,12.50),
            new ProductoGen("REF003","Film estirable 500m",    50, 8.90),
            new ProductoGen("REF004","Precinto adhesivo 50mm", 150, 1.20),
            new ProductoGen("REF005","Grapa metalica 6mm",    500, 0.05),
            new ProductoGen("REF006","Etiqueta logistica",    1000, 0.03),
        });

        // reservas.dat  (Ejercicio 4)
        escribir("reservas.dat", new Object[]{
            new ReservaGen("RES-001","Ana Garcia",    101,"2025-02-14","2025-02-17"),
            new ReservaGen("RES-002","Luis Perez",    205,"2025-03-01","2025-03-05"),
            new ReservaGen("RES-003","Marta Sanz",    312,"2025-03-10","2025-03-12"),
            new ReservaGen("RES-004","David Ruiz",    101,"2025-04-20","2025-04-25"),
            new ReservaGen("RES-005","Carmen Lopez",  418,"2025-05-01","2025-05-03"),
        });

        // alumnos.dat  (Ejercicio 5)
        escribir("alumnos.dat", new Object[]{
            new AlumnoGen("NIA001","Sofia Torres",  "DAM1", 7.8),
            new AlumnoGen("NIA002","Pablo Mora",    "DAM1", 4.5),
            new AlumnoGen("NIA003","Lucia Fuentes", "DAW2", 9.1),
            new AlumnoGen("NIA004","Mario Vidal",   "DAM2", 6.3),
            new AlumnoGen("NIA005","Nerea Blanco",  "DAW1", 3.9),
            new AlumnoGen("NIA006","Oscar Molina",  "DAW2", 8.7),
            new AlumnoGen("NIA007","Paula Gimenez", "DAM1", 5.0),
            new AlumnoGen("NIA008","Raul Castillo",  "DAM2", 7.2),
        });

        System.out.println("\nTodos los ficheros .dat generados correctamente en " + CARPETA);
    }
}
