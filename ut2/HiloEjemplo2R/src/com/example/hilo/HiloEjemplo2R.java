package com.example.hilo;

public class HiloEjemplo2R implements Runnable {
    @Override
    public void run() {
        System.out.println(
                "Dentro del Hilo  : " + Thread.currentThread().getName() +
                        "\n\tPrioridad    : " + Thread.currentThread().getPriority() +
                        "\n\tID           : " + Thread.currentThread().getId() +
                        "\n\tHilos activos: " + Thread.currentThread().activeCount()
        );
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("Principal"); // nombre a main
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());


        for (int i = 0; i < 3; i++) {
            HiloEjemplo2R h = new HiloEjemplo2R();
            Thread hilo = new Thread(h); // crear hilo
            hilo.setName("HILO" + i);    // damos nombre al hilo
            hilo.setPriority(i + 1);     // damos prioridad
            hilo.start();                // iniciar hilo
            System.out.println(
                    "Información del " + hilo.getName() + ": " + hilo
            );
        }
        System.out.println("3 HILOS CREADOS...");
        System.out.println("Hilos activos: " + Thread.activeCount());
    }
}
