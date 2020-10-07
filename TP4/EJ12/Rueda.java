package TP4.EJ12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Rueda {

    private Lock llave = new ReentrantLock(true);

    public void Rodar(String name) {       

        try {
            llave.lock();
            
            System.out.println(name + " comienza a usar la rueda");

            Thread.sleep(3000);           
            
        } catch (Exception e) {
            //TODO: handle exception

        } finally {
            System.out.println(name + " deja de usar la rueda");

            llave.unlock();
        }

    }
    
}
