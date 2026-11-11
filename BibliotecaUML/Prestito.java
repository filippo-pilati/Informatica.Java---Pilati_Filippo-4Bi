import java.time.LocalDate;

public class Prestito {
    private String id;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private LocalDate dataScadenza;
    private Cliente cliente;
    private CopiaLibro copiaLibro;

    public Prestito(String id, LocalDate dataInizio, LocalDate dataScadenza, Cliente cliente, CopiaLibro copiaLibro) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("L'ID del prestito non può essere vuoto.");
        }
        if (dataInizio == null || dataScadenza == null) {
            throw new IllegalArgumentException("Le date di inizio e scadenza sono obbligatorie.");
        }
        if (dataScadenza.isBefore(dataInizio)) {
            throw new IllegalArgumentException("La data di scadenza non può precedere la data di inizio.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Il cliente non può essere null.");
        }
        if (copiaLibro == null) {
            throw new IllegalArgumentException("La copia del libro non può essere null.");
        }
        if (!copiaLibro.prestabile()) {
            throw new IllegalStateException("La copia selezionata non è prestabile.");
        }

        this.id = id;
        this.dataInizio = dataInizio;
        this.dataScadenza = dataScadenza;
        this.dataFine = null;
        this.cliente = cliente;
        this.copiaLibro = copiaLibro;

        // Aggiorna lo stato e le associazioni bidirezionali
        copiaLibro.impostaInPrestito();
        cliente.aggiungiPrestito(this);
        copiaLibro.aggiungiPrestito(this);
    }

    public String getId() {
        return id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public LocalDate getDataRestituzione() {
        return dataFine;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public CopiaLibro getCopiaLibro() {
        return copiaLibro;
    }

    public void registraRestituzione(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("La data di restituzione non può essere null.");
        }
        if (!attivo()) {
            throw new IllegalStateException("Il prestito risulta già chiuso.");
        }
        if (data.isBefore(dataInizio)) {
            throw new IllegalArgumentException("La data di restituzione non può precedere la data di inizio.");
        }
        this.dataFine = data;
        if (this.copiaLibro.getStato() == StatoCopia.IN_PRESTITO) {
            this.copiaLibro.impostaDisponibile();
        }
    }

    public Boolean attivo() {
        return this.dataFine == null;
    }

    @Override
    public String toString() {
        return "Prestito [id=" + id + ", inizio=" + dataInizio + ", scadenza=" + dataScadenza +
               ", restituzione=" + dataFine + ", cliente=" + cliente.getCognome() +
               ", copia=" + copiaLibro.getBarcode() + "]";
    }
}
