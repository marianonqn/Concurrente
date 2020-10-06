package TP4.EJ9;

public class Taxista implements Runnable {

    private Taxi taxi;

    public Taxista(Taxi _taxi) {
        taxi = _taxi;
    }
    
    public void run() {
        
        while(true) {  // se ejecuta en bucle infinito        
            
            taxi.tomarPasajero(); // busca cliente, si no lo tiene se duerme
            taxi.despertarTaxista();  // el taxista esta listo para conducir
            this.conducir();  // realizar viaje
           
        }
    }   
    
    /* metodo para simular condicion */
   
    public void conducir(){
    
        System.out.println("El taxista esta conduciendo");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex){ 

        }
    }
}