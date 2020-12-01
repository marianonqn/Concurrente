package Parcial_1.EJ1;

public class Main {

    public static void main(String[] args) {

        CentroHemoterapia centroHemoterapia = new CentroHemoterapia();

        Thread recepcionista = new Thread(new Recepcionista(centroHemoterapia));
        Thread[] donantes = new Thread[3];

        for(int i = 0; i < donantes.length; i++) {
            donantes[i] = new Thread(new Donante(centroHemoterapia),"Donante"+i);

            donantes[i].start();
        }

        recepcionista.start();        
    }
    
}
