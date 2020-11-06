package DEL_PIN.Leg_50429;

import DEL_PIN.Leg_50429.Pruebas.Productor_Consumidor.Consumidor;
import DEL_PIN.Leg_50429.Pruebas.Productor_Consumidor.Productor;
import DEL_PIN.Leg_50429.Pruebas.Productor_Consumidor.Recipiente;

public class Main {

    public static void main(String[] args) {
        Recipiente recipienteNumeros = new Recipiente();
        Thread productor = new Thread(new Productor(recipienteNumeros));
        Thread consumidor = new Thread(new Consumidor(recipienteNumeros));

        productor.start();
        consumidor.start();       
        
    }   
}
