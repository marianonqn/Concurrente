package DEL_PIN.Leg_50429.Recuperatorio;

import java.util.concurrent.Semaphore;

public class Rio {

    private Semaphore semCorderosSedientos;
    private Semaphore semCorderosBebiendo;
    private Semaphore semCorderosSatisfechos;
    private Semaphore mutexAcceso;
    private Semaphore mutexSalir;
    private Semaphore mutexSatisfecho;
    
    public Rio() {
        this.semCorderosSatisfechos = new Semaphore(0,true);
        this.semCorderosBebiendo = new Semaphore(0,true);
        this.semCorderosSedientos = new Semaphore(0,true);
        this.mutexAcceso = new Semaphore(1,true);
        this.mutexSalir = new Semaphore(1,true);
        this.mutexSatisfecho = new Semaphore(1,true);
    }

    // metodos cordero

    public void pedirAccesoRioCordero() {

        this.semCorderosSedientos.release();

        System.out.println("El cordero " + Thread.currentThread().getName() + " quiere tomar agua");
    }

    public void permisoAccesoRioCordero() throws InterruptedException {

        // hay un cordero bebiendo

        this.mutexAcceso.acquire();
        
        if (this.semCorderosBebiendo.tryAcquire()) {

            System.out.println("El cordero " + Thread.currentThread().getName() + " puede acceder al rio ya que hay otro bebiendo");

            this.semCorderosSedientos.acquire();

            this.semCorderosBebiendo.release();
        } else {
            this.semCorderosSedientos.acquire(2);

            System.out.println("Acceden 2 corderos al río ya que no estaba bebiendo ninguno");

            this.semCorderosBebiendo.release(2);
        }

        this.mutexAcceso.release();

    }

    public void terminarBeber() throws InterruptedException {
        
        this.mutexSatisfecho.acquire();   
        
        this.semCorderosSatisfechos.release();

        this.semCorderosBebiendo.acquire();
        
        this.mutexSatisfecho.release();
    }

    public void permisoAbandonarRioCordero() throws InterruptedException {

        this.mutexAcceso.acquire();

        if(this.semCorderosBebiendo.tryAcquire(2)) {

            System.out.println("El cordero " + Thread.currentThread().getName() + " deja el río");

            this.semCorderosBebiendo.release(2);

            this.semCorderosSatisfechos.acquire();
        } else {

            this.semCorderosSatisfechos.acquire(2);

            System.out.println("Dos corderos dejan el río");
        }

        this.mutexAcceso.release();

    }

    
}
