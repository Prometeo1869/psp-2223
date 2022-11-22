package com.example.act2_01;

public class Hilo1 extends Thread{
    public void run() {
        while(true) {
            System.out.println("TIC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
