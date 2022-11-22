package com.example.act2_01;

public class Hilo2 extends Thread{
    public void run() {
        while(true) {
            System.out.println("TAC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
