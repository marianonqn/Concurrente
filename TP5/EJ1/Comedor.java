package TP5.EJ1;

import java.util.concurrent.Semaphore;

public class Comedor  {

    Semaphore semComederos;
    int limitePerros;
    int limiteGatos;
    Semaphore semPerros;
    Semaphore semGatos;
    int hanComidoPerros;
    int hanComidoGatos;

    public Comedor(int _comederos, int _limiteEspecie, int _cantidadPerros, int _cantidadGatos) {

        this.semComederos = new Semaphore(_comederos,true);
        this.limitePerros = _limiteEspecie > _cantidadPerros ? _cantidadPerros : _limiteEspecie; 
        this.limiteGatos = _limiteEspecie > _cantidadGatos ? _cantidadGatos : _limiteEspecie;

        semPerros = new Semaphore(limitePerros, true);
        semGatos = new Semaphore(0,true);

        this.hanComidoGatos = 0;
        this.hanComidoPerros = 0;
        
    }

    public void empiezaComer(int idEspecie) throws InterruptedException {

        if(idEspecie == 1) {
            
            semPerros.acquire();

            System.out.println("El perro " + Thread.currentThread().getName() + " tiene su lugar para comer --");

            semComederos.acquire(2);

            System.out.println("El perro " + Thread.currentThread().getName() + " comienza a comer ---!");
            
        } else {

            semGatos.acquire();

            System.out.println("El gato " + Thread.currentThread().getName() + " tiene su lugar para comer **");

            semComederos.acquire();

            System.out.println("El gato " + Thread.currentThread().getName() + " comienza a comer ***!");

        }
    }

    public void terminaComer(int idEspecie) throws InterruptedException {

        this.semComederos.release();

        if(idEspecie == 1) {

            System.out.println("El perro " + Thread.currentThread().getName() + " termina de comer ---/");

            this.hanComidoPerros++;

            if(this.hanComidoPerros == this.limitePerros) {

                System.out.println("---------------- Cambio de especie: perro a gato ----------------------");

                this.hanComidoGatos = 0;
                this.semGatos.release(this.limiteGatos);
            }
        } else {
            System.out.println("El gato " + Thread.currentThread().getName() + " termina de comer ***/");

            this.hanComidoGatos++;

            if(this.hanComidoGatos == this.limiteGatos) {

                System.out.println("---------------- Cambio de especie: gato a perro ----------------------");

                this.hanComidoPerros = 0;
                this.semPerros.release(this.limitePerros);
            }
        }         
    }
}
