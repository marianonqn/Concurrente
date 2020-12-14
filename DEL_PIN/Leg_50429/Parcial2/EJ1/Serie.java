package DEL_PIN.Leg_50429.Parcial2.EJ1;

import java.util.concurrent.Semaphore;

public class Serie {
    
    private Semaphore semFilmador;
    private Semaphore semTraductor;
    private int capitulosDisponibles, capitulosTraducidos;
    String [] episodiosEspaniol;
    String [] episodiosIngles;

    public Serie() {
        this.semFilmador = new Semaphore(1,true);
        this.semTraductor = new Semaphore(0,true);
        this.capitulosDisponibles = 0;
        this.capitulosTraducidos = 0;
        //this.capitulosDisponiblesIngles = 0;
        this.episodiosEspaniol = new String[100];
        this.episodiosIngles = new String[100];        
    }

    public void iniciarFilmacionCapitulo() throws InterruptedException {

        this.semFilmador.acquire();
        System.out.println("Se comienza con la filmación del capitulo " + this.capitulosDisponibles ++);

    }

    public void terminarFilmacionCapitulo() throws InterruptedException {

        System.out.println("Se termina con la filmación del capitulo " + this.capitulosDisponibles);
        this.episodiosEspaniol[this.capitulosDisponibles - 1] = "Capitulo " + this.capitulosDisponibles;
        this.semFilmador.release();
        this.semTraductor.release();    
    }

    public void iniciarTraducccionCapitulo() throws InterruptedException {

        this.semTraductor.acquire();
        System.out.println("Se comienza con la traduccion de " + this.episodiosEspaniol[this.capitulosTraducidos]);

    }
}
