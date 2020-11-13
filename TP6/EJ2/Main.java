package TP6.EJ2;

public class Main {

    public static void main(String[] args) {

        int minimaEstadia = 3000;
        int maximaEstadia = 6000;
        int limitePersonasSala = 50;
        int umbralTemperatura = 30;
        int limiteExtraordinarioPersonas = 35;

        GestorSala gestor = new GestorSala(limitePersonasSala, umbralTemperatura, limiteExtraordinarioPersonas);

        Thread sensorTemperatura = new Thread(new Sensor(gestor));

        sensorTemperatura.start();
        
        Thread[] visitantes = new Thread[60];

        for(int i = 0; i < visitantes.length; i ++) {
            
            visitantes[i] = new Thread(new Persona(gestor, minimaEstadia, maximaEstadia), "Persona" + i);
            visitantes[i].start();
        }
    }
    
}
