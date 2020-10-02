package TP4.EJ8;

import java.util.concurrent.Semaphore;

public class Testigo {

    Semaphore testigo = new Semaphore(1,true);

    public void entregarTestigo() {
        
        testigo.release();

    }

    public void tomarTestigo() throws InterruptedException {
        
        testigo.acquire();
    }
    
}
