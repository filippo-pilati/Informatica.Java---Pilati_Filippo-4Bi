public class Libro extends Materiale {
    String autore;

    public Libro(String autore, String codice, String titolo){
        super(codice, titolo);
        this.autore = autore;
        
    }

    public String descrizione(){
        return "Libro: " + titolo + " di " + autore+ " (codice: " + codice + ")";
    }
}
