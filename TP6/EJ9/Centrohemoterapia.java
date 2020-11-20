package TP6.EJ9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Centrohemoterapia {

    private int maxCamas;
    private int maxRevistas;
    private int camasOcupadas, revistasOcupadas;
    private Lock contadorCamas;
    private Lock contadorRevistas;
    private Condition hayCama;
    private Condition hayRevista;

    public Centrohemoterapia(int _camas, int _revistas) {

        this.maxCamas = _camas;
        this.maxRevistas = _revistas;
        this.contadorCamas = new ReentrantLock(true);
        this.contadorRevistas = new ReentrantLock(true);
        this.revistasOcupadas = 0;
        this.camasOcupadas = 0;
        this.hayCama =  contadorCamas.newCondition();
        this.hayRevista = contadorRevistas.newCondition();
    }

    public void accesoSalaEspera() {

        try {
            // el donante llega a la sala se anuncia y aguarda en la sala hasta que lo llamen para ocupar una cama
            // para entrenerse busca una revista

            this.contadorRevistas.lock();

            while (this.revistasOcupadas >= this.maxRevistas) {

                System.out.println("El donante " + Thread.currentThread().getName() + " aguarda en la sala viendo Cronica TV");

                hayRevista.await();

            }

            System.out.println("El donante " + Thread.currentThread().getName() + " aguarda en la sala viendo una revista");

            this.revistasOcupadas ++;

        } catch (InterruptedException e) {

        } finally {
            this.contadorRevistas.unlock();
        }
    }

    public void dejarSalaEspera() {

        // Suponemos que el donante estaba leyendo una revista en la sala (siempre)
        this.contadorRevistas.lock();
        
        System.out.println("El donante " + Thread.currentThread().getName() + " dejó la sala de espera");        
        
        revistasOcupadas --;
        
        hayRevista.signalAll();
        
        this.contadorRevistas.unlock();
    }

    public void accesoCama() {

        try {
            // el donante sale de la sala de espera y va por una cama. 

            this.contadorCamas.lock();

            while (this.camasOcupadas >= this.maxCamas) {

                System.out.println("El donante " + Thread.currentThread().getName() + " aguarda por una cama");

                hayCama.await();

            }

            System.out.println("El donante " + Thread.currentThread().getName() + " se acuesta y empieza a donar sangre");

            this.camasOcupadas ++;

        } catch (InterruptedException e) {

        } finally {
            this.contadorCamas.unlock();
        }
    }

    public void dejarCama() {

        // Suponemos que el donante dejo la cama
        this.contadorCamas.lock();
        
        System.out.println("El donante " + Thread.currentThread().getName() + " dejó la cama");        
        
        camasOcupadas--;
        
        hayCama.signalAll();
        
        this.contadorCamas.unlock();
    }
        
    
}
