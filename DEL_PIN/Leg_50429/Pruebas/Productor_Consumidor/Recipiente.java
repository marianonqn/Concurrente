package DEL_PIN.Leg_50429.Pruebas.Productor_Consumidor;

import java.util.concurrent.Semaphore;

public class Recipiente {
    
    private Semaphore productor = new Semaphore(1,true);
    private Semaphore consumidor = new Semaphore(0,true);

    private int interaccion;

    public void setNumeroInteraccion(int numeroAleatorio) {
        try {
            productor.acquire();
            System.out.println("Se va a guardar el numero " + numeroAleatorio);
            this.interaccion = numeroAleatorio;
            consumidor.release();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }

    public void getNumeroInteraccion() {
        try {
            consumidor.acquire();
            System.out.println("El numero a consumir es " + this.interaccion);
            productor.release();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}
