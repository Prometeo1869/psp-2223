import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class RecuperarClavePrivada {
    public static void main(String[] args) {
        try {
            //LECTURA DEL FICHERO
            FileInputStream in = new FileInputStream("Clave.privada");
            byte[] bufferPriv = new byte[in.available()];
            in.read(bufferPriv);                //lectura de bytes
            in.close();

            KeyFactory keyDSA = KeyFactory.getInstance("DSA");

            //Recupera clave privada desde datos codificados en formato PKCS8
            PKCS8EncodedKeySpec clavePrivadaSpec = new PKCS8EncodedKeySpec(bufferPriv);
            PrivateKey clavePrivada = keyDSA.generatePrivate(clavePrivadaSpec);

            System.out.println("Clave Privada: " + clavePrivada.toString());

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }


    }
}
