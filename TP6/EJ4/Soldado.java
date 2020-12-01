package TP6.EJ4;

import java.util.Random;

public class Soldado implements Runnable {

    private Comedor comedor;
    private int pidePostre;
    private int pideGaseosa;

    public Soldado(Comedor _comedor) {
        this.comedor = _comedor;

        Random rnd = new Random();

        this.pideGaseosa = rnd.nextInt(2);
        this.pidePostre = rnd.nextInt(3);
    }

    @Override
    public void run() {

        try {
            // entrar al comedor
            this.comedor.entrarComedor();       
            Thread.sleep(2000);        

            if(this.pideGaseosa == 0) {
                // el soldado pidio gaseosa
                this.comedor.tomarAbridor();
                Thread.sleep(1000);
                this.comedor.dejarAbridor();
            }

            if(this.pidePostre == 0) {
                // el soldado pidio postre
                this.comedor.ocuparMostradorPostre();;
                Thread.sleep(3000);
                this.comedor.dejarMostradorPostre();
            }

            // el soldado come y deja el comedor
            this.comedor.dejarComedor();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    
}
