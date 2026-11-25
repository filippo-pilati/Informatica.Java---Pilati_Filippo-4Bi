public class Materiale extends Object{
    private  String codice;
    private  String titolo;

    public Materiale(String codice, String titolo){
        this.codice = codice;
        this.titolo = titolo;
    }

    public String descrizione(){
        return codece+" - "+titolo;
    }
}
