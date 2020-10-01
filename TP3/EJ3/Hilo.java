/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.EJ3;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kolia
 */
public class Hilo extends Thread {

    private Recurso recu;

    public Hilo(Recurso unRecu) {

        this.recu = unRecu;

    }

    public void run() {

        //System.out.println(Thread.currentThread().getName());
        while(!recu.escribir());
        
        

    

}
}


