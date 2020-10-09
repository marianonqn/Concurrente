package TP4.EJ13;

import java.util.concurrent.Semaphore;

public class Buffet {

    private Semaphore comida = new Semaphore(0); // variable para el manejo de interacciones con la comida del empleado
    private Semaphore ordenMenu = new Semaphore(0); // variable para el manejo de interacciones con la orden del menu del empleado
    private Semaphore atencionMozo = new Semaphore(0); // variable para adquirir/bloquear atencion de mozo
    private Semaphore silla = new Semaphore(1); // variable para adquirir/bloquear uso de la silla del buffet
    private String[] menu = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"}; // opciones de menu para seleccion del empleado

    //metodo para retornar el menu 

    public String[] getMenu () {
        return menu;
    }
    
    // metodo para ocupar la silla por el empleado
    public void ocuparSilla(String nombre) {
        try {
            silla.acquire();
            System.out.println("El empleado " + nombre + " ocupó la slla del buffet.");
            Thread.sleep(200);
            atencionMozo.release();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    // metodo para que el empleado obtenga la atencion del mozo

    public void atencionMozo() {
        try {
            atencionMozo.acquire(); // el mozo deja de crear nuevas versiones de pollo
            System.out.println("El mozo va a atender al empleado.");
            Thread.sleep(1000);
            System.out.println("El mozo pregunta al empleado que va a querer comer");
            ordenMenu.release();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    // metodo para reflejar las acciones que hace el emplado al dejar de servir
    public void dejarServir() {
        try {
            atencionMozo.release();
            System.out.println("El mozo sirvió el menu al empleado y vuelva a crear nuevas versiones de pollo.");
            Thread.sleep(200);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    // metodo para que el empleado le diga al mozo que opcion del menu quiere comer

    public void tomarOrden() {
        try {
            ordenMenu.acquire();
            System.out.println("El mozo tomó la orden y se la lleva al cocinero.");            
            Thread.sleep(1000); // tiempo para llevar la orden al cocinero
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    // metodo para que el mozo lleve la comida a la mesa del empleado

    public void llevarComida() {
        try {
            comida.release();
            System.out.println("El mozo lleva la comida al empleado.");            
            Thread.sleep(1000); // tiempo para llevar la comida
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    // metodo para indicar que el empleado esta comiendo
    public void comer() {
        try {
            comida.acquire();
            System.out.println("El empleado empieza a comer.");
            Thread.sleep(5000); // tiempo para comer
        } catch (Exception e) {
            //TODO: handle exception
        }
    }  
    
    // metodo para reflejar que el empleado termino de comer y se retira del buffet

    public void terminarComer() {
        try {
            silla.release();
            System.out.println("El empleado termina de comer y se levanta de la silla.");
            Thread.sleep(1000); // tiempo para dejar el buffet
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}
