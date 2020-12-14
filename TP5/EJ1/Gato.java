package TP5.EJ1;

import java.util.Random;

public class Gato implements Runnable {

    int idEspecie;
    Comedor comedor;
    int tiempoComer;

    public Gato(int _idEspecie, Comedor _comedor) {
        idEspecie = _idEspecie;
        comedor = _comedor;
        tiempoComer = 5000;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            this.comedor.empiezaComer(this.idEspecie);
            Thread.sleep(new Random().nextInt(1000) + tiempoComer);
            this.comedor.terminaComer(this.idEspecie);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

    
    
}
