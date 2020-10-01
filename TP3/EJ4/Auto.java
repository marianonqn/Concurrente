package TP3.EJ4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Auto extends Vehiculo implements Runnable {

    float kilometraje;
    int capacidadSinReserva;
    Surtidor compartido;

    public Auto(Surtidor compartido) {
        this.compartido = compartido;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setCapacidadSinReserva(int capacidadSinReserva) {
        this.capacidadSinReserva = capacidadSinReserva;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public int getCapacidadSinReserva() {
        return capacidadSinReserva;
    }

    public void cargarNafta() {
        compartido.carga(capacidadSinReserva);
    }

    @Override
    public void run() {
        try {
            System.out.println("Circulando " + Thread.currentThread().getName());
            Thread.sleep(capacidadSinReserva * 100);
            System.out.println("Va a cargar nafta " + Thread.currentThread().getName());
            synchronized(compartido) {
                this.cargarNafta();
                System.out.println("Ya cargo y comienza a circular " + Thread.currentThread().getName());
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
