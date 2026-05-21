import java.io.Serializable;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String cliente;
    private String producto;
    private int cantidad;
    private double total;

    public Pedido(int id, String cliente, String producto, int cantidad, double total) {
        this.id = id; this.cliente = cliente; this.producto = producto;
        this.cantidad = cantidad; this.total = total;
    }
    public int getId()         { return id; }
    public String getCliente() { return cliente; }
    public String getProducto(){ return producto; }
    public int getCantidad()   { return cantidad; }
    public double getTotal()   { return total; }

    @Override
    public String toString() {
        return id + " | " + cliente + " | " + producto + " | " + cantidad + " | " + total;
    }
}
