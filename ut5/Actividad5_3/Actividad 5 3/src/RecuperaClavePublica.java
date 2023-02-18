import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RecuperaClavePublica {
    public static void main(String[] args) {
        try {
            //LECTURA DEL FICHERO
            FileInputStream in = new FileInputStream("Clave.publica");
            byte[] bufferPub = new byte[in.available()];
            in.read(bufferPub);                //lectura de bytes
            in.close();

            //Recupera clave pública desde datos codificados en formato X509
            X509EncodedKeySpec clavePublicaSpec = new X509EncodedKeySpec(bufferPub);

            KeyFactory keyDSA = KeyFactory.getInstance("DSA");

            PublicKey clavePublica = keyDSA.generatePublic(clavePublicaSpec);
            System.out.println("Clave Pública: " + clavePublica.toString());

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
