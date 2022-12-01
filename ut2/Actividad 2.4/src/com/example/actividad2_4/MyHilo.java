package com.example.actividad2_4;

public class MyHilo extends Thread {
    private SolicitaSuspender suspender = new SolicitaSuspender();
    private boolean stopHilo= false;
    private int c = 0;

    public void pararHilo()  {
        stopHilo = true;
    }

    int getContador() {
        return c;
    }

    public void Suspende() {
        suspender.set(true);
    }

    public void Reanuda() {
        suspender.set(false);
    }

    public void run() {

        try {
            while (!stopHilo) {
                c++;
                System.out.print(" " + c + " ");
                //sleep(200);
                suspender.esperandoParaReanudar();
                sleep(200);
            }
            System.out.println("Fin del hilo.");

        } catch (InterruptedException exception) {
        }
    }
}
