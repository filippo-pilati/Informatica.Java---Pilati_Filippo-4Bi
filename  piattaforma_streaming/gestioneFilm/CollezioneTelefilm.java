package gestioneFilm;

import java.util.Arrays;

public class CollezioneTelefilm {

    private Telefilm[] lista;

    public CollezioneTelefilm() {
        lista = new Telefilm[0];
    }

    public CollezioneTelefilm(Telefilm[] lista) {
        this.lista = lista;
    }

    public Telefilm[] getLista() { return lista; }
    public void setLista(Telefilm[] lista) { this.lista = lista; }

    @Override
    public String toString() {
        return Arrays.toString(lista);
    }

    public void aggiungiTelefilm(Telefilm t) {
        lista = Arrays.copyOf(lista, lista.length + 1);
        lista[lista.length - 1] = t;
    }

    public void ordinaPerNome() {
        Arrays.sort(lista, (a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));
    }
}


