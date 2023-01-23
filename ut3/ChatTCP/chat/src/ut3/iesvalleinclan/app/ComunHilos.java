package ut3.iesvalleinclan.app;

import java.net.Socket;

public class ComunHilos {
    int CONEXIONES;
    int ACTUALES;
    int MAXIMO;
    Socket tabla[] = new Socket[MAXIMO];
    String mensajes;

    public ComunHilos(int maximo, int actuales, int conexiones, Socket[] tabla) {
        this.MAXIMO = maximo;
        this.ACTUALES = actuales;
        this.CONEXIONES = conexiones;
        this.tabla = tabla;
        this.mensajes = "";
    }

    public ComunHilos() {
        super();
    }

    public int getCONEXIONES() {
        return CONEXIONES;
    }

    public synchronized void setCONEXIONES(int conexiones) {
        this.CONEXIONES = conexiones;
    }

    public int getACTUALES() {
        return ACTUALES;
    }

    public synchronized void setACTUALES(int actuales) {
        this.ACTUALES = actuales;
    }

    public int getMAXIMO() {
        return MAXIMO;
    }

    public void setMAXIMO(int maximo) {
        this.MAXIMO = maximo;
    }

    public String getMensajes() {
        return mensajes;
    }

    public synchronized void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }
    //añadir socket al array de sockets
    public Socket getElementoTabla(int i) {
        return tabla[i];
    }

    public synchronized void addTabla(Socket s, int i) {
        tabla[i] = s;
    }
}
