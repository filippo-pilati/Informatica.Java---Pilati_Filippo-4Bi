import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private List<Prestito> listaPrestiti;

    public Cliente(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.listaPrestiti = new ArrayList<>();
    }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }

    public void aggiungiPrestito(Prestito p) {
        if (!listaPrestiti.contains(p)) {
            listaPrestiti.add(p);
        }
    }

    public List<Prestito> getListaPrestiti() {
        return listaPrestiti;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
    }
}
