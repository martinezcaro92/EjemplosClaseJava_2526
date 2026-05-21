import java.io.Serializable;
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String referencia;
    private String descripcion;
    private int cantidad;
    private double precio;
    public Producto(String referencia, String descripcion, int cantidad, double precio) {
        this.referencia = referencia; this.descripcion = descripcion;
        this.cantidad = cantidad; this.precio = precio;
    }
    public String getReferencia()  { return referencia; }
    public String getDescripcion() { return descripcion; }
    public int    getCantidad()    { return cantidad; }
    public double getPrecio()      { return precio; }
    @Override
    public String toString() {
        return String.format("%-10s %-25s %-6d %-8.2f %-8.2f",
                referencia, descripcion, cantidad, precio, cantidad * precio);
    }
}
