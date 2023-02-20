import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;

public class RecuperaClaveSecreta {
    public static void main(String[] args) {

        //RECUPERAR CLAVE SECRETA DEL FICHERO
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Clave.secreta"));
            Key secreta = (Key) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
