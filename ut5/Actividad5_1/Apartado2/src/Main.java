import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageDigest md;
        String texto1, texto2, clave;
        System.out.println("Primera cadena:");
        texto1 = scanner.nextLine();
        System.out.println("Segunda cadena:");
        texto2 = scanner.nextLine();
        System.out.println("Clave:");
        clave = scanner.nextLine();

        try {
            md = MessageDigest.getInstance("SHA-256");


            byte dataBytes[] = texto1.getBytes();   //TEXTO A BYTES
            md.update(dataBytes);                   //SE INTRODUCE TEXTO EN BYTES A RESUMIR
            byte resumen[] = md.digest();           //SE CALCULA EL RESUMEN

            System.out.println("Primera cadena: " + texto1);
            System.out.println("Número de bytes: " + md.getDigestLength());
            System.out.println("Algoritmo: " + md.getAlgorithm());
            System.out.println("Mensaje resumen: " + new String(resumen));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}