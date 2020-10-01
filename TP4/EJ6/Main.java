package TP4.EJ6;

public class Main 
{ 
    public static void main(String args[]) throws InterruptedException  
    { 
        // creamos un objeto compartido

        EscribirSecuencia objCompartido = new EscribirSecuencia();
          
        // creamos tres hilos a las que les asignanos una letra, 
        //cantidad de veces a escribir esa letra y un orden

       

        HiloEscritor he1 = new HiloEscritor("A", 1, objCompartido); 
        HiloEscritor he2 = new HiloEscritor("B", 2, objCompartido); 
        HiloEscritor he3 = new HiloEscritor("C", 3, objCompartido); 
          
        // stating threads A and B 
        he1.start(); 
        he2.start(); 
        he3.start();

       
              
    } 
} 
