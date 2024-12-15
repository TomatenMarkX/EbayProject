package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InMemoryDatabaseConnection {
    private static final String URL;
    private static Connection connection;


    static {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            URL = "jdbc:sqlite:file:shared_memory?mode=memory&cache=shared";
        } else {
            URL = "jdbc:sqlite::memory:?cache=shared";
        }
    }

    public Connection connect() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL);
                System.out.println("Verbindung zur In-Memory-Datenbank erfolgreich!");
            } catch (SQLException e) {
                System.out.println("Fehler bei der Verbindung: " + e.getMessage());
            }
        }
        return connection;
    }
}

