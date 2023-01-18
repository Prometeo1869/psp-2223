package ut3.iesvalleinclan.app;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static void main(String[] args) throws IOException {

        int port = 6000;
        ServerSocket servidor = new ServerSocket(port, 2);

        String ip = "Dirección IP del servidor: " + servidor.getInetAddress();

        System.out.println("Esperando a cliente.....");

        for (int i = 0; i < 2; i++) {
            Socket cliente = servidor.accept();
            System.out.println("Puerto Local del cliente " + (i + 1) + ": " + cliente.getLocalPort());
            System.out.println("Puerto remoto del cliente " + (i + 1) + ": " + cliente.getPort());

            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            out.writeObject(ip);
            System.out.println(ip + ", enviada al cliente" + (i + 1));
        }

        servidor.close();
    }

}
