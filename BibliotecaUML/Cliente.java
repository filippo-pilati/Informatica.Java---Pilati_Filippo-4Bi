public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private Prestito[] prestiti;
    private int numeroPrestiti;

    public Cliente(int id, String nome, String cognome) {
        if (nome == null || nome.isBlank() || cognome == null || cognome.isBlank()) {
            throw new IllegalArgumentException("Nome e cognome non possono essere vuoti.");
        }
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.prestiti = new Prestito[4]; // Capacità iniziale
        this.numeroPrestiti = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Il nome non può essere vuoto.");
        }
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        if (cognome == null || cognome.isBlank()) {
            throw new IllegalArgumentException("Il cognome non può essere vuoto.");
        }
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getNumeroPrestiti() {
        return numeroPrestiti;
    }

    /** Restituisce una copia difensiva dell'array dei prestiti. */
    public Prestito[] getListaPrestiti() {
        Prestito[] risultato = new Prestito[numeroPrestiti];
        for (int i = 0; i < numeroPrestiti; i++) {
            risultato[i] = prestiti[i];
        }
        return risultato;
    }

    /** Metodo di supporto dell'associazione (package-private): chiamato da Prestito. */
    void aggiungiPrestito(Prestito prestito) {
        if (prestito == null || prestito.getCliente() != this) {
            throw new IllegalArgumentException("Il prestito non appartiene al cliente.");
        }
        for (int i = 0; i < numeroPrestiti; i++) {
            if (prestiti[i] == prestito) {
                return; // Evita di aggiungere due volte lo stesso oggetto
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
        return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
    }
}
