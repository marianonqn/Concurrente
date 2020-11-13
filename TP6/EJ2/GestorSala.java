package TP6.EJ2;

public class GestorSala {

    private int personasLimiteNormal;
    private int tUmbral;
    private int limitePersonasUmbralTemperatura;
    private int personasEnSala;
    private int personasMaximo;
    private int nJubiladoEsperando;

    public GestorSala(int _limitePersonas, int _umbral, int _limitePersonasEspecial) {

        this.personasLimiteNormal = _limitePersonas;
        this.tUmbral = _umbral;
        this.limitePersonasUmbralTemperatura = _limitePersonasEspecial;
        this.personasEnSala = 0;
        this.personasMaximo = this.personasLimiteNormal;
        this.nJubiladoEsperando = 0; 
    }

    // se invoca cuando una persona quiere entrar en la sala.
    public synchronized void entrarSala() throws InterruptedException {

        while(this.personasEnSala >= this.personasMaximo || this.nJubiladoEsperando > 0) {
            wait();
        } 
        this.personasEnSala ++;

    }
    
    // se invoca cuando una persona jubilada quiere entrar en la sala.
    public synchronized void entrarSalaJubilado() throws InterruptedException {

        this.nJubiladoEsperando ++;

        while(this.personasEnSala >= this.personasMaximo) {
            wait();
        }

        this.personasEnSala ++;
        this.nJubiladoEsperando --;
    }
    
    // se invoca cuando una persona, jubilada o no, quiere salir de la sala.
    public synchronized void salirSala() {
        
        this.personasEnSala--;
        notifyAll();
    }
    
    // lo invoca la hebra que mide la temperatura de la sala para indicar el último valor medido
    public synchronized void notificarTemperatura(int temperatura) {

        this.personasMaximo = (temperatura > this.tUmbral) ? this.limitePersonasUmbralTemperatura : this.personasLimiteNormal;
    }
    
    
}
