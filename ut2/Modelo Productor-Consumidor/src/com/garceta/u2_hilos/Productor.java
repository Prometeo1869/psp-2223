package com.garceta.u2_hilos;

public class Productor extends Thread {
    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i); //pone el número en la cola
            System.out.println(i + "=>Productor: " + n + ", produce " + i);
        }//for
    }//run
}//Productor
