import java.time.LocalDate;

public class Prestito {
    private String id;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private LocalDate dataScadenza;
    private Cliente cliente;
    private CopiaLibro copiaLibro;

    public Prestito(String id, LocalDate dataInizio, LocalDate dataScadenza, Cliente cliente, CopiaLibro copiaLibro) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataScadenza = dataScadenza;
        this.dataFine = null;
        this.cliente = cliente;
        this.copiaLibro = copiaLibro;

        if (cliente != null) {
            cliente.aggiungiPrestito(this);
        }
        if (copiaLibro != null) {
            copiaLibro.aggiungiPrestito(this);
            copiaLibro.impostaInPrestito();
        }
    }

    public String getId() { return id; }
    public LocalDate getDataInizio() { return dataInizio; }
    public LocalDate getDataScadenza() { return dataScadenza; }
    public LocalDate getDataRestituzione() { return dataFine; }
    public Cliente getCliente() { return cliente; }
    public CopiaLibro getCopiaLibro() { return copiaLibro; }

    public void registraRestituzione(LocalDate data) {
        this.dataFine = data;
        if (this.copiaLibro != null) {
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
