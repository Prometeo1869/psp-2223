package com.garceta.u2_hilos;

public class Cola {
    private int numero;
    private boolean disponible = false;//inicialmente cola vacia

    synchronized public int get() {
        while(!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }//while
        disponible = false;     //se pone cola vacía
        notify();
        return numero;
    }//get

    synchronized public void put(int valor) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }//while
        numero = valor;
        disponible = true;
        //visualizar número
        notify();
    }//put
}//Cola
