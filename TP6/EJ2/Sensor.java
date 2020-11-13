package TP6.EJ2;

import java.security.Principal;

public class Sensor implements Runnable {

    private int temperaturaRegistrada;
    private int temperaturaMinima = 24;
    private int temperaturaMaxima = 50;
    private GestorSala gestorSala;
    private int tiempoSensor = 1000;

    public Sensor(GestorSala _gestorSala) {
        this.gestorSala = _gestorSala;
    }

    private int registrarTemperatura() {

        int tmp = (int) Math.floor(Math.random() * (this.temperaturaMaxima - this.temperaturaMinima + 1) + this.temperaturaMinima);

        return tmp;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            
            while (true) {

                this.temperaturaRegistrada = this.registrarTemperatura();
                
                System.out.println("La temperatura actual registrada es de " + this.temperaturaRegistrada + "°C");
                
                this.gestorSala.notificarTemperatura(this.temperaturaRegistrada);            
                Thread.sleep(tiempoSensor);

            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
}
