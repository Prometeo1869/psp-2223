package psp.iesvalleinclan.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int puerto = 12345;
        Socket cliente = new Socket("localhost", puerto);
        String cadena ="";

        while(!cadena.equals("exit")) {
            Mensaje mensaje = new Mensaje();
            System.out.println("Escribe el COMANDO: ");
            cadena = sc.next();
            mensaje.setMensaje(cadena);

            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            salida.writeObject(mensaje);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            mensaje = (Mensaje) entrada.readObject();
            cadena = mensaje.getMensaje();
            System.out.println("SERVIDOR> " + cadena);
            if(cadena.equals("exit")) {
                entrada.close();
                salida.close();
                sc.close();
            }
        }

        cliente.close();
    }
}
