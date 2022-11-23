package com.example.hilo;

public class HiloEjemplo1_V2_R implements Runnable {


    String nombre;
    public HiloEjemplo1_V2_R(String nombre) {
        this.nombre = nombre;
        System.out.println("CREANDO HILO: " + nombre);
    }
    // método run
    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread.currentThread().setName(nombre);
            System.out.println("Hilo: " + Thread.currentThread().getName() + " C = " + i);
        }
    }
}
