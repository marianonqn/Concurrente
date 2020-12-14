package DEL_PIN.Leg_50429.Recuperatorio;

public class Main {

    public static void main(String[] args) {


        Rio rio = new Rio();

        Thread[] corderosSedientos = new Thread[10];

        for(int i = 0; i < corderosSedientos.length; i++) {

            corderosSedientos[i] = new Thread(new Cordero(rio),"Cordero"+i);

            corderosSedientos[i].start();
        }
        
    }
    
}
