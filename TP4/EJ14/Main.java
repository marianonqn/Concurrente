package TP4.EJ14;

public class Main {

    public static void main(String[] args) {

        Buffet buffetEmpleados = new Buffet(); // creamos la instancia de buffet

        Thread[] empleados = new Thread[6]; // creamos los hilos empleados

        Thread mozoBuffet = new Thread(new Mozo(buffetEmpleados), "Pepe");

        Thread cocineroBuffet = new Thread(new Cocinero(buffetEmpleados), "Carlos");

        mozoBuffet.start();
        cocineroBuffet.start();

        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = new Thread(new Empleado(buffetEmpleados), "Empleado "+i);
            empleados[i].start();
        }
        
    }
    
}
