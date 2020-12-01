package DEL_PIN.Leg_50429.Parcial2.EJ1;

import java.util.concurrent.Semaphore;

public class Episodios {

    private int episodioActual;
    private int ultimoEpisodioTraducido;
    private String[] episodiosEspaniol;
    private String[] episodiosIngles;
    private Semaphore semFilmador;
    private Semaphore semTraductor;
    private Semaphore semBibliotecaEspaniol;
    private Semaphore semBibliotecaIngles;
    private Semaphore semSocios;

    public Episodios(int _cantidadMaximaEpisodios) {

        this.episodioActual = 0;
        this.ultimoEpisodioTraducido = 0;
        this.episodiosEspaniol = new String[_cantidadMaximaEpisodios];
        this.episodiosIngles = new String[_cantidadMaximaEpisodios];
        this.semFilmador = new Semaphore(1,true);
        this.semTraductor = new Semaphore(0,true);
        this.semBibliotecaEspaniol = new Semaphore(0,true);
        this.semBibliotecaIngles = new Semaphore(0,true);
        this.semSocios = new Semaphore(0,true);
    }   
  
    public void comenzarTraduccion() {
      try {
        semTraductor.acquire();
      } catch (InterruptedException e) {
        System.out.println("InterruptedException caught");
      }
      this.ultimoEpisodioTraducido ++;
      System.out.println("Se comenzó la traduccion de episodio " + this.ultimoEpisodioTraducido);      
      semFilmador.release();
    }

    public void finalizarTraduccion() {

        semTraductor.release();

        System.out.println("Se culminó la traduccion del episodio " + this.ultimoEpisodioTraducido);

        this.episodiosIngles[this.episodioActual] = "Episodio " + this.ultimoEpisodioTraducido;

        semBibliotecaIngles.release();

        semSocios.release();

    }
  
    public void comenzarFilmacion() {
      try {
        semFilmador.acquire();
      } catch (InterruptedException e) {
        System.out.println("InterruptedException caught");
      }
  
      this.episodioActual ++;
      System.out.println("Se comenzó la filmación del episodio " + this.episodioActual);
      
    }

    public void finalizarFilmacion () {
        
        this.episodiosEspaniol[this.episodioActual] = "Episodio " + this.episodioActual;

        System.out.println("Se filmo el capitulo " + this.episodioActual);
      
        semTraductor.release();
      
        semBibliotecaEspaniol.release();
    }
}
