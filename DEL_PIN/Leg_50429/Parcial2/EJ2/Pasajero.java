package DEL_PIN.Leg_50429.Parcial2.EJ2;

import java.util.Random;

public class Pasajero implements Runnable {

    Carro carro;
    Random r;
    int duracionVuelta;

    public Pasajero(Carro _carro) {
        this.carro = _carro;
        this.r = new Random();
        this.duracionVuelta = 10000;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (true && !carro.juegoCerrado()) {

            System.out.println("El pasajero " + Thread.currentThread().getName() + " quiere subir a la MR");
            carro.subirCarro();
            // el pasajero aguarda hasta que el carro este lleno y por la vuelta a la MR
            try {
                Thread.sleep(duracionVuelta);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // el pasajero ya dio la vuelta en MR y debe bajar
            carro.bajarCarro();
            // el pasajero va a dar una vuelta al parque para luego volver a la MR
            try {
                Thread.sleep(r.nextInt(5000) + 6000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
    
}
