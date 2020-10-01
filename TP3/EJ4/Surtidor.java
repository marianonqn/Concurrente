package TP3.EJ4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Surtidor {

    public void carga(final int carga) {

        try {
            System.out.println("Esta cargando " + Thread.currentThread().getName());
            Thread.sleep(carga * 100);

        } catch (final InterruptedException ex) {

            Logger.getLogger(Thread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}