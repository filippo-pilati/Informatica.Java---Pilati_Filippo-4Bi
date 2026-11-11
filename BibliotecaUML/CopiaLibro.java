public class CopiaLibro {
    private String barcode;
    private StatoCopia stato;
    private Libro libro;
    private Prestito[] prestiti;
    private int numeroPrestiti;

    public CopiaLibro(String barcode, Libro libro, StatoCopia stato) {
        if (barcode == null || barcode.isBlank()) {
            throw new IllegalArgumentException("Il barcode non può essere vuoto.");
        }
        if (libro == null) {
            throw new IllegalArgumentException("La copia deve essere associata a un libro.");
        }
        if (stato == null) {
            throw new IllegalArgumentException("Lo stato non può essere null.");
        }
        this.barcode = barcode;
        this.libro = libro;
        this.stato = stato;
        this.prestiti = new Prestito[4];
        this.numeroPrestiti = 0;

        libro.aggiungiCopia(this);
    }

    public CopiaLibro(String barcode, Libro libro) {
        this(barcode, libro, StatoCopia.DISPONIBILE);
    }

    public String getBarcode() {
        return barcode;
    }

    public StatoCopia getStato() {
        return stato;
    }

    public Libro getLibro() {
        return libro;
    }

    public CopiaLibro getCopiaLibro() {
        return this;
    }

    public int getNumeroPrestiti() {
        return numeroPrestiti;
    }

    public Prestito[] getListaPrestiti() {
        Prestito[] risultato = new Prestito[numeroPrestiti];
        for (int i = 0; i < numeroPrestiti; i++) {
            risultato[i] = prestiti[i];
        }
        return risultato;
    }

    public Boolean prestabile() {
        return this.stato == StatoCopia.DISPONIBILE;
    }

    public void impostaNonPrestabile() {
        if (this.stato == StatoCopia.IN_PRESTITO) {
            throw new IllegalStateException("Impossibile rendere non prestabile una copia attualmente in prestito.");
        }
        this.stato = StatoCopia.NON_PRESTABILE;
    }

    public void impostaSmarrita() {
        this.stato = StatoCopia.SMARRITA;
    }

    public void impostaDisponibile() {
        this.stato = StatoCopia.DISPONIBILE;
    }

    /** Metodo di supporto (package-private): chiamato da Prestito. */
    void impostaInPrestito() {
        if (!prestabile()) {
            throw new IllegalStateException("La copia non è disponibile per il prestito.");
        }
        this.stato = StatoCopia.IN_PRESTITO;
    }

    /** Metodo di supporto dell'associazione (package-private): chiamato da Prestito. */
    void aggiungiPrestito(Prestito prestito) {
        if (prestito == null || prestito.getCopiaLibro() != this) {
            throw new IllegalArgumentException("Il prestito non appartiene a questa copia.");
        }
        for (int i = 0; i < numeroPrestiti; i++) {
            if (prestiti[i] == prestito) {
                return;
            }
        }
        if (numeroPrestiti == prestiti.length) {
            Prestito[] piuGrande = new Prestito[prestiti.length * 2];
            for (int i = 0; i < numeroPrestiti; i++) {
                piuGrande[i] = prestiti[i];
            }
            prestiti = piuGrande;
        }
        prestiti[numeroPrestiti] = prestito;
        numeroPrestiti++;
    }

    @Override
    public String toString() {
        return "CopiaLibro [barcode=" + barcode + ", stato=" + stato + ", libro=" + libro.getTitolo() + "]";
    }
}
