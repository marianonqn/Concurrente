package TP3.EJ8;

public class Plato {

    public synchronized void Comer(String name) {

        System.out.println(name + " comienza a comer");

        try {

            Thread.sleep(5000);

            System.out.println(name + " deja de comer");
            
        } catch (Exception e) {
            //TODO: handle exception
            
        }

    }
    
}
