package psp.iesvalleinclan.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Juan Cebrián
 */
public class ServidorTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int puerto = 12345;
        ServidorTCP tcp = new ServidorTCP();
        ServerSocket servidor = new ServerSocket(puerto, 3); //puerto y número máximo de clientes que permite el servidor
        System.out.println("SERVIDOR > Servidor iniciado");

        String cadena = "";

        while(true) { //Mientras el cliente no escriba el comando "exit"
            Socket cliente;
            cliente = servidor.accept();    //El servidor acepta la conexión de un cliente y queda a la espera del siguiente
            System.out.println("SERVIDOR > En espera de cliente....");

            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
        //Cerramos el ServerSocket servidor
    }


}
