package com.example.mc;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCcliente {

    public static void main(String[] args) throws Exception {
        //Se crea el socket multicast
        int puerto = 12345;//Puerto multicast
        MulticastSocket ms = new MulticastSocket(puerto);

        InetAddress grupo = InetAddress.getByName("255.0.0.1"); //Grupo

        //Nos unimos al grupo
        ms.joinGroup (grupo);

        String msg = "";

        while(!msg.trim().equals("*")) {
            byte[] buf = new byte[1000];
            //Recibe el paquete del servidor multicast
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            ms.receive(paquete);

            msg = new String(paquete.getData());
            System.out.println("Recibo: " + msg.trim());
        }
        ms.leaveGroup(grupo); //abandonamos grupo
        ms.close(); // cierra socket
        System.out.println("Socket cerrado...");
    }
}
