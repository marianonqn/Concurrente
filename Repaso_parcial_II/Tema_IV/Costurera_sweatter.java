package Repaso_parcial_II.Tema_IV;

public class Costurera_sweatter implements Runnable {

    private Mesa_ensamblado mesa;

    public Costurera_sweatter(Mesa_ensamblado _mesa) {
        this.mesa = _mesa;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (true) {

            this.mesa.crearSweatter();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.mesa.embalarCajaSweatter();

        }
        
    }

    
    
}