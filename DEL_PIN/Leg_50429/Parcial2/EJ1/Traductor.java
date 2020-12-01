package DEL_PIN.Leg_50429.Parcial2.EJ1;

import java.util.Random;

public class Traductor implements Runnable {

    Episodios bibliotecaEpisodios;
    int duracionBaseTraduccion = 6000;

    public Traductor(Episodios _episodios) {

        this.bibliotecaEpisodios = _episodios;
    }

    @Override
    public void run() {

        while(true) {

            try {
                bibliotecaEpisodios.comenzarTraduccion();
                
                // duracion de la traduccion
                Thread.sleep(new Random().nextInt(1000) + this.duracionBaseTraduccion);
    
                bibliotecaEpisodios.finalizarTraduccion();
    
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    
}
