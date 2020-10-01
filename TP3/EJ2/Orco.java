package TP3.EJ2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Orco implements Runnable{

    private JugadorRol jugador = new JugadorRol();
    
     // metodo para chequear que el jugador tiene puntos de vida para recibir el golpe
    private void checkHit() throws InterruptedException {       
        
        
        
        if (jugador.getPuntosVida() <= 0) {
            System.out.println ( Thread.currentThread().getName() + ": quiere golpear a un jugador que ha muerto. Puntos de vida de jugador = " + jugador.getPuntosVida());
            
        } else {
            jugador.recibirGolpe(3);
            System.out.println(Thread.currentThread().getName() +": Ha realizado un golpe efectivo al jugador.");
            
            if (jugador.getPuntosVida() < 0) {
                System.out.println(Thread.currentThread().getName() +": Ha matado al jugador. Los puntos de vida equivalen a : " + jugador.getPuntosVida());
            } else {
                System.out.println(Thread.currentThread().getName() +": Ha debilitado. Los puntos de vida equivalen a : " + jugador.getPuntosVida());
            }
            
            
        }
    }

    @Override
    public void run() {
        synchronized(jugador) {            
            
            try {
                this.checkHit();                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Orco.class.getName()).log(Level.SEVERE, null, ex); 
            }
            
        }

    }

    public void setJugador(JugadorRol jugadorParametro) {
        jugador = jugadorParametro;
    }
    
}
