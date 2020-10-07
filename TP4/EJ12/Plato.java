package TP4.EJ12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plato {

    private Lock llave = new ReentrantLock(true);

    public void Comer(String name) {

        try {
            llave.lock();

            System.out.println(name + " comienza a comer");

            Thread.sleep(5000);

            
            
        } catch (Exception e) {
            //TODO: handle exception
            
        } finally {

            System.out.println(name + " deja de comer");

            llave.unlock();

        }

    }
    
}
