import java.io.Serializable;
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nia;
    private String nombre;
    private String curso;
    private double notaMedia;
    public Alumno(String nia, String nombre, String curso, double notaMedia) {
        this.nia = nia; this.nombre = nombre; this.curso = curso; this.notaMedia = notaMedia;
    }
    public String getNia()        { return nia; }
    public String getNombre()     { return nombre; }
    public String getCurso()      { return curso; }
    public double getNotaMedia()  { return notaMedia; }
    @Override
    public String toString() {
        return String.format("%-10s %-25s %-8s %-6.1f", nia, nombre, curso, notaMedia);
    }
}
