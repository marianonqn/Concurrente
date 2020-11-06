package DEL_PIN.Leg_50429.Pruebas.Productor_Consumidor;

public class Consumidor implements Runnable{

    private Recipiente recipienteConsumidor;

    public Consumidor(Recipiente _recipiente) {
        this.recipienteConsumidor = _recipiente;
    }

    @Override
    public void run() {        
        for(int i = 0; i < 10; i++) {

            this.recipienteConsumidor.getNumeroInteraccion();

        }
        
    }
    
}
