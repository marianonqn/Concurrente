package DEL_PIN.Leg_50429.Recuperatorio;

import java.util.Random;

public class Cordero implements Runnable {

    Rio rio;
    int tiempoBeber = 5000;
    int tiempoSed = 10000;

    public Cordero(Rio _rio) {

        this.rio = _rio;

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        while(true) {
            try {
                this.rio.pedirAccesoRioCordero();

                this.rio.permisoAccesoRioCordero();
                
                Thread.sleep(new Random().nextInt(1000) + this.tiempoBeber);

                this.rio.terminarBeber();

                System.out.println("El cordero " + Thread.currentThread().getName() + " está satisfecho y quiere dejar el rio");

                this.rio.permisoAbandonarRioCordero();

                Thread.sleep(new Random().nextInt(1000) + this.tiempoSed);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    
    
}
