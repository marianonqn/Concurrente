package TP5.EJ1;

public class Main {

    public static void main(String[] args) {
        
        int numeroPerros = 60;
        int numeroGatos = 40;
        int limiteComedor = 20;
        int comederosSanos = 10;

        Comedor comedor = new Comedor(comederosSanos, limiteComedor, numeroPerros, numeroGatos);
        Thread[] gatos = new Thread[numeroGatos];
        Thread[] perros = new Thread[numeroPerros];

        for(int i = 0; i < gatos.length; i++) {
            gatos[i] = new Thread(new Gato(2, comedor), "Gato" + i);
            gatos[i].start();
        }

        for(int i = 0; i < perros.length; i++) {
            perros[i] = new Thread(new Perro(1, comedor), "Perro" + i);
            perros[i].start();
        }
    }
    
}
