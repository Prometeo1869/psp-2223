package ut3.iesvalleinclan.num;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Numeros num = new Numeros();
        String host = "localhost";
        int puerto = 6000;
        Socket cliente = new Socket(host, puerto);
        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
        int numero = 0;

        do {
            System.out.println("Introduce un número:");
            numero = new Scanner(System.in).nextInt();
            num.setNumero(numero);

            out.writeObject(num);
        } while (numero != 0);

        out.close();
        cliente.close();



    }
}
