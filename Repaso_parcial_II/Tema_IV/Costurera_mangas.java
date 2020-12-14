package Repaso_parcial_II.Tema_IV;

public class Costurera_mangas implements Runnable {

    private Mesa_ensamblado mesa;

    public Costurera_mangas(Mesa_ensamblado _mesa) {
        this.mesa = _mesa;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {

            this.mesa.crearMangas();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }      

    }

    
    
}
