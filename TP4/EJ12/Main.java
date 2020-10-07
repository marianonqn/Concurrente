package TP4.EJ12;

public class Main {

    public static void main(String[] args) {

        Plato platoJaula = new Plato();
        Rueda ruedaJaula = new Rueda();
        Hamaca hamacaJaula = new Hamaca();

        Thread[] hamsters = new Thread[3];

        for(int i = 0; i < hamsters.length; i++) {
            hamsters[i] = new Thread(new Hamster(ruedaJaula, hamacaJaula, platoJaula, "Hamster" + i));
            hamsters[i].start();
        } 
        
    }
       
}