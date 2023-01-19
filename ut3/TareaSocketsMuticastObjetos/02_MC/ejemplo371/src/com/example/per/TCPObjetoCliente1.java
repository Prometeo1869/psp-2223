package com.example.per;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObjetoCliente1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("PROGRAMA CLIENTE INICIADO......");
        Socket cliente = new Socket(host, puerto);

        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

        Persona dato = (Persona) perEnt.readObject();
        System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());

        dato.setNombre("Juan Ramos");
        dato.setEdad(22);

        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());

        perSal.writeObject(dato);
        System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());

        perEnt.close();
        perSal.close();
        cliente.close();
    }
}
