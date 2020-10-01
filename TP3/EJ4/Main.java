package TP3.EJ4;

public class Main {

    public static void main(String[] args) {

        Surtidor sp = new Surtidor();
        Auto a = new Auto(sp); 
               
        a.setCapacidadSinReserva(40);

        Thread auto1 = new Thread(a,"Renault");
        Thread auto2 = new Thread(a, "Chevrolet");
        Thread auto3 = new Thread(a,"BMW");
        Thread auto4 = new Thread(a, "Fiat");
        Thread auto5 = new Thread(a,"Ford");

        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
    }   
}
