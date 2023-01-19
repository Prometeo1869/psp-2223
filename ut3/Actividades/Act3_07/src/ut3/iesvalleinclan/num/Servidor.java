package ut3.iesvalleinclan.num;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        int numero = 0;
        Socket cliente;
        ObjectInputStream in;
        ObjectOutputStream out;

        System.out.println("Esperando la conexion cliente....");
        cliente = servidor.accept();

        do {
            System.out.println("Esperando numero....");


            in = new ObjectInputStream(cliente.getInputStream());
            Numeros num = (Numeros) in.readObject();

            numero = num.getNumero();
            System.out.println("Recibido número: " + numero);
            num.setCuadrado(numero * numero);
            num.setCubo(numero * numero * numero);

            System.out.println("Enviados cuadrado y cubo");
            out = new ObjectOutputStream(cliente.getOutputStream());
            out.writeObject(num);
        } while(numero != 0);

        in.close();
        out.close();
        cliente.close();
        servidor.close();
    }
}