package TP5.EJ3;

public class Controlador implements Runnable {

    Tren tren;

    public Controlador(Tren _tren) {
        this.tren = _tren;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        this.tren.ponerMarchaTren();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.tren.detenerTren();

    }
    
}
