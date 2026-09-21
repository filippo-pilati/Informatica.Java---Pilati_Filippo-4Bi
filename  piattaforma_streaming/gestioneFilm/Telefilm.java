package gestioneFilm;

import java.util.Arrays;

public class Telefilm {

    private String nome;
    private String genere;
    private boolean inProduzione;   // richiesto dal testo
    private Stagione[] stagioni;

    public Telefilm() {
        nome = "";
        genere = "";
        inProduzione = false;
        stagioni = new Stagione[0];
    }

    public Telefilm(String nome, String genere, boolean inProduzione, Stagione[] stagioni) {
        this.nome = nome;
        this.genere = genere;
        this.inProduzione = inProduzione;
        this.stagioni = stagioni;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getGenere() { return genere; }
    public void setGenere(String genere) { this.genere = genere; }

    public boolean isInProduzione() { return inProduzione; }
    public void setInProduzione(boolean inProduzione) { this.inProduzione = inProduzione; }

    public Stagione[] getStagioni() { return stagioni; }
    public void setStagioni(Stagione[] stagioni) { this.stagioni = stagioni; }

    @Override
    public String toString() {
        return "\nTELEFILM: " + nome +
               "\n Genere: " + genere +
               "\n In produzione: " + (inProduzione ? "Sì" : "No") +
               "\n Numero stagioni: " + stagioni.length +
               "\n" + Arrays.toString(stagioni);
    }

    // 
    // METODO: numero medio episodi
    // 
    public double numeroMedioPuntate() {
        if (stagioni.length == 0) return 0;

        int somma = 0;
        for (Stagione s : stagioni)
            somma += s.getNumeroEpisodi();

        return (double) somma / stagioni.length;
    }

    // 
    // METODO: verifica sceneggiatore presente
    // 
    public boolean sceneggiatorePresente(String nomeSceneggiatore) {
        for (Stagione s : stagioni)
            if (s.getNomeSceneggiatore().equalsIgnoreCase(nomeSceneggiatore))
                return true;
        return false;
    }

    // 
    // METODO: ordina stagioni per numero
    // 
    public void ordinaStagioni() {
        Arrays.sort(stagioni, (a, b) -> a.getNumeroStagione() - b.getNumeroStagione());
    }
}


