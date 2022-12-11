package com.example.act8.modelo;

public class SolicitaSuspender {
    private boolean solicitaSuspender = false;

    public boolean isSolicitaSuspender() {
        return solicitaSuspender;
    }

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
