package org.example;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:C:/datenbanken/kunden.db"; // SQLite-Datenbankpfad
    // Bei MySQL z.B.: jdbc:mysql://localhost:3306/shop

    public Connection connect() {
        Connection connection = null;
        try {
            File fileDirectory = new File("C:/datenbanken");
            if(!fileDirectory.exists()) {
                System.out.println("Verzeichnis nicht vorhanden");
                fileDirectory.mkdirs();
                System.out.println("Verzeichnis wurde erstellt");
            }
            connection = DriverManager.getConnection(URL);
            System.out.println("Verbindung zur Datenbank erfolgreich!");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung: " + e.getMessage());
        }
        return connection;
    }
}