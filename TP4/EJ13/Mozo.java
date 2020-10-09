package TP4.EJ13;

public class Mozo implements Runnable {

    private Buffet buffet;

    // metodo creador
    public Mozo(Buffet _buffet) {
        this.buffet = _buffet;
    }

    @Override
    public void run() {
        
       while(true) {
           this.buffet.atencionBuffet();
       }
    }
}
