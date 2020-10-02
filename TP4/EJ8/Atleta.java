package TP4.EJ8;

import java.util.Random;

public class Atleta implements Runnable {

    Testigo testigoCarrera;

    public Atleta(Testigo _testigoCarrera) {
        testigoCarrera = _testigoCarrera;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            System.out.println("El atleta " + Thread.currentThread().getName() + " esta en la pista");        
            
            testigoCarrera.tomarTestigo(); // pide el testigo para comenzar a correr
            
            System.out.println("El atleta " + Thread.currentThread().getName() + " toma testigo y empieza a correr"); 
            
            Random r = new Random(System.currentTimeMillis()); // tiempo en el que empieza a correr

            Thread.sleep(r.nextInt(10000)); // tiempo en hacer su carrera

            System.out.println("El atleta " + Thread.currentThread().getName() + " termina de correr y entrega testigo");
            
            testigoCarrera.entregarTestigo(); // finaliza su carrera y entrega el testigo


        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    
}
