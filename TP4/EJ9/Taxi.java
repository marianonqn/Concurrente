package TP4.EJ9;

import java.util.concurrent.Semaphore;

public class Taxi {

    Semaphore taxista = new Semaphore(0);
    Semaphore cliente = new Semaphore(0);

    public void ocuparTaxi() {

    }

    public void tomarPasajero() {
        try {
            cliente.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void ocuparTaxista() {
        try {
            taxista.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void despertarTaxista() {
        taxista.release();
    }

    public void pasajeroDisponible() {
        cliente.release();
    }
    
}
