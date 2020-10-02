package TP4.EJ8;

public class Carrera {

    public static void main(String[] args) {
        
        Testigo postaCarrera = new Testigo();
        Thread[] Atletas = new Thread[4];

        for(int i = 0; i < Atletas.length; i++) {
            int numeroCorredor = i + 1;
            Atletas[i] = new Thread(new Atleta(postaCarrera),"Corredor " + numeroCorredor);
            Atletas[i].start();
        }
    }
    
}
