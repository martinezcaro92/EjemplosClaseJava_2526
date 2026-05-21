import java.io.Serializable;
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numCliente;
    private String nombre;
    private String apellidos;
    private String email;
    public Cliente(int numCliente, String nombre, String apellidos, String email) {
        this.numCliente = numCliente; this.nombre = nombre;
        this.apellidos = apellidos; this.email = email;
    }
    public int getNumCliente()   { return numCliente; }
    public String getNombre()    { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getEmail()     { return email; }
    @Override
    public String toString() { return numCliente + " | " + nombre + " | " + apellidos + " | " + email; }
}
