/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ3;

/**
 *
 * @author Kolia
 */
public class Recurso {

    private String letra;
    private int veces;
    private String nombreT;

    public Recurso() {

        this.letra = "A";
        this.veces = 1;
        this.nombreT = "Hilo1";

    }

    public String getNombreT() {

        return this.nombreT;

    }

    public boolean esTurno() {
        boolean rta = false;

        if (Thread.currentThread().getName().equals("Hilo" + (veces))) {
            rta = true;
        }
        return rta;
    }

    public synchronized boolean escribir() {
        
        boolean rta = false;
        
        if (this.esTurno()) {
            for (int i = 0; i < veces; i++) {
                System.out.print(letra);
            }
            this.cambiarLetra();
            rta=true;
        }
        
        return rta;
    }

    public synchronized void cambiarLetra() {
        switch (veces) {
            case 1:
                letra = "B";
                veces = 2;
                nombreT = "Hilo" + veces;
                break;
            case 2:
                letra = "C";
                veces = 3;
                nombreT = "Hilo" + veces;
                break;
            case 3:
                letra = "A";
                veces = 1;
                nombreT = "Hilo" + veces;
                break;
        }
    }
}
