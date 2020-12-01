package Parcial_1.EJ1;

public class Donante implements Runnable {

    CentroHemoterapia centroHemoterapia;

    public Donante(CentroHemoterapia _centro) {

        this.centroHemoterapia = _centro;
    }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();

        this.centroHemoterapia.pedirTurno(nombre);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (this.centroHemoterapia.admisionDonante(nombre)) {
            this.centroHemoterapia.entrevistaDonante(nombre);
            this.centroHemoterapia.extraccionDonante(nombre);
            this.centroHemoterapia.entregaCertificado(nombre);
        }
    }    
}