package Parcial_1.EJ1;

public class Recepcionista implements Runnable{

    CentroHemoterapia centroHemoterapia;

    public Recepcionista (CentroHemoterapia _centro) {

        this.centroHemoterapia = _centro;
    }

    @Override
    public void run() {
                
        while(true) {
            this.centroHemoterapia.entregarTurno();
            this.centroHemoterapia.procesarAlmacenar();            
        }
        
    }
    
}
