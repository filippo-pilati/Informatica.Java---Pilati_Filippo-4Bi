import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String isbn;
    private String titolo;
    private String autore;
    private int annoPubblicazione;
    private List<CopiaLibro> copie;

    public Libro(String isbn, String titolo, String autore, int annoPubblicazione) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.copie = new ArrayList<>();
    }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitolo(String titolo) { this.titolo = titolo; }
    public void setAutore(String autore) { this.autore = autore; }
    public void setAnnoPubblicazione(int annoPubblicazione) { this.annoPubblicazione = annoPubblicazione; }

    public String getIsbn() { return isbn; }
    public String getTitolo() { return titolo; }
    public String getAutore() { return autore; }
    public int getAnnoPubblicazione() { return annoPubblicazione; }

    public void aggiungiCopia(CopiaLibro copia) {
        if (!copie.contains(copia)) {
            copie.add(copia);
        }
    }

    public List<CopiaLibro> getCopie() {
        return copie;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", titolo=" + titolo + ", autore=" + autore + ", anno=" + annoPubblicazione + "]";
    }
}
