package TP2;

public class testeoRecurso {

    public static void main (final String[] args) {
        final Cliente juan = new Cliente();
        juan.setName("Juan Lopez");
        final Cliente ines = new Cliente();
        ines.setName ("Ines Garcia");
        juan.start();
        ines.start();
    }
}
