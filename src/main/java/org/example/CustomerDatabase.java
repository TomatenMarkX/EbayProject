package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDatabase {
    private final DatabaseConnection dbConnection;

    public CustomerDatabase() {
        this.dbConnection = new DatabaseConnection();
    }

    // Kunde hinzufügen
    public void addCustomer(String name, String email) {
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        try (Connection connection = dbConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
            System.out.println("Kunde erfolgreich hinzugefügt: " + name);

        } catch (SQLException e) {
            System.out.println("Fehler beim Hinzufügen des Kunden: " + e.getMessage());
        }
    }

    // Kunde aktualisieren
    public void updateCustomer(int id, String name, String email) {
        String sql = "UPDATE customers SET name = ?, email = ? WHERE id = ?";
        try (Connection connection = dbConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Kunde erfolgreich aktualisiert: ID " + id);
            } else {
                System.out.println("Kein Kunde mit der ID gefunden: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Fehler beim Aktualisieren des Kunden: " + e.getMessage());
        }
    }

    // Kunde löschen
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection connection = dbConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Kunde erfolgreich gelöscht: ID " + id);
            } else {
                System.out.println("Kein Kunde mit der ID gefunden: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen des Kunden: " + e.getMessage());
        }
    }

    // Alle Kunden anzeigen
    public void listAllCustomers() {
        String sql = "SELECT * FROM customers";
        try (Connection connection = dbConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Alle Kunden:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Kundenliste: " + e.getMessage());
        }
    }
}
