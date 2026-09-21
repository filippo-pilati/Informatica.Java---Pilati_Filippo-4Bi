package gestioneFilm;

import java.util.Scanner;

public class MainTelefilm {

    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);

        System.out.print("Nome del telefilm: ");
        String nome = tastiera.nextLine();

        System.out.print("Genere: ");
        String genere = tastiera.nextLine();

        System.out.print("Produzione in corso? (true/false): ");
        boolean inProduzione = tastiera.nextBoolean();

        System.out.print("Quante stagioni ha il telefilm? ");
        int n = tastiera.nextInt();
        tastiera.nextLine(); // pulizia buffer

        Stagione[] stagioni = new Stagione[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- STAGIONE " + (i + 1) + " ---");

            System.out.print("Numero episodi: ");
            int episodi = tastiera.nextInt();
            tastiera.nextLine();

            System.out.print("Nome sceneggiatore: ");
            String sceneggiatore = tastiera.nextLine();

            System.out.print("Trama: ");
            String trama = tastiera.nextLine();

            stagioni[i] = new Stagione(episodi, i + 1, sceneggiatore, trama);
        }

        Telefilm t = new Telefilm(nome, genere, inProduzione, stagioni);

        System.out.println("\nTELEFILM CREATO:");
        System.out.println(t);

        System.out.println("\nNumero medio di puntate: " + t.numeroMedioPuntate());

        System.out.print("\nInserisci uno sceneggiatore da cercare: ");
        String cerca = tastiera.nextLine();

        if (t.sceneggiatorePresente(cerca))
            System.out.println("Lo sceneggiatore ha lavorato nel telefilm.");
        else
            System.out.println("Lo sceneggiatore NON ha lavorato nel telefilm.");

        t.ordinaStagioni();
        System.out.println("\nStagioni ordinate:");
        System.out.println(t);

        tastiera.close();
    }
}
