package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:shop.db"; // SQLite-Datenbankpfad
    // Bei MySQL z.B.: jdbc:mysql://localhost:3306/shop

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Verbindung zur Datenbank erfolgreich!");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung: " + e.getMessage());
        }
        return connection;
    }
}