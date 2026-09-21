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


}

