package com.garceta.u2_hilos;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola);
        Consumidor c = new Consumidor(cola);

        p.start();
        c.start();
    }
}//Main
