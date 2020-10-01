package TP3.EJ2;

public class JugadorRol {

    private int puntosVida = 10; 

    public JugadorRol() {

    }

    public void recibirGolpe(int valorGolpe) {
        puntosVida -= valorGolpe;
    }
    
    public void recibirCura(int valorCura) {
        puntosVida += valorCura;
    }

    public int getPuntosVida() {
        return puntosVida;
    }
}
