package com.garceta.u2_hilos;

public class HiloCadena extends Thread {
    private ObjetoCompartido objeto;
    String cadena;

    public HiloCadena(ObjetoCompartido objeto, String cadena) {
        this.objeto = objeto;
        this.cadena = cadena;
    }

    @Override
    public void run() {
        synchronized (objeto) { //Sincronización de hilos
            for (int j = 0; j < 10; j++) {
                objeto.PintaCadena(cadena);
                objeto.notify(); // aviso que ya se ha usado el objeto
                try {
                    objeto.wait(); // espera a que llegue un notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } //for
            objeto.notify(); // despertar a todos los wait sobre el objeto
        }//fin bloque synchronized

        System.out.print("\n" + cadena + " finalizado");
    }//run
}//HiloCadena
