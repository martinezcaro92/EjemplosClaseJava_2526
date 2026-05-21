import java.io.Serializable;
public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;
    private int dorsal;
    private String nombre;
    private String posicion;
    private int aniosFederado;
    public Jugador(int dorsal, String nombre, String posicion, int aniosFederado) {
        this.dorsal = dorsal; this.nombre = nombre;
        this.posicion = posicion; this.aniosFederado = aniosFederado;
    }
    public int    getDorsal()        { return dorsal; }
    public String getNombre()        { return nombre; }
    public String getPosicion()      { return posicion; }
    public int    getAniosFederado() { return aniosFederado; }
    @Override
    public String toString() {
        return String.format("%-6d %-22s %-15s %-5d", dorsal, nombre, posicion, aniosFederado);
    }
}
