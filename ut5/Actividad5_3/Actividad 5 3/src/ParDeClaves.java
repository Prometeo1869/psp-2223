import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class ParDeClaves {
    public static void main(String[] args) {
        try {
            FileOutputStream outPrivate, outPublic;
            outPublic = new FileOutputStream("Clave.publica");
            outPrivate = new FileOutputStream("Clave.privada");
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            //SE INICIALIZA EL GENERADOR DE CLAVES
            SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize(2048, numero);

            //SE CREA EL PAR DE CLAVES PRIVADA Y PÚBLICA
            KeyPair par = keyGen.generateKeyPair();
            PrivateKey clavepriv = par.getPrivate();
            PublicKey clavepub = par.getPublic();

            //LAS CLAVES SE PASAN A LOS ARCHIVOS
            outPublic.write(clavepub.getEncoded());
            outPrivate.write(clavepriv.getEncoded());

        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
}
