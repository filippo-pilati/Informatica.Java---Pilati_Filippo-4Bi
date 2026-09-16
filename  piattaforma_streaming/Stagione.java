package piattaforma_streaming;

public class Stagione{

    private int numeroEpisodi;
    private String nomeSceneggiatore;
    private String trama;
    private int numeroStagione;

    // Costruttore di Default
    public Stagione() {
        numeroEpisodi = 0;
        nomeSceneggiatore = "";
        trama = "";
        numeroStagione = 0;
  
    }

    //Costruttore Parametrizzato
    public Stagione(int numeroEpisodi,int numeroStagione,String nomeSceneggiatore, String trama){
        this.nomeSceneggiatore = nomeSceneggiatore;
        this.trama=trama;
        this.numeroEpisodi=numeroEpisodi;
        this.numeroStagione=numeroStagione;
    }

    public int getNumeroEpisodi() {
        return numeroEpisodi;
    }

    public void setNumeroEpisodi(int numeroEpisodi) {
        this.numeroEpisodi = numeroEpisodi;
    }

    public String getNomeSceneggiatore() {
        return nomeSceneggiatore;
    }

    public void setNomeSceneggiatore(String nomeSceneggiatore) {
        this.nomeSceneggiatore = nomeSceneggiatore;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public int getNumeroStagione() {
        return numeroStagione;
    }

    public void setNumeroStagione(int numeroStagione) {
        this.numeroStagione = numeroStagione;
    }

    @Override 
    public String toString(){
        return "STAGIONE: "+numeroStagione+"EPISODIO: "+numeroEpisodi+"TRAMA: "+trama+"AUTORE: "+ nomeSceneggiatore;
    }



    
}