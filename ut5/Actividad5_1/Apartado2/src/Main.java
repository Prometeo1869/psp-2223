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

            //RESUMEN 1
            byte dataBytes[] = texto1.getBytes();           //TEXTO A BYTES
            md.update(dataBytes);                           //SE INTRODUCE TEXTO EN BYTES A RESUMIR
            byte resumen1[] = md.digest(clave.getBytes());   //SE CALCULA EL RESUMEN

            //RESUMEN 2
            byte dataBytes2[] = texto2.getBytes();           //TEXTO A BYTES
            md.update(dataBytes2);                           //SE INTRODUCE TEXTO EN BYTES A RESUMIR
            byte resumen2[] = md.digest(clave.getBytes());   //SE CALCULA EL RESUMEN


            if (resumen1.equals(resumen2)) {
                System.out.println("SON IGUALES:");
            } else {
                System.out.println("SON DISTINTOS:");
            }

            System.out.println("Mensaje 1 resumen: " + new String(resumen1) + " => " + resumen1);
            System.out.println("Mensaje 2 resumen: " + new String(resumen2) + " => " + resumen2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}