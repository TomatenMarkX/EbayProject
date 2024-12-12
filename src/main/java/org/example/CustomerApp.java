package org.example;

public class CustomerApp {
    public static void main(String[] args) {
        CustomerDatabase customerDB = new CustomerDatabase();

        // Beispiel: Kunden hinzufügen
        customerDB.addCustomer("Max Mustermann", "max@example.com");
        customerDB.addCustomer("Anna Müller", "anna@example.com");

        // Beispiel: Kunden aktualisieren
        customerDB.updateCustomer(1, "Maximilian Mustermann", "maximilian@example.com");

        // Beispiel: Kunden löschen
        customerDB.deleteCustomer(2);

        // Beispiel: Alle Kunden anzeigen
        customerDB.listAllCustomers();
    }
}
