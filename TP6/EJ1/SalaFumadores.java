package TP6.EJ1;

public class SalaFumadores {

    int[] ingredientesMesa = new int[2];
    int ingredientesActuales;
    boolean fumandoAhora;

    public SalaFumadores() {
        
        for(int i = 0; i < this.ingredientesMesa.length; i++) {
            this.ingredientesMesa[i] = 0;
        }
        ingredientesActuales = 0;
        fumandoAhora = false;
    }

    public synchronized void entrafumar(int _idFumador) {

        while(this.fumandoAhora || this.ingredientesActuales < 2 || contiene(this.ingredientesMesa, _idFumador)) {
            // si alguien esta fumando o falta un ingrediente o los ingredientes no son los correctos
            try {
                System.out.println("El fumandor " + _idFumador + " debe esperar para fumar");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // vaciar mesa ----

        for(int i = 0; i < this.ingredientesMesa.length; i++) {
            this.ingredientesMesa[i] = 0;
        }        

        this.fumandoAhora = true;
        this.ingredientesActuales = 0;
        //System.out.println("El fumandor " + Thread.currentThread().getName() + " está fumando");
        notifyAll();
    }

    public synchronized void terminafumar() {

        this.fumandoAhora = false;
        System.out.println("El fumandor deja de fumar ----------------");
        notifyAll();
    }

    private static boolean contiene(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }

    public synchronized void colocar(int _idIngrediente) {

        while (this.ingredientesActuales >= 2 || this.fumandoAhora) { 
            // si tengo dos ingredientes ya en la mesa o hay un fumador fumando
            try {
                System.out.println("El agente no puede poner ingredientes ahora");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(!contiene(this.ingredientesMesa, _idIngrediente)) {
            // por si el agente quiere poner un ingrediente que ya esta en la mesa

            ingredientesMesa[this.ingredientesActuales] = _idIngrediente;
            this.ingredientesActuales ++;
            System.out.println("Ingrediente " + _idIngrediente + " colocado en la mesa ----------------------->");

        }
        
        notifyAll();
    }
    
}
