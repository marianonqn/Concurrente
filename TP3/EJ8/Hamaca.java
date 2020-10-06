package TP3.EJ8;

public class Hamaca {

    public synchronized void Hamacarse(String name) {

        System.out.println(name + " comienza a usar la hamaca");

        try {

            Thread.sleep(6000);

            System.out.println(name + " deja de usar la hamaca");
            
        } catch (Exception e) {
            //TODO: handle exception
            
        }

    }
    
}
