package TP5.EJ3;

public class Vendedor  implements Runnable {

    Tren tren;

    public Vendedor(Tren _tren) {
        this.tren = _tren;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        this.tren.venderTicket();

    }

    


    
}
