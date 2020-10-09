package TP4.EJ13;

import java.util.Random;

public class Empleado implements Runnable {

    private Buffet buffet;

    // metodo creador
    public Empleado(Buffet _buffet) {
        this.buffet = _buffet;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        this.buffet.ocuparSilla(Thread.currentThread().getName()); // el empleado quiere ocupar la unica silla del buffet
        this.buffet.atencionMozo();// una vez sentado adquiere la atencion del mozo
        // tiene el menu y elige entre las opciones
        String opcionMenu = this.seleccionMenu();
        System.out.println("El empleado va a pedir " + opcionMenu);
        this.buffet.comer();
        this.buffet.terminarComer();
    }

    private String seleccionMenu() {
        int aleatorio = new Random().nextInt(this.buffet.getMenu().length);
        return this.buffet.getMenu()[aleatorio];
    }
    
}
