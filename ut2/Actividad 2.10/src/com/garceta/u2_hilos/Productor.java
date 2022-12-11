package com.garceta.u2_hilos;

public class Productor extends Thread {
    private Cola cola;
    int contador;

    public Productor(Cola c) {
        cola = c;
        contador = 1;
    }

    @Override
    public void run() {
        while(true) {
            if (contador % 2 == 0) {
                cola.put("PONG ");
            } else {
                cola.put("PING ");
            }
            contador++;
        }
    }//run
}//Productor
