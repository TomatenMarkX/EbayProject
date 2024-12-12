package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDatabase {
    private final DatabaseConnection dbConnection;

    public ProductDatabase() {
        this.dbConnection = new DatabaseConnection();
    }

    public void insertProducts(List<String[]> products) {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

        try (Connection connection = dbConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (String[] product : products) {
                statement.setString(1, product[0]); // Name
                statement.setDouble(2, Double.parseDouble(product[1])); // Preis
                statement.setInt(3, Integer.parseInt(product[2])); // Menge
                statement.addBatch(); // Für Batch-Inserts
            }
            statement.executeBatch();
            System.out.println("Produkte erfolgreich eingefügt!");

        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen von Produkten: " + e.getMessage());
        }
    }
}
