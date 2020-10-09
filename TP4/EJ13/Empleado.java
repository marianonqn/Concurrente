package TP4.EJ13;

public class Empleado implements Runnable {

    private Buffet buffet;

    // metodo creador
    public Empleado(Buffet _buffet) {
        this.buffet = _buffet;
    }

    @Override
    public void run() {
        this.buffet.comerEnBuffet(Thread.currentThread().getName());
    }

}
