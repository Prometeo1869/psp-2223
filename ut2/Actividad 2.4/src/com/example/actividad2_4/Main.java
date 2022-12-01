package com.example.actividad2_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHilo hilo = new MyHilo();

        String cad;
        while (true) {
            System.out.print("\tIntroduce CADENA: ");
            cad = sc.nextLine();

            if (!hilo.isAlive()) {
                System.out.println("Lanzando hilo...");
                hilo.start();
            }

            if (cad.equals("*"))
                break;
            if (cad.equals("S")) // SUSPENDER HILO
                hilo.Suspende();

            if (cad.equals("R")) // REANUDAR HILO
                hilo.Reanuda();

        }
        // REANUDAMOS EL HILO POR SI ESTÁ SUSPENDIDO
        hilo.Reanuda();
        System.out.println(" Contador:" + hilo.getContador());
        hilo.pararHilo();
    }
}
