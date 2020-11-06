package TP4.EJ14;

import java.util.Random;

public class Empleado implements Runnable {

    private Buffet buffet;
    private String[] opcionesBuffet = {"Beber", "Comer", "Beber y comer"};

    // metodo creador
    public Empleado(Buffet _buffet) {
        this.buffet = _buffet;
    }

    @Override
    public void run() {
        if(this.buffet.tomarSilla(Thread.currentThread().getName())) {
            // tiene el menu y elige entre las opciones y selecciona su opcion
            int aleatorioAccionBuffet = new Random().nextInt(this.opcionesBuffet.length);
            String opcionMenuAccion = this.opcionesBuffet[aleatorioAccionBuffet];
            System.out.println("El empleado " + Thread.currentThread().getName() + " va a " + opcionMenuAccion);

            switch (aleatorioAccionBuffet) {
                case 0:
                    this.buffet.obtenerAtencionMozo(Thread.currentThread().getName());
                    this.buffet.tomarBebida(Thread.currentThread().getName());                    
                    break;
                case 1:
                    this.buffet.comerEnBuffet(Thread.currentThread().getName());                                        
                    break;
                case 2:
                    this.buffet.obtenerAtencionMozo(Thread.currentThread().getName());
                    this.buffet.tomarBebida(Thread.currentThread().getName());   
                    this.buffet.comerEnBuffet(Thread.currentThread().getName());                 
                    break;
                
            }

            this.buffet.dejarSilla(Thread.currentThread().getName());
        }
        
        //this.buffet.comerEnBuffet(Thread.currentThread().getName());
    }

}
