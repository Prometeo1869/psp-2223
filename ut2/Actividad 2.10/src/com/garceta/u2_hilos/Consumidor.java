package com.garceta.u2_hilos;

public class Consumidor extends Thread {
    private Cola cola;
    private String s;

    public Consumidor(Cola c) {
        cola = c;
    }

    @Override
    public void run() {
        String cadena = "";
            while(true) {
                s = cola.get(); //recoge la cadena de la cola
                System.out.print(s + " ");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }//run
}//Consumidor
