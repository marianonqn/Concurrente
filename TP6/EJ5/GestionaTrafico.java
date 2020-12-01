package TP6.EJ5;

public class GestionaTrafico {

    int autosEsperandoSur;
    int autosEsperandoNorte;
    int autosPasadaNorte;
    int autosPasadaSur;
    int direccionActual; // indica la direccion que tiene el turno. 1 = Norte; 2 = Sur

    public GestionaTrafico() {
        this.autosEsperandoNorte = 0;
        this.autosEsperandoSur = 0;
        this.autosPasadaNorte = 0;
        this.autosPasadaSur = 0;
        this.direccionActual = 0;
    }

    public synchronized void EntrarCocheDelNorte() {

        while (this.direccionActual == 1 && this.autosPasadaSur % 10 != 0 && this.autosEsperandoSur != 0) {
            
            try {
                System.out.println("El auto " + Thread.currentThread().getName() + " que viene del norte debe esperar");
                this.autosEsperandoNorte ++;
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.direccionActual = 2;
        this.autosEsperandoNorte --;
        this.autosPasadaNorte ++;
        this.autosPasadaSur = 0;
        System.out.println("El auto " + Thread.currentThread().getName() + " que viene del norte cruza el puente");
        notifyAll();
    }
    

}