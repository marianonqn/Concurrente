package TP4.EJ9;

public class Pasajero implements Runnable{

    int idPasajero;
    boolean sinTaxi = true;
    private Taxi taxi;

    public Pasajero(int i, Taxi _taxi) {
        idPasajero = i;
        taxi = _taxi;
    }

    public void run() {   
        
        while (sinTaxi) {  // mientras el pasajero no tiene taxi

            System.out.println("Pasajero " + this.idPasajero + " quiere usar el taxi.");
        
            taxi.pasajeroDisponible();  //notificamos al taxista que hay un pasajero disponible       
            
	        taxi.ocuparTaxista();  // esperamos a que el taxista este disponible
        
            sinTaxi = false;  
        
            this.conducir();       
        }   
    }

    /* simular el viaje */
  
    public void conducir(){
        System.out.println("Pasajero " + this.idPasajero + " esta en viaje");
        try {
            Thread.sleep(5050);
        } catch (InterruptedException ex) {

        }
    }
}
