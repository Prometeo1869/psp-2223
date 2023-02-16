package psp.iesvalleinclan.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int puerto = 12345;
        Socket cliente = new Socket("localhost", puerto); //host y puerto
        String cadena ="";

        while(!cadena.equals("exit")) { //Si el servidor no a devuelto la cadena "exit"
            Mensaje mensaje = new Mensaje();    //Objeto de la clase Mensaje
            System.out.println("Escribe el COMANDO: ");
            cadena = sc.next();
            mensaje.setMensaje(cadena); //Introducimos en el Objeto de la Clase Mensaje el comando que ha escrito el cliente

            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream()); //Flujo de salida de Objetos que envia el cliente al servidor
            salida.writeObject(mensaje); //Enviamos al servidor el objeto con la respuesta

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream()); //Flujo de entrada de Objetos que recibe el cliente del servidor
            mensaje = (Mensaje) entrada.readObject(); //Leemos el objeto recibido previo cast del mismo
            cadena = mensaje.getMensaje();
            System.out.println("SERVIDOR> " + cadena);
            //Si el servdor devuelve "exit" cerramos los Streams y el cliente
            if(cadena.equals("exit")) {
                entrada.close();
                salida.close();
                sc.close();
            }
        }
        //Cerramos el Socket cliente
        cliente.close();
    }
}
