package com.example.hilo;

public class HiloAct2 implements Runnable {


    String cadena;

    HiloAct2(String cadena) {
        this.cadena = cadena;
    }


    @Override
    public void run() {
        System.out.println("Hola mundo " + cadena + ", hiloID: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new HiloAct2("que tal")).start();
            try {
                Thread.sleep(500 * (int) Thread.currentThread().getId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
