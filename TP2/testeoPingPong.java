package TP2;

public class testeoPingPong {

    public static void main(String[] args){

        PingPong t1 =new PingPong("PING",33);
        PingPong t2= new PingPong("PONG",10);

        // Activación
        t1.start();
        t2.start();
        // Espera unos segundos

        
        try{
            Thread.sleep(5000);
            for(int i=0;i<5000;i++) {
                Thread.sleep(5000);
                System.out.println("contador=" + i);
            }
            
        }catch (InterruptedException e){
            System.out.println("Error de ejecucion");
        };
        // Finaliza la ejecución de los threads
        System.out.println("Fin de partida de ping-pong");
        
    }
    
}
