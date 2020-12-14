package TP5.EJ3;

import java.util.concurrent.Semaphore;

public class Tren {

    Semaphore semVendedorTicket;
    Semaphore semTicket;
    Semaphore semBajarTren;
    Semaphore semLugarTren;
    int capacidadTren;

    public Tren(int _capacidadTren) {

        this.semLugarTren = new Semaphore(0, true);
        this.semTicket = new Semaphore(_capacidadTren, true);
        this.semVendedorTicket = new Semaphore(0, true);
        this.capacidadTren = _capacidadTren;
        this.semBajarTren = new Semaphore(0, true);
    }

    // metodos vendedor

    public void venderTicket() {

        try {
            this.semVendedorTicket.acquire();
            this.semLugarTren.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // metodos pasajero

    public void comprarTicket() {

        try {
            this.semTicket.acquire();
            this.semVendedorTicket.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void subirTren() {
        System.out.println(Thread.currentThread().getName() + " sube al tren");
    }

    public void bajarTren() {

        try {
            this.semBajarTren.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // metodos poner marcha tren
    public void ponerMarchaTren() {

        try {
            this.semLugarTren.acquire(this.capacidadTren);            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void detenerTren() {
        
        this.semBajarTren.release(this.capacidadTren);
        this.semLugarTren.release(this.capacidadTren);
        this.semVendedorTicket.release();
    }
    
}
