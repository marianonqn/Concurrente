package TP4.EJ6;

class HiloEscritor extends Thread {
    String letraHilo;
    int repeticionLetra;
    EscribirSecuencia objEscribirSecuencia;

    public HiloEscritor(String cadena, int repeticionLetra, EscribirSecuencia objEscribirSecuencia) {
        this.letraHilo = cadena;
        this.repeticionLetra = repeticionLetra;
        this.objEscribirSecuencia = objEscribirSecuencia;
    }

    @Override
    public void run() {

        try {
            objEscribirSecuencia.escribirSalida(letraHilo, repeticionLetra);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    } 
}
