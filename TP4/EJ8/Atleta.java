package TP4.EJ8;

public class Atleta implements Runnable {

    Testigo testigoCarrera;
    long tiempoInicioCarrera;

    public Atleta(Testigo _testigoCarrera, long _tiempoInicioCarrera) {
        testigoCarrera = _testigoCarrera;
        tiempoInicioCarrera = _tiempoInicioCarrera;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            System.out.println("El atleta " + Thread.currentThread().getName() + " esta en la pista");        
            
            testigoCarrera.tomarTestigo(); // pide el testigo para comenzar a correr
            
            System.out.println("El atleta " + Thread.currentThread().getName() + " toma testigo y empieza a correr"); 
            
            float tiempoCarrera = (float)(Math.random()*(11000-9000+1)+9000);

            Thread.sleep((long) tiempoCarrera); // tiempo en hacer su carrera

            System.out.println("El atleta " + Thread.currentThread().getName() + " termina de correr y entrega testigo");
            
            long tiempoFinCarrera = System.currentTimeMillis(); // tiempo en el que empieza a correr

            long tiempoTotalCarrera = tiempoFinCarrera - tiempoInicioCarrera;

            System.out.println("Tiempo " + Thread.currentThread().getName() + ": " + (long)tiempoCarrera/1000 + " seg");
    
            System.out.println("Tiempo de carrera : " + tiempoTotalCarrera/1000 + " seg");

            testigoCarrera.entregarTestigo(); // finaliza su carrera y entrega el testigo
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    
}
