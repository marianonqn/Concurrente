package TP4.EJ14;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Buffet {

    private Semaphore comida = new Semaphore(0, true); // variable para el manejo de interacciones con la comida del empleado
    private Semaphore bebida = new Semaphore(0, true); // variable para el manejo de interacciones con la bebida del empleado

    private Semaphore hobbieMozo = new Semaphore(0, true);
    private Semaphore limpiarCocina = new Semaphore(0, true);

    private Semaphore ordenBebida = new Semaphore(0, true); // variable para el manejo de interacciones con la orden del menu del empleado
    private Semaphore ordenMenu = new Semaphore(0, true); // variable para el manejo de interacciones con la orden del menu del empleado
    
    private Semaphore atencionMozo = new Semaphore(1, true); // variable para adquirir/bloquear atencion de mozo
    private Semaphore atencionCocinero = new Semaphore(1, true);

    private String[] menu = { "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4" }; // opciones de menu para seleccion del empleado
    private String[] menuBebida = { "Agua", "Agua sin gas", "Gaseosa", "Bebida" }; // opciones de menu de bebidas para seleccion del empleado
    
    private int sillasDisponibles = 2;
    private int minimo = 1000;
    private int maximo = 5000;

    // metodo para retornar el menu

    public String[] getMenu() {
        return menu;
    }

    public synchronized boolean tomarSilla(String nombre) {
        System.out.println("El empleado " + nombre + " llega al buffet y quiere saber si hay un lugar libre en el buffet");

        if (sillasDisponibles > 0) {
            // Hay sillas disponibles para que el usuario se siente
            sillasDisponibles--;
            System.out.println("El empleado " + nombre + " ocupa una silla");
            return true;
        } else {
            System.out.println("No hay lugares libres para el empleado " + nombre + ". Vuelve a trabajar");
            return false;
        }
    }

    public synchronized void dejarSilla(String nombre) {
        System.out.println("El empleado " + nombre + " terminó y deja el buffet");

        sillasDisponibles++;
    }

    public void obtenerAtencionMozo(String nombre) {
        try {
            System.out.println("El empleado " + nombre + " llama al mozo");
            
            // el mozo deja de realizar su hobbie
            
            hobbieMozo.release();

            atencionMozo.acquire();

            // el mozo llega a la mesa
            System.out.println("El mozo va a la mesa y pregunta al empleado " + nombre + " que va a querer tomar");

            // tiene el menu y elige entre las opciones y selecciona su opcion
            int aleatorioBebida = new Random().nextInt(this.menuBebida.length);
            String opcionMenuBebida = this.menuBebida[aleatorioBebida];
            System.out.println("El empleado " + nombre + " va a tomar " + opcionMenuBebida);

            ordenBebida.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void buscarBebida() {
        try {
            // el mozo recibe la orden y va a buscar la bebida
            ordenBebida.acquire();
            // el mozo lleva la bebida a la mesa
            System.out.println("El mozo busca la bebida seleccionada por el empleado y la lleva a la mesa");
            bebida.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void tomarBebida(String nombre) {
        try {
            // el empleado recibe la bebida y la toma
            bebida.acquire();
            // el empleado agradece al moz y lo despide
            System.out.println("El empleado " + nombre + " recibe su bebida y agradece al mozo");
            
            atencionMozo.release();
            hobbieMozo.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void hacerHobbie() {
        System.out.println("El mozo tiene tiempo libre y realiza nuevas versiones de pollo");
        try {
            hobbieMozo.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void limpiar() {
        System.out.println("El cocinero se va a limpiar la cocina");
        try {
            limpiarCocina.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // metodo para simular el comportamiento del empleado para ir a comer
    public void comerEnBuffet(String nombre) {
        try {

            // se llama la atencion del cocinero que deja de limpiar la cocina
            limpiarCocina.release();
            
            atencionCocinero.acquire(); // el cocinero deja de limpiar 
            System.out.println("El cocinero pregunta al empleado " + nombre + " que va a querer comer");
            
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

    // metodo para simular la atencion del mozo en el buffet

    public void atencionCocinero() {
        try {
            // el cocinero toma la orden y se pone a cocinar
            ordenMenu.acquire();
            System.out.println("El cocinero toma la orden y se pone a cocinar.");            
            Thread.sleep(1000); // tiempo de cocinar

            // el cocinero termino de cocinar y entrega la comida
            comida.release();
            System.out.println("El cocinero sirve al empleado.");            
            Thread.sleep(1000); // tiempo para llevar la comida

            // el cocinero termina de cocinar y se va a limpiar la cocina
            atencionCocinero.release();
            limpiarCocina.release();
        } catch (Exception e) {
            
        }
    }  
    
}