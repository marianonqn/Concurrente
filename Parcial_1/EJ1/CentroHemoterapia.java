package Parcial_1.EJ1;

import java.util.concurrent.Semaphore;

public class CentroHemoterapia {

    private Semaphore semRecepcionista = new Semaphore(0, true);
    private Semaphore semAdmision = new Semaphore(1, true);
    private Semaphore semEntrevista = new Semaphore(1, true);
    private Semaphore semExtraccion = new Semaphore(1, true);
    private Semaphore semDonante = new Semaphore(1, true);
    private Semaphore semCertificado = new Semaphore(1, true);
    private int minRandom = 1;
    private int maxRandom = 30;
    private int sillasAdmision = 10;

    // metodo ejecutado por el recepcionista mientras no atienede el telefono
    public void procesarAlmacenar() {

        try {
            semRecepcionista.acquire();
            System.out.println("Recepcionista --- ya terminé de atender los llamados. Estoy procesando y almacenando en las heladeras");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // metodo para reflejar interaccion donante -- recepcionista
    public void pedirTurno(String donante) {               

        try {
            semDonante.acquire();

            System.out.println(donante + " llama para pedir turno");

            System.out.println("Recepcionista --- Atiende a " + donante);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // metodo para entregar turno

    public void entregarTurno() {        

        semRecepcionista.release();        

        int valorEsperaTurno = (int) Math.floor(Math.random() * (this.maxRandom - this.minRandom) + this.minRandom);

        System.out.println("Recepcionista --- Sr.  tiene turno para dentro de " + valorEsperaTurno + " dias");       

        semDonante.release();        
        try {            
            semAdmision.acquire();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }

    }

    public boolean admisionDonante(String nombre) {

        semAdmision.release();

        System.out.println("El donante " + nombre + " se dirige a la admision");

        if (sillasAdmision > 0) {
            
            sillasAdmision--;
            
            System.out.println(nombre + " aguarde y sera atendido");
            
            try {
                semEntrevista.acquire();
                return true;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            
        } else {
            System.out.println(nombre + " no hay más lugar en la sala de espera. Vuelva mas tarde");

            return false;
        }

    }

    public void entrevistaDonante(String nombre) {

        System.out.println("El donante " + nombre + " contesta la pregunta y le realizan examenes clinicos");

        semEntrevista.release();

        sillasAdmision++;
            
        try {
            System.out.println("El donante " + nombre + " pasa a la extracción de sangre");
            semExtraccion.acquire();
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
            
    } 

    public void extraccionDonante(String nombre) {

        System.out.println("Al donante " + nombre + " le realizan la extraccion");

        semExtraccion.release();
            
        try {
            System.out.println("El donante " + nombre + " espera por el certificado de donacion");
            semCertificado.acquire();
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
    } 

    public void entregaCertificado(String nombre) {

        System.out.println("Al donante " + nombre + " le entregan certificado de donacion");

        semCertificado.release();
            
        System.out.println("El donante " + nombre + " desayuna y se retira del centro de donacion");
        
    }

}

