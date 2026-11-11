public class Libro {
    private String isbn;
    private String titolo;
    private String autore;
    private int annoPubblicazione;
    private CopiaLibro[] copie;
    private int numeroCopie;

    public Libro(String isbn, String titolo, String autore, int annoPubblicazione) {
        if (isbn == null || isbn.isBlank() || titolo == null || titolo.isBlank() || autore == null || autore.isBlank()) {
            throw new IllegalArgumentException("ISBN, titolo e autore sono obbligatori.");
        }
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.copie = new CopiaLibro[4];
        this.numeroCopie = 0;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("L'ISBN non può essere vuoto.");
        }
        this.isbn = isbn;
    }

    public void setTitolo(String titolo) {
        if (titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        if (autore == null || autore.isBlank()) {
            throw new IllegalArgumentException("L'autore non può essere vuoto.");
        }
        this.autore = autore;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroCopie() {
        return numeroCopie;
    }

    public CopiaLibro[] getCopie() {
        CopiaLibro[] risultato = new CopiaLibro[numeroCopie];
        for (int i = 0; i < numeroCopie; i++) {
            risultato[i] = copie[i];
        }
        return risultato;
    }

    /** Metodo di supporto dell'associazione (package-private): chiamato da CopiaLibro. */
    void aggiungiCopia(CopiaLibro copia) {
        if (copia == null || copia.getLibro() != this) {
            throw new IllegalArgumentException("La copia non appartiene a questo libro.");
        }
        for (int i = 0; i < numeroCopie; i++) {
            if (copie[i] == copia) {
                return;
            }
        }
        if (numeroCopie == copie.length) {
            CopiaLibro[] piuGrande = new CopiaLibro[copie.length * 2];
            for (int i = 0; i < numeroCopie; i++) {
                piuGrande[i] = copie[i];
            }
            copie = piuGrande;
        }
        copie[numeroCopie] = copia;
        numeroCopie++;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", titolo=" + titolo + ", autore=" + autore + ", annoPubblicazione=" + annoPubblicazione + "]";
    }
}
