import java.util.ArrayList;
import java.util.List;

public class CopiaLibro {
    private String barcode;
    private StatoCopia stato;
    private Libro libro;
    private List<Prestito> listaPrestiti;

    public CopiaLibro(String barcode, Libro libro, StatoCopia stato) {
        this.barcode = barcode;
        this.libro = libro;
        this.stato = stato;
        this.listaPrestiti = new ArrayList<>();
        if (libro != null) {
            libro.aggiungiCopia(this);
        }
    }

    public CopiaLibro(String barcode, Libro libro) {
        this(barcode, libro, StatoCopia.DISPONIBILE);
    }

    public String getBarcode() { return barcode; }
    public StatoCopia getStato() { return stato; }
    public Libro getLibro() { return libro; }

    public CopiaLibro getCopiaLibro() {
        return this;
    }

    public void aggiungiPrestito(Prestito p) {
        if (!listaPrestiti.contains(p)) {
            listaPrestiti.add(p);
        }
    }

    public Prestito[] getListaPrestiti() {
        return listaPrestiti.toArray(new Prestito[0]);
    }

    public Boolean prestabile() {
        return this.stato == StatoCopia.DISPONIBILE;
    }

    public void impostaNonPrestabile() {
        this.stato = StatoCopia.NON_PRESTABILE;
    }

    public void impostaSmarrita() {
        this.stato = StatoCopia.SMARRITA;
    }

    public void impostaDisponibile() {
        this.stato = StatoCopia.DISPONIBILE;
    }

    public void impostaInPrestito() {
        this.stato = StatoCopia.IN_PRESTITO;
    }

    @Override
    public String toString() {
        return "CopiaLibro [barcode=" + barcode + ", stato=" + stato + ", libro=" + (libro != null ? libro.getTitolo() : "nessuno") + "]";
    }
}
