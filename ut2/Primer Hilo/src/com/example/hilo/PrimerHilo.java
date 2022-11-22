package com.example.hilo;

public class PrimerHilo extends Thread {
    //variable entero
    private int x;
    // constructor
    public PrimerHilo(int x) {
        this.x = x;
    }
    // método run() donde se escribe la funcionalidad del hilo
    public void run() {
        for (int i = 0; i < x; i++) {
            System.out.println("En el hilo..." + i);
        }
    }
    // método main() para probar la creación del hilo y su ejecución
    public static void main(String[] args) {
        PrimerHilo p = new PrimerHilo(10);
        p.start();
    }
}


