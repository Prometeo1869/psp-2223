package com.example.hilo;

public class PrimerHiloR implements Runnable {

    @Override
    public void run() {
        System.out.println("Hola desde el Hilo! " + Thread.currentThread().getId());
    }
}
