package com.garceta.u2_hilos;

public class Cola {
    private String string;
    private boolean disponible = false;//inicialmente cola vacia

    synchronized public String get() {
        while(!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }//while
        disponible = false;     //se pone cola vacía
        notify();
        return string;
    }//get

    synchronized public void put(String s) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }//while
        string = s;
        disponible = true;
        //visualizar número
        notify();
    }//put
}//Cola
