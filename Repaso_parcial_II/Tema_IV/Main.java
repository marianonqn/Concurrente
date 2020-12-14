package Repaso_parcial_II.Tema_IV;

public class Main {

    public static void main(String[] args) {

        int tamanioCanastoMangas = 50;
        int tamanioCanastoCuerpos = 20;
        int tamanioCajaEmbalaje = 10;

        Mesa_ensamblado mesa =  new Mesa_ensamblado(tamanioCanastoMangas, tamanioCanastoCuerpos, tamanioCajaEmbalaje);

        Thread costureraMangas = new Thread(new Costurera_mangas(mesa));
        Thread costureraCuerpos = new Thread(new Costurera_cuerpos(mesa));
        Thread costureraSweatter = new Thread(new Costurera_sweatter(mesa));

        costureraMangas.start();
        costureraCuerpos.start();
        costureraSweatter.start();      
        
    }
    
}
