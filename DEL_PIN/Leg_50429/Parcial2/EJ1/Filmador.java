package DEL_PIN.Leg_50429.Parcial2.EJ1;

import java.util.Random;

public class Filmador implements Runnable {

    Episodios bibliotecaEpisodios;
    int duracionBaseFilmacion = 6000;

    public Filmador(Episodios _episodios) {

        this.bibliotecaEpisodios = _episodios;
    }

    @Override
    public void run() {

        while(true) {

            try {
                bibliotecaEpisodios.comenzarFilmacion();
                
                // duracion de la filmacion
                Thread.sleep(new Random().nextInt(1000) + this.duracionBaseFilmacion);
    
                bibliotecaEpisodios.finalizarFilmacion();
    
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    
}
