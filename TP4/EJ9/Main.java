package TP4.EJ9;

public class Main {

    public static void main(String[] args) {
        
        Taxi taxiUnico = new Taxi();

        Thread taxistaDormilon = new Thread(new Taxista(taxiUnico),"Mariano");

        taxistaDormilon.start();

        for (int i=0; i<5; i++) {
            Thread oPasajero = new Thread(new Pasajero(i,taxiUnico));
            oPasajero.start();
            try {
              Thread.sleep(2000);
            } catch(InterruptedException ex) {

            };
        }
    } 
}