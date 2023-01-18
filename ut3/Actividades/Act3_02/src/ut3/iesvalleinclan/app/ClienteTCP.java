package ut3.iesvalleinclan.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClienteTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int puerto = 6000;
        String host = "localhost";
        Socket cliente = new Socket(host, puerto);

        ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

        System.out.println(in.readObject());

        cliente.close();
    }
}
