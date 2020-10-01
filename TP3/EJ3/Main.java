/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ3;

/**
 *
 * @author Kolia
 */
public class Main {
    public static void main (String[] args) throws InterruptedException{
    Thread[] hilos= new Thread[3];
    Recurso compartido=new Recurso();
    
        for (int i = 0; i < 3; i++) {
            hilos[i]= new Hilo(compartido);
            hilos[i].setName("Hilo"+(i+1));
            hilos[i].start();
        }
        for (int i = 0; i < 3; i++) {
            
            hilos[i].join();
        }
        System.out.println("");
    }
}
