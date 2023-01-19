package ut3.iesvalleinclan.num;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String host = "localhost";
        int puerto = 6000;
        int numero = 0;
        ObjectOutputStream out;
        ObjectInputStream in;

        Socket cliente = new Socket(host, puerto);

        do {
            Numeros num = new Numeros();
            System.out.println("Introduce un número:");
            numero = new Scanner(System.in).nextInt();
            num.setNumero(numero);
            out = new ObjectOutputStream(cliente.getOutputStream());

            out.writeObject(num);
            System.out.println("Enviado número: " + numero);

            in = new ObjectInputStream(cliente.getInputStream());
            num = (Numeros) in.readObject();
            System.out.println("Cuadrado: " + num.getCuadrado());
            System.out.println("Cubo: " + num.getCubo());

        } while (numero != 0);
        
        cliente.close();
        in.close();
        out.close();




    }
}
