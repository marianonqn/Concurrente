package TP6.EJ2;

import java.util.Random;

public class Persona implements Runnable{

    private int esJubilado;
    private GestorSala gestorSala;
    private int tiempoMinimoSala;
    private int tiempoMaximoSala;

    public Persona(GestorSala _gestorSala, int _tiempoMinimoSala, int _tiempoMaximoSala) {

        Random rnd = new Random();

        this.gestorSala = _gestorSala;
        this.esJubilado = rnd.nextInt(5);
        this.tiempoMinimoSala = _tiempoMinimoSala;
        this.tiempoMaximoSala = _tiempoMaximoSala;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            //while(true) {
                
                if(this.esJubilado == 0) {

                    System.out.println("La persona " + Thread.currentThread().getName() + " es un jubilado quiere entrar a la sala");
                    
                    this.gestorSala.entrarSalaJubilado();

                    System.out.println("La persona " + Thread.currentThread().getName() + " es un jubilado y  entró a la sala");
                } else {
                    System.out.println("La persona " + Thread.currentThread().getName() + " quiere entrar a la sala");
                    
                    this.gestorSala.entrarSala();

                    System.out.println("La persona " + Thread.currentThread().getName() + " entró a la sala");
                }

                Thread.sleep((int) Math.floor(Math.random() * (this.tiempoMaximoSala- this.tiempoMinimoSala + 1) + this.tiempoMinimoSala));

                System.out.println("La persona " + Thread.currentThread().getName() + " sale de la sala");

                this.gestorSala.salirSala();
            //}
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    
}
