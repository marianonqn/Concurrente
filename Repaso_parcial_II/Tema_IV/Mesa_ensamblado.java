package Repaso_parcial_II.Tema_IV;

import java.util.concurrent.Semaphore;

public class Mesa_ensamblado {

    private Semaphore creacionMangas;
    private Semaphore consumirMangas;
    private Semaphore creacionCuerpos;
    private Semaphore consumirCuerpos;
    private Semaphore creacionSweatter;
    private Semaphore embalarSweatter;
    private int tamanioCajaEmbalaje;
    

    public Mesa_ensamblado(int _maximoCanastoMangas, int _maximoCanastoCuerpos, int _tamanioCajaEmbalaje) {

        this.tamanioCajaEmbalaje = _tamanioCajaEmbalaje;
        this.creacionMangas = new Semaphore(_maximoCanastoMangas, true);
        this.consumirMangas = new Semaphore(0, true);
        this.creacionCuerpos = new Semaphore(_maximoCanastoCuerpos, true);
        this.consumirCuerpos = new Semaphore(0, true);
        this.creacionSweatter = new Semaphore(_tamanioCajaEmbalaje, true);
        this.embalarSweatter = new Semaphore(0, true);

    }
    // metodo creador de mangas

    public void crearMangas() {

        try {
            this.creacionMangas.acquire();
            System.out.println("La costurera deposita una nueva manga en su canasto ---");
            this.consumirMangas.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // metodo creador de cuerpos

    public void crearCuerpos() {

        try {
            this.creacionCuerpos.acquire();
            System.out.println("La costurera deposita un nuevo cuerpo en su canasto ---");
            this.consumirCuerpos.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // metodo creador de sweatters

    public void crearSweatter() {

        try {
            this.consumirMangas.acquire(2);
            System.out.println("La costurera toma dos mangas del canasto de mangas");
            this.creacionMangas.release(2);

            this.consumirCuerpos.acquire();
            System.out.println("La costurera toma un cuerpo del canasto de cuerpos");
            this.creacionCuerpos.release();

            this.creacionSweatter.acquire();
            System.out.println("La costurera ensambla un sweatter------------------------");
            this.embalarSweatter.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void embalarCajaSweatter() {

        if(this.embalarSweatter.tryAcquire(this.tamanioCajaEmbalaje)) {
            System.out.println("La costurera ensambla una caja sweatter!!!!!!!!!!!!!!!!!!!!!!!");

            this.creacionSweatter.release(this.tamanioCajaEmbalaje);
        }

    }
}
