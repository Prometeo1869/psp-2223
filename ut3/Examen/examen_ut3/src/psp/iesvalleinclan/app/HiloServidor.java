package psp.iesvalleinclan.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread {

    ObjectInputStream entrada;
    ObjectOutputStream salida;
    Socket cliente = null;
    Mensaje mensaje;    //Objeto de la Clase Mensaje


    public HiloServidor(Socket cliente) throws IOException {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        String cadena = "";
        try {
            entrada = new ObjectInputStream(cliente.getInputStream()); //Flujo de entrada de Objetos que recibe el servidor del cliente
            mensaje = (Mensaje) entrada.readObject(); //Leemos el objeto recibido previo cast del mismo
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        cadena = mensaje.getMensaje();  //
        System.out.println("CLINTE > petición: " + cadena);

        cadena = process(cadena); //Procesa el comando y le devuelve el mensaje requerido
        System.out.println("SERVIDOR> Resultado de la petición:");
        System.out.println("\"" + cadena + "\"");

        mensaje.setMensaje(cadena); //Introduce la cadena en el Objeto que va a recibir el cliente

        try {
            salida = new ObjectOutputStream(cliente.getOutputStream()); //Flujo de salida de Objetos que envia el servidor al cliente
            salida.writeObject(mensaje); //Enviamos al cliente el objeto con la respuesta
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Si el cliente quiere salir cerramos los Streams y el Socket cliente
        if (cadena.equals("exit")) {
            try {
                entrada.close();
                salida.close();
                cliente.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Método que recibe el comando del cliente y da la respuesta requerida al cliente
     * @param cadena
     * @return String
     */
    private static String process(String cadena) {
        if (cadena.toLowerCase().equals("frase")) { //Si el comando recibido es "frase"
            String [] frase = {"FRASE 1", "FRASE 2", "FRASE 3", "FRASE 4", "FRASE 5"};
            return frase[(int) (frase.length * Math.random())];
        } else if (cadena.toLowerCase().equals("libro")) { //Si el comando recibido es "libro"
            String [] libro = {"TITULO 1, AUTOR 1", "TITULO 2, AUTOR 2", "TITULO 3, AUTOR 3", "TITULO 4, AUTOR 4"};
            return libro[(int) (libro.length * Math.random())];
        } else if (cadena.toLowerCase().equals("exit")) { //Si el comando recibido es "exit"
            return "exit";
        }
        return "COMANDO NO VÁLIDO"; //Si recibe algún otro comando que no sea "frase", "libro" o "exit"
    }
}
