package gestioneFilm;

public class Telefilm {

    private String nome;
    private String genere;
    private String regista;
    private Stagione[] stagioni;

    public Telefilm() {
        nome = "";
        genere = "";
        regista = "";
        stagioni = new Stagione[0];
    }

    public Telefilm(String nome, String genere, String regista, Stagione[] stagioni) {
        this.nome = nome;
        this.genere = genere;
        this.regista = regista;
        this.stagioni = stagioni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public Stagione[] getStagioni() {
        return stagioni;
    }

    public void setStagioni(Stagione[] stagioni) {
        this.stagioni = stagioni;
    }

    public String toString() {
      return "TELEFILM: " + nome + " GENERE: " + genere + " REGISTA: " + regista + " STAGIONI: " + stagioni.length;
    }

       // Calcola il numero medio di episodi per stagione
    public double numeroMedioPuntate() {

        if (stagioni == null || stagioni.length == 0) {
            return 0;
        }

        int somma = 0;

        for (int i = 0; i < stagioni.length; i++) {
            somma += stagioni[i].getNumeroEpisodi();
        }

        return (double) somma / stagioni.length;
    }
}

