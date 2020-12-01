package TP6.EJ4;

public class Comedor {

    int capacidad;
    int mostradorPostre;
    int abridor;
    int lugaresOcupadosComedor;
    int mostradorPostreOcupado;
    int abridorOcupado;

    public Comedor(int _capacidad, int _mostradorPostre, int _abridor) {

        this.capacidad = _capacidad;
        this.mostradorPostre = _mostradorPostre;
        this.abridor = _abridor;
        this.lugaresOcupadosComedor = 0;
        this.mostradorPostreOcupado = 0;
        this.abridorOcupado = 0;
    }

    public synchronized void entrarComedor() {

        while (this.lugaresOcupadosComedor >= capacidad) {

            try {
                System.out.println("El soldado " + Thread.currentThread().getName() + " debe aguardar para entrar en el comedor");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        this.lugaresOcupadosComedor ++;
        System.out.println("El soldado " + Thread.currentThread().getName() + " ingresó al comedor y tomo bandeja");
        notifyAll();

    }

    public synchronized void tomarAbridor() {

        while (this.abridorOcupado >= this.abridor) {

            try {
                System.out.println("El soldado " + Thread.currentThread().getName() + " debe aguardar para abrir la gaseosa");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        this.abridorOcupado ++;
        System.out.println("El soldado " + Thread.currentThread().getName() + " tomó un destapador");
        notifyAll();

    }

    public synchronized void dejarAbridor() {

        this.abridorOcupado --;
        System.out.println("El soldado " + Thread.currentThread().getName() + " abrio gaseosa y dejó un destapador");
        notifyAll();

    }

    public synchronized void ocuparMostradorPostre() {

        while (this.mostradorPostreOcupado >= this.mostradorPostre) {

            try {
                System.out.println("El soldado " + Thread.currentThread().getName() + " debe aguardar para pedir postre");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        this.mostradorPostreOcupado ++;
        System.out.println("El soldado " + Thread.currentThread().getName() + " pide su postre");
        notifyAll();                
    }

    public synchronized void dejarMostradorPostre() {

        this.mostradorPostreOcupado --;
        System.out.println("El soldado " + Thread.currentThread().getName() + " tiene su postre y deja el mostrador");
        notifyAll();

    }
    
    public synchronized void dejarComedor() {

        this.lugaresOcupadosComedor --;
        System.out.println("El soldado " + Thread.currentThread().getName() + " terminó de comer y deja comedor");
        notifyAll();

    }
}
