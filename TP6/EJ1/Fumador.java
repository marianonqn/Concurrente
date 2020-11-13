package TP6.EJ1;

public class Fumador implements Runnable{

    private int id;
    private SalaFumadores sala;

    public Fumador(int id, SalaFumadores sala){
        this.id = id;
        this.sala = sala;
    }
    
    //constructor
    public void run(){
        while(true){
            //.....
            try {
                sala.entrafumar(id);
                System.out.println("Fumador " + id + " está fumando.");
                Thread.sleep(1000);
                sala.terminafumar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//catch
        }//while
    }//run
}// clase
