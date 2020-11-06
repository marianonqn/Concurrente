package DEL_PIN.Leg_50429.Pruebas.Productor_Consumidor;

public class Productor implements Runnable{

    private int minRandom = 1000;
    private int maxRandom = 2000;
    private Recipiente recipienteProductor;

    public Productor(Recipiente _recipiente) {
        this.recipienteProductor = _recipiente;
    }

    @Override
    public void run() {
        
        // generamos un numero random entre 1000 y 2000
        for(int i = 0; i < 10; i++) {

            int valorEntero = (int) Math.floor(Math.random() * (this.maxRandom - this.minRandom) + this.minRandom); 

            this.recipienteProductor.setNumeroInteraccion(valorEntero);

        }
       
    }
    
}