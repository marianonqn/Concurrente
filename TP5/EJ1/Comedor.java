package TP5.EJ1;

import java.util.concurrent.Semaphore;

public class Comedor {
    
    private int comederosOcupados = 0;
    private int idEspecie = 0;
    private Semaphore decMascota= new Semaphore(0);
    private Semaphore incMascota;

    public Comedor(int _cantComederos) {
        incMascota = new Semaphore(_cantComederos);
    }

    synchronized int comederosOcupados() { 
        return comederosOcupados; 
    }

    public void comeMascota() throws InterruptedException {
        
        incMascota.acquire();
        synchronized(this) { 
            ++comederosOcupados; 
        }
        decMascota.release();
    }

    public void terminaComerMascota() throws InterruptedException {
        decMascota.acquire();
        synchronized(this) { 
            --comederosOcupados; 
        }
        incMascota.release();
    }
}