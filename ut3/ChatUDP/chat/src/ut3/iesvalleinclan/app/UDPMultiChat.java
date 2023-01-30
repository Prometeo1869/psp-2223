package ut3.iesvalleinclan.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class UDPMultiChat extends JFrame implements ActionListener, Runnable {

    static MulticastSocket ms = null;
    static byte[] buf = new byte[1000];
    static InetAddress grupo = null;
    static int puerto = 12345;
    String nombre;
    static JTextField mensaje = new JTextField();

    private JScrollPane scrollpane1;
    static JTextArea textarea1;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true;

    public UDPMultiChat(String nombre) {
        super(" CONEXIÓN DEL CLIENTE CHAT: " + nombre);
        setLayout(null);
        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);

        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 50, 400, 300);
        add(scrollpane1);

        boton.setBounds(420, 10, 100, 30);
        add(boton);
        desconectar.setBounds(420, 50, 100, 30);
        add(desconectar);

        textarea1.setEditable(false);
        boton.addActionListener(this);
        desconectar.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.nombre = nombre;

        String texto = "*** " + nombre + ", bienvenido!! ***";
        try {
            //ENVIANDO DESPEDIDA AL GRUPO
            DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, puerto);
            ms.send(paquete);
            System.out.println("Entra en el chat: " + nombre);
        } catch (IOException io) {
            System.out.println("ERROR DE E/S");
            io.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) throws IOException {

        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
        //Se crea el socket multicast
        ms = new MulticastSocket(puerto);
        grupo = InetAddress.getByName("225.0.0.1"); // Grupo multicast

        //Nos unimos al grupo
        ms.joinGroup(grupo);

        if(!nombre.trim().equals("")) {
            UDPMultiChat server = new UDPMultiChat(nombre);
            server.setBounds(0,0,540,400);
            server.setVisible(true);
            new Thread(server).start(); //lanzar hilo
        } else {
            System.out.println("El nombre está vacío....");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton) { //SE PULSA ENVIAR
            String texto = nombre + ">> " + mensaje.getText();
            try {
                //ENVIANDO mensaje al grupo
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, puerto);
                ms.send(paquete);
            } catch (IOException io) {
                io.printStackTrace();
            }
        }

        if(e.getSource() == desconectar) { //SE PULSA SALIR
            String texto = "*** Abandona el chat: " + nombre + " ***";
            try {
                //ENVIANDO DESPEDIDA AL GRUPO
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, puerto);
                ms.send(paquete);
                ms.close();
                repetir = false;
                System.out.println("Abandona el chat: " + nombre);
                System.exit(0);
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    public void run() {
        while(repetir) {
            try {
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ms.receive(p); //recibo mensajes
                String texto = new String(p.getData(), 0, p.getLength());
                textarea1.append(texto + "\n");
            } catch (SocketException s) {
                System.out.println(s.getMessage());;
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
