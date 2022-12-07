package com.garceta.u2_hilos;

public class Consumidor extends Thread {
    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    @Override
    public void run() {
        int valor = 0;
        synchronized (cola) {
            for (int i = 0; i < 5; i++) {
                    valor = cola.get(); //recoge el numero de la cola
                    System.out.println("\t" + i + "=>Consumidor: " + n + ", consume: " + valor);
                if(valor == 4) {
                    System.out.println("Fin del programa");
                }
            }//for
        }//synchronized
    }//run
}//Consumidor
