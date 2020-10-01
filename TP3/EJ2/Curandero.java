package TP3.EJ2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Curandero implements Runnable{

    private JugadorRol jugador = new JugadorRol();
    
     // metodo para chequear que el jugador tiene puntos de vida para recibir el golpe
    @Override
    public void run() {        

        synchronized(jugador) {            
            try {
                
                jugador.recibirCura(3);
                System.out.println(Thread.currentThread().getName() +": Ha curado al jugador.");
                if(jugador.getPuntosVida() <=3 ) {
                    System.out.println(Thread.currentThread().getName() +": El jugador ha revivido. Puntos de vida:" + jugador.getPuntosVida());
                } else {
                    System.out.println(Thread.currentThread().getName() +": El jugador se ha fortalecido. Puntos de vida:" + jugador.getPuntosVida());
                }                        
                
            } catch (Exception ex) {
                Logger.getLogger(Orco.class.getName()).log(Level.SEVERE, null, ex); 
            }
            
        }

    }

    public void setJugador(JugadorRol jugadorParametro) {
        jugador = jugadorParametro;
    }
    
}
