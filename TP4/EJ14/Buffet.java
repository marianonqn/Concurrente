package TP4.EJ14;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Buffet {

    private Semaphore bebida = new Semaphore(0, true); // variable para el manejo de interacciones con la bebida del empleado
    private Semaphore comida = new Semaphore(0, true); // variable para el manejo de interacciones con la comida del empleado
    private Semaphore ordenCocineroUno = new Semaphore(0, true); // variable para el manejo de interacciones con el cocinero uno
    private Semaphore ordenCocineroDos = new Semaphore(0, true); // variable para el manejo de interacciones con el cocinero dos
    private Semaphore ordenBebida = new Semaphore(0, true); // variable para el manejo de interacciones con la orden delmenu del empleado
    private Semaphore ordenMenu = new Semaphore(0, true); // variable para el manejo de interacciones con la orden del menu del empleado
    private Semaphore atencionMozo = new Semaphore(1, true); // variable para adquirir/bloquear atencion de mozo
    private Semaphore silla = new Semaphore(2, true); // variable para adquirir/bloquear uso de las sillas del buffet
    private String[] menu = { "Opcion-Pollo-1", "Opcion-Pollo-2", "Opcion-Pollo-3", "Opcion-Pollo-4" }; // opciones de menu para seleccion del empleado
    private String[] bebidasMenu = { "Agua", "Agua con gas", "Gaseosa", "Saborizada" }; // opciones de menu para seleccion del empleado

    // metodo para retornar el menu

    public String[] getMenu() {
        return menu;
    }

    // metodo para adquirir silla del buffet

    public void sentarseBuffet(String nombre) {
        try {
            silla.acquire();
            System.out.println("El empleado " + nombre + " se sento en el buffet");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // beber en el buffet
    public void beberEnBuffet(String nombre) {
        try {
            // llamar al mozo
            atencionMozo.acquire();
            System.out.println("El empleado " + nombre + " llama al mozo para pedir una bebida.");

            // el mozo llega a la mesa y pregunta al empleado que va a beber
            System.out.println("El mozo pregunta al empleado " + nombre + " que va a querer beber");

            // el empleado le indica al mozo que va a beber del menu de bebidas
            int aleatorioBebida = new Random().nextInt(this.bebidasMenu.length);
            String opcionBebida = this.menu[aleatorioBebida];
            System.out.println("El empleado " + nombre + " va a beber " + opcionBebida);
            ordenBebida.release();

            // el mozo llega a con la bebida y el empleado la toma
            bebida.acquire();
            System.out.println("El empleado " + nombre + " empieza a beber.");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // metodo para simular el comportamiento del empleado para ir a comer
    public void comerEnBuffet(String nombre) {
        try {

            // se llama la atencion del mozo
            atencionMozo.acquire(); // el mozo deja de crear nuevas versiones de pollo y va a atender al empleado
            System.out.println("El mozo va a atender al empleado " + nombre);

            // el mozo llega a la mesa
            System.out.println("El mozo pregunta al empleado " + nombre + " que va a querer comer");
            ordenMenu.release();

            // tiene el menu y elige entre las opciones y selecciona su opcion
            int aleatorio = new Random().nextInt(this.menu.length);
            String opcionMenu = this.menu[aleatorio];
            System.out.println("El empleado " + nombre + " va a pedir " + opcionMenu);

            // el mozo le trae la comida y empieza a comer
            comida.acquire();
            System.out.println("El empleado " + nombre + " empieza a comer.");
            Thread.sleep(5000); // tiempo para comer

        } catch (Exception e) {

        }
    }

    public void salirBuffet(String nombre) {
        try {
            // el empleado termina de comey y/o beber y se retira
            silla.release();
            System.out.println("El empleado " + nombre + " termina y se levanta de la silla.");
            Thread.sleep(1000); // tiempo para dejar el buffet

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // metodo para simular el flujo de pedido de comida del mozo

    public void atencionBuffet() {
        try {
            // el mozo ya se encuentra en la mesa para tomar la orden
            ordenMenu.acquire();
            System.out.println("El mozo tomó la orden y se la lleva al cocinero.");
            Thread.sleep(1000); // tiempo para llevar la orden al cocinero

            // orden en cocina
            ordenCocinero.release();

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

    public void cocinar() {
        try {
            ordenCocinero.acquire();
            System.out.println("El cocinero tomo la orden y esta cocinando el menu seleccionado");
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }
    
}
