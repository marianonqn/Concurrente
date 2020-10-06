package TP3.EJ8;

public class Hamster implements Runnable{

    private Rueda ruedaJaula;
    private Hamaca hamacaJaula;
    private Plato platoJaula;
    private String nombreHamster;

    public Hamster(Rueda _rueda, Hamaca _hamaca, Plato _plato, String _nombre) {

        ruedaJaula = _rueda;
        hamacaJaula = _hamaca;
        platoJaula = _plato;
        nombreHamster = _nombre;
    }

    @Override
    public void run() {
        try {
            while(true) {
                platoJaula.Comer(nombreHamster);
                Thread.sleep(1000);
                
                ruedaJaula.Rodar(nombreHamster);
                Thread.sleep(1000);

                hamacaJaula.Hamacarse(nombreHamster);
                Thread.sleep(1000);
            }           
        } catch (Exception e) {
            //TODO: handle exception
        }
        

    }   
    
}
