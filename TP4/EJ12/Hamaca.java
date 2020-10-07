package TP4.EJ12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hamaca {

    private Lock llave = new ReentrantLock(true);

    public void Hamacarse(String name) {

        try {

            llave.lock();

            System.out.println(name + " comienza a usar la hamaca");

            Thread.sleep(6000);         
            
        } catch (Exception e) {
            //TODO: handle exception
            
        } finally {
            System.out.println(name + " deja de usar la hamaca");
            llave.unlock();
        }

    }
    
}
