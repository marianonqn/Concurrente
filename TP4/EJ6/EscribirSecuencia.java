package TP4.EJ6;

import java.util.concurrent.Semaphore;

public class EscribirSecuencia {

    private Semaphore semA;
    private Semaphore semB;
    private Semaphore semC;

    public EscribirSecuencia() {
        semA = new Semaphore(1);
        semB = new Semaphore(0);
        semC = new Semaphore(0);
    }

    public void escribirSalida(String letra, int veces) throws InterruptedException {
        
        switch (letra) {
            case "A":
                semA.acquire();

                    for(int i = 0; i < veces; i++) {
                        System.out.print(letra);
                    }

                    semB.release();

            
                
                break;
            case "B":
                semB.acquire();

                    for(int i = 0; i < veces; i++) {
                        System.out.print(letra);
                    }

                    semC.release();

            
                
                break;
        
            case "C":
                semC.acquire();

                    for(int i = 0; i < veces; i++) {
                        System.out.print(letra);
                    }

                    semA.release();

                
                
                break;
        }
    }
    
}
