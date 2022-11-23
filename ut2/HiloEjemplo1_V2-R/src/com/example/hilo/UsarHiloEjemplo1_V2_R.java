package com.example.hilo;

public class UsarHiloEjemplo1_V2_R {
    public static void main(String[] args) {
        new Thread(new HiloEjemplo1_V2_R("Hilo 1")).start();
        new Thread(new HiloEjemplo1_V2_R("Hilo 2")).start();
        new Thread(new HiloEjemplo1_V2_R("Hilo 3")).start();

        System.out.println("3 HILOS INICIADOS...");
    }
}
