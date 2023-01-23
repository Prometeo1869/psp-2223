package ut3.iesvalleinclan.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServidorChat extends Thread {
    DataInputStream fentrada;
    Socket socket = null;
    ComunHilos comun;

    public HiloServidorChat(Socket s, ComunHilos comun) {
        this.socket = s;
        this.comun = comun;
        try {
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException io) {
            System.out.println("ERROR DE E/S");
            io.printStackTrace();
        }
    }
    public void run() {
        System.out.println("NÚMERO DE CONXIONES ACTUALES: " + comun.getACTUALES());;

        String texto = comun.getMensajes();
        EnviarMensajesaTodos(texto);

        while(true) {
            String cadena = "";
            try {
                cadena = fentrada.readUTF();
                if (cadena.trim().equals("*")) {
                    comun.setACTUALES(comun.getACTUALES() - 1);
                    System.out.println("NÚMERO DE CONEXIONES ACTUALES; " + comun.getACTUALES());
                    break;
                }
                comun.setMensajes(comun.getMensajes() + cadena + "\n");
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            socket.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private void EnviarMensajesaTodos(String texto) {
        int i;

        for (i = 0; i < comun.getCONEXIONES(); i++) {
            Socket s1 = comun.getElementoTabla(i);
            if (!s1.isClosed()) {
                try {
                    DataOutputStream fsalida = new DataOutputStream(s1.getOutputStream());
                    fsalida.writeUTF(texto);
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }
    }
}
