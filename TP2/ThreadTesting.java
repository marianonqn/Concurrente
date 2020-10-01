package TP2;

public class ThreadTesting {
    public static void main(String[] args) {
        //for (int i = 0; i < 500; i++) {
            Thread miHilo = new MiEjecucion();
            miHilo.start();
            try {
                miHilo.join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("En el main");
        //}
    }
    
}
