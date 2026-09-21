package gestioneFilm;

public class Stagione {

    private int numeroEpisodi;
    private String nomeSceneggiatore;
    private String trama;
    private int numeroStagione;

    public Stagione() {
        numeroEpisodi = 0;
        nomeSceneggiatore = "";
        trama = "";
        numeroStagione = 0;
    }

    public Stagione(int numeroEpisodi, int numeroStagione, String nomeSceneggiatore, String trama) {
        this.numeroEpisodi = numeroEpisodi;
        this.numeroStagione = numeroStagione;
        this.nomeSceneggiatore = nomeSceneggiatore;
        this.trama = trama;
    }

    public int getNumeroEpisodi() { return numeroEpisodi; }
    public void setNumeroEpisodi(int numeroEpisodi) { this.numeroEpisodi = numeroEpisodi; }

    public String getNomeSceneggiatore() { return nomeSceneggiatore; }
    public void setNomeSceneggiatore(String nomeSceneggiatore) { this.nomeSceneggiatore = nomeSceneggiatore; }

    public String getTrama() { return trama; }
    public void setTrama(String trama) { this.trama = trama; }

    public int getNumeroStagione() { return numeroStagione; }
    public void setNumeroStagione(int numeroStagione) { this.numeroStagione = numeroStagione; }

    @Override
    public String toString() {
        return "\nSTAGIONE " + numeroStagione +
               "\n Episodi: " + numeroEpisodi +
               "\n Sceneggiatore: " + nomeSceneggiatore +
               "\n Trama: " + trama + "\n";
    }
}
