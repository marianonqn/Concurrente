package TP4.EJ14;

public class Cocinero implements Runnable{

    private Buffet buffet;

    // metodo creador
    public Cocinero(Buffet _buffet) {
        this.buffet = _buffet;
    }

    @Override
    public void run() {
       
       while(true) {

           buffet.atencionCocinero();
           buffet.limpiar();
       }
        
    }
}
