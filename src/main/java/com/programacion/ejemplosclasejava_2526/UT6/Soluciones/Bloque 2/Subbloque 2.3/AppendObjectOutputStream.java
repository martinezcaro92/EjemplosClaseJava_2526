import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Subclase de ObjectOutputStream que NO escribe la cabecera de stream al abrir,
 * necesaria para añadir objetos a un fichero binario existente sin corromperlo.
 */
public class AppendObjectOutputStream extends ObjectOutputStream {
    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // Sobreescribimos para no escribir la cabecera al hacer append
        reset();
    }
}
