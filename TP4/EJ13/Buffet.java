package TP4.EJ13;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Buffet {

    private Semaphore comida = new Semaphore(0); // variable para el manejo de interacciones con la comida del empleado
    private Semaphore ordenMenu = new Semaphore(0); // variable para el manejo de interacciones con la orden del menu del empleado
    private Semaphore atencionMozo = new Semaphore(1); // variable para adquirir/bloquear atencion de mozo
    private Semaphore silla = new Semaphore(1); // variable para adquirir/bloquear uso de la silla del buffet
    private String[] menu = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"}; // opciones de menu para seleccion del empleado

    //metodo para retornar el menu 

    public String[] getMenu () {
        return menu;
    }
    
    // metodo para simular el comportamiento del empleado para ir a comer
    public void comerEnBuffet(String nombre) {
        try {

            silla.acquire(); // adquirir silla del buffet -- Es una sola silla
            System.out.println("El empleado " + nombre + " ocupó la slla del buffet.");
            Thread.sleep(200);
            
            // se llama la atencion del mozo
            atencionMozo.acquire(); // el mozo deja de crear nuevas versiones de pollo y va a atender al empleado
            System.out.println("El mozo va a atender al empleado " + nombre);
            Thread.sleep(1000);
            
            // el mozo llega a la mesa
            System.out.println("El mozo pregunta al empleado " +  nombre + " que va a querer comer");
            ordenMenu.release();

            // tiene el menu y elige entre las opciones y selecciona su opcion
            int aleatorio = new Random().nextInt(this.menu.length);
            String opcionMenu = this.menu[aleatorio];
            System.out.println("El empleado " + nombre + " va a pedir " + opcionMenu);
            
            // el mozo le trae la comida y empieza a comer
            comida.acquire();
            System.out.println("El empleado " + nombre + " empieza a comer.");
            Thread.sleep(5000); // tiempo para comer

            // el empleado termina de comer y se retira
            silla.release();
            System.out.println("El empleado " + nombre +" termina de comer y se levanta de la silla.");
            Thread.sleep(1000); // tiempo para dejar el buffet

        } catch (Exception e) {

        }
    }

    // metodo para simular la atencion del mozo en el buffet

    public void atencionBuffet() {
        try {
            // el mozo ya se encuentra en la mesa para tomar la orden
            ordenMenu.acquire();
            System.out.println("El mozo tomó la orden y se la lleva al cocinero.");            
            Thread.sleep(1000); // tiempo para llevar la orden al cocinero

            // el cocinero termino de cocinar y el mozo lleva la comida al empleado
            comida.release();
            System.out.println("El mozo lleva la comida al empleado.");            
            Thread.sleep(1000); // tiempo para llevar la comida

            // el mozo termina de atender y se pone a crear de nuevo
            atencionMozo.release();
            System.out.println("El mozo sirvió el menu al empleado y vuelva a crear nuevas versiones de pollo.");
            Thread.sleep(200);
        } catch (Exception e) {
            
        }
    }  
    
}
