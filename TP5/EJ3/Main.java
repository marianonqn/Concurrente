package TP5.EJ3;

public class Main {

    public static void main(String[] args) {

        Tren tren = new Tren(50);

        Thread[] pasajeros = new Thread[70];

        Thread controlador = new Thread(new Controlador(tren));
        Thread vendedor = new Thread(new Vendedor(tren));

        controlador.start();
        vendedor.start();

        for(int i = 0; i<pasajeros.length; i++) {
            pasajeros[i] = new Thread(new Pasajero(tren));

            pasajeros[i].start();
        }
        
    }
    
}
