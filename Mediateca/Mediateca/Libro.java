public class Libro extends Materiale {
    String autore;

    public Libro(String autore, String codice, String titolo){
        super(codice, titolo);
        this.autore = autore;
        
    }

    public Libro(){

    }
}
