package DEL_PIN.Leg_50429.Parcial2.EJ2;

public class OperadorCarro implements Runnable {

    Carro carro;
    int duracionVuelta;

    public OperadorCarro(Carro _carro) {
        this.carro = _carro;
        this.duracionVuelta = 10000;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (true && !carro.juegoCerrado()) {

            // el operador pone le carro en movimiento
            carro.moverCarro();
            // el operador aguarda la duracion de la vuelta a la MR
            try {
                Thread.sleep(duracionVuelta);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // el operador detiene el carro
            carro.detenerCarro();            
        }

    }
    
    
}