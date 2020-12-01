package DEL_PIN.Leg_50429.Parcial2.EJ2;

public class Carro {

    int capacidadMaximaCarro;
    int cantidadPasajerosActualCarro;
    int limiteRecorridosCarro;
    int recorridosActuales;
    boolean procesoCargaPasajeros;
    boolean carroEnMovimiento;
    boolean carroVacio;

    public Carro (int _capacidadMaximaCarro, int _limiteRecorridosCarro) {

        this.capacidadMaximaCarro = _capacidadMaximaCarro;
        this.limiteRecorridosCarro = _limiteRecorridosCarro;
        this.cantidadPasajerosActualCarro = 0;
        this.recorridosActuales = 0;
        this.carroEnMovimiento = false;
        this.carroVacio = true;
        this.procesoCargaPasajeros = true;
    }

    public synchronized void subirCarro() {

        while (this.cantidadPasajerosActualCarro >= this.capacidadMaximaCarro || this.carroEnMovimiento
                || !(this.carroVacio) || this.recorridosActuales >= this.limiteRecorridosCarro) {
            try {
                System.out.println("El pasajero " + Thread.currentThread().getName()
                        + " debe esperar para subir al carro de la MR //////////!!!!!!");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("El pasajero " + Thread.currentThread().getName() + " subió al carro de la MR ////////////////");
        this.cantidadPasajerosActualCarro++;

        if (this.cantidadPasajerosActualCarro == this.capacidadMaximaCarro) {
            this.carroVacio = false;
            this.procesoCargaPasajeros = false;
        }
            

        notifyAll();
    }

    public synchronized void bajarCarro() {

        while (this.carroEnMovimiento || (!(this.carroEnMovimiento) && this.carroVacio)) {
            try {
                System.out.println("El pasajero " + Thread.currentThread().getName() + " debe esperar a el carro realice la vuelta y se detenga para bajarse de la MR!!!!!!!!!!!");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("El pasajero " + Thread.currentThread().getName() + " bajó de la MR /*/*/*/*/*/*/*/*/*/*/");

        this.cantidadPasajerosActualCarro--;

        if (this.cantidadPasajerosActualCarro == 0)
            this.carroVacio = true;

        notifyAll();
    }

    public synchronized void moverCarro() {

        while (this.carroEnMovimiento || this.carroVacio || this.procesoCargaPasajeros) {
            
            try {
                System.out.println("El carro de la MR no puede ponerse en movimiento hasta que este lleno y detenido <------------");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("El carro de la MR se puso en movimiento ------------->");
        this.carroEnMovimiento = true;
        this.procesoCargaPasajeros = false;
        notifyAll();
    }

    public synchronized void detenerCarro() {

        System.out.println("El carro de la MR se detuvo en la salida **************");
        
        this.recorridosActuales ++;        

        if(this.recorridosActuales >= this.limiteRecorridosCarro) {
            System.out.println("El carro ya realizó todos los recorridos del día. Se cierra la MR ***************!!!");

        }
        this.carroEnMovimiento = false;
        this.procesoCargaPasajeros = true;                
        notifyAll();
    }

    public synchronized boolean juegoCerrado() {
        return this.recorridosActuales >= this.limiteRecorridosCarro;
    }
    
}
