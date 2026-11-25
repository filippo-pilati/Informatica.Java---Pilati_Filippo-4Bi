public class Libro extends Materiale {
    String autore;

    public Libro(String autore, String codice, String titolo){
        super(codice, titolo);
        this.autore = autore;
        
    }
    @Override
    public String descrizione(){
        //return "Libro: " + titolo + " di " + autore+ " (codice: " + codice + ")";
        return super.descrizione() + " di " + autore;
    }
}
