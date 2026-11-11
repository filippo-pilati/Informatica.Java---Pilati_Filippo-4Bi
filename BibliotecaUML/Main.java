import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. Creazione di un libro e due sue copie
        Libro libro = new Libro("978-8804668237", "Il nome della rosa", "Umberto Eco", 1980);
        CopiaLibro copia1 = new CopiaLibro("BC-001", libro);
        CopiaLibro copia2 = new CopiaLibro("BC-002", libro, StatoCopia.NON_PRESTABILE);

        // 2. Creazione di un cliente
        Cliente cliente = new Cliente(1, "Mario", "Rossi");

        // 3. Creazione di un prestito valido
        LocalDate oggi = LocalDate.now();
        Prestito prestito1 = new Prestito("P-100", oggi, oggi.plusDays(30), cliente, copia1);

        System.out.println("--- STATO INIZIALE ---");
        System.out.println(prestito1);
        System.out.println("Stato copia 1: " + copia1.getStato());
        System.out.println("Prestiti attivi cliente: " + cliente.getNumeroPrestiti());

        // 4. Test eccezione: provo a prestare la copia 2 (non prestabile)
        System.out.println("\n--- TEST ECCEZIONE ---");
        try {
            new Prestito("P-101", oggi, oggi.plusDays(15), cliente, copia2);
        } catch (IllegalStateException e) {
            System.out.println("Errore intercettato correttamente: " + e.getMessage());
        }

        // 5. Restituzione del libro
        System.out.println("\n--- RESTITUZIONE ---");
        prestito1.registraRestituzione(oggi.plusDays(5));
        System.out.println("Prestito ancora attivo? " + prestito1.attivo());
        System.out.println("Nuovo stato copia 1: " + copia1.getStato());
    }
}
