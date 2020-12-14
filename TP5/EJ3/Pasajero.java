package TP5.EJ3;

public class Pasajero implements Runnable {

    Tren tren;

    public Pasajero(Tren _tren) {
        this.tren = _tren;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        this.tren.comprarTicket();

        System.out.println(Thread.currentThread().getName() + " compra ticket");

        this.tren.subirTren();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        this.tren.bajarTren();
    }
    
}
