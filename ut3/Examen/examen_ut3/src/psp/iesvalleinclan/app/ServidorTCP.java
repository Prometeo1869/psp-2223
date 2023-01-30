package psp.iesvalleinclan.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InetAddress ip;
        int puerto = 12345;
        ServidorTCP tcp = new ServidorTCP();
        ServerSocket servidor = new ServerSocket(puerto, 3);
        Socket cliente;
        System.out.println("SERVIDOR > Servidor iniciado");

        String cadena = "";

        while(!cadena.equals("exit")) {
            System.out.println("SERVIDOR > En espera de cliente....");
            cliente = servidor.accept();

            Mensaje mensaje;

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            mensaje = (Mensaje) entrada.readObject();
            cadena = mensaje.getMensaje();
            System.out.println("CLEINTE > petición: " + cadena);

            cadena = process(cadena);
            System.out.println("SERVIDOR> Resultado de la petición:");
            System.out.println("\"" + cadena + "\"");

            mensaje.setMensaje(cadena);

            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            salida.writeObject(mensaje);
            //Si el cliente quiere salir cerramos los Streams y el cliente
            if(cadena.equals("exit")) {
                entrada.close();
                salida.close();
                cliente.close();
            }
        }
        //Cerramos el servidor
        servidor.close();
    }

    private static String process(String cadena) {
        if (cadena.toLowerCase().equals("frase")) {
            String [] frase = {"FRASE 1", "FRASE 2", "FRASE 3", "FRASE 4", "FRASE 5"};
            return frase[(int) (frase.length * Math.random())];
        } else if (cadena.toLowerCase().equals("libro")) {
            String [] libro = {"TITULO 1, AUTOR 1", "TITULO 2, AUTOR 2", "TITULO 3, AUTOR 3", "TITULO 4, AUTOR 4"};
            return libro[(int) (libro.length * Math.random())];
        } else if (cadena.toLowerCase().equals("exit")) {
            return "exit";
        }
        return "COMANDO NO VÁLIDO";
    }


}
