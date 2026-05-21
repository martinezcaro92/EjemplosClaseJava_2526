import java.io.Serializable;
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;
    private String marca;
    private String modelo;
    private double precio;
    public Vehiculo(String matricula, String marca, String modelo, double precio) {
        this.matricula = matricula; this.marca = marca;
        this.modelo = modelo; this.precio = precio;
    }
    public String getMatricula() { return matricula; }
    public String getMarca()     { return marca; }
    public String getModelo()    { return modelo; }
    public double getPrecio()    { return precio; }
    @Override
    public String toString() { return matricula + " | " + marca + " | " + modelo + " | " + precio; }
}
