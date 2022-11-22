package com.example.actividad1;

public class HolaMundo extends Thread {
    @Override
    public void run() {
        // Con Thread.currentThread().getId() consigo el ID del hilo que se ejecuta
        System.out.println("Hilo ID: " + Thread.currentThread().getId() + ": ¡Hola Mundo!");
    }

    public static void main(String[] args) {
        // Hago un bucle que termine a la 5ª vuelta en el que se crea un hilo y se inicia
        for (int i = 0; i < 5; i++) {
            HolaMundo h = new HolaMundo();
            h.start();
        }
    }
}
