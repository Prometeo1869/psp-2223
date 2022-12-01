package com.example.actividad2_4;

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
