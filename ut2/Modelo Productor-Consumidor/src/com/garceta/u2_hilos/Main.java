package com.garceta.u2_hilos;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c = new Consumidor(cola, 1);
        Consumidor d = new Consumidor(cola, 2);

        p.start();
        c.start();
        d.start();
    }
}//Main
