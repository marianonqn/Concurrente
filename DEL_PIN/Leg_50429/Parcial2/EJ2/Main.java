package DEL_PIN.Leg_50429.Parcial2.EJ2;

public class Main {

    public static void main(String[] args) {

        int limiteViajesCarro = 5;
        int limiteCapacidadCarro = 5;
        int pasajerosDisponibles = 20;

        // Recurso compartido
        Carro carroMR  = new Carro(limiteCapacidadCarro, limiteViajesCarro);

        // hilo para operar el carro de la MR
        Thread operador = new Thread(new OperadorCarro(carroMR),"Operador");
        operador.start();

        // Pasajeros de la MR
        Thread[] pasajeros = new Thread[pasajerosDisponibles];

        for(int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Thread(new Pasajero(carroMR), "Pasajero"+i);
            pasajeros[i].start();
        }        
    }
    
}