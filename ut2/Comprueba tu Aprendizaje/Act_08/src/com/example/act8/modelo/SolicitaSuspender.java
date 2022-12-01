package com.example.act8.modelo;

public class SolicitaSuspender {
    private boolean solicitaSuspender;

    public synchronized void set(boolean b) {
        solicitaSuspender = b;
        notifyAll();
    }

    public synchronized void esperandoParaReanudar() throws InterruptedException {
        while (solicitaSuspender) {
            wait();
        }
    }
}
