package TP6.EJ4;

public class Main {

    public static void main(String[] args) {
        
        Thread[] regimiento = new Thread[100];

        Comedor comedor = new Comedor(50, 3, 10);

        for(int i = 0; i < regimiento.length; i++) {
            regimiento[i] = new Thread(new Soldado(comedor),"Soldado"+i);
            regimiento[i].start();
        }
    }
    
}
