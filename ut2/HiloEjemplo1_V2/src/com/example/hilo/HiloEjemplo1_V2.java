package com.example.hilo;

public class HiloEjemplo1_V2 extends Thread{

    //constructor

    public HiloEjemplo1_V2(String nombre) {
        super(nombre);
        System.out.println("CREANDO HILO: " + getName());
    }
    // método run
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo: " + getName() + " C = " + i);
        }
    }
}
