package TP3.EJ8;

public class Rueda {

    public synchronized void Rodar(String name) {

        System.out.println(name + " comienza a usar la rueda");

        try {

            Thread.sleep(3000);

            System.out.println(name + " deja de usar la rueda");
            
        } catch (Exception e) {
            //TODO: handle exception

        }

    }
    
}
