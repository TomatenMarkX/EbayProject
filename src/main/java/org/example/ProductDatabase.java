package org.example;

import java.sql.*;
import java.util.List;

public class ProductDatabase {
    private final InMemoryDatabaseConnection dbConnection;

    public ProductDatabase() {
        this.dbConnection = new InMemoryDatabaseConnection();
    }

    public void initializeProductTable() {
        String createTableQuery =
            """
            CREATE TABLE IF NOT EXISTS products (
                item_number BIGINT,
                title VARCHAR,
                custom_label BIGINT,
                available_quantity INTEGER,
                currency VARCHAR,
                start_price DOUBLE,
                current_price DOUBLE,
                sold_quantity INTEGER,
                watchers INTEGER,
                start_date VARCHAR,
                end_date VARCHAR,
                ebay_category1_name VARCHAR,
                ebay_category1_number INTEGER,
                condition VARCHAR,
                listing_site VARCHAR,
                p_ean BIGINT,
            )
        """;

        try(Statement statement = dbConnection.connect().createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println("Neue Tabelle für Produkte erstellt");
        }
        catch (SQLException exception) {
            System.out.println("Fehler beim Erstellen der Produktabelle");
        }
    }

    public void insertProducts(List<Product> products) {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

        try (Connection connection = dbConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (Product product : products) {
                statement.setLong(1, product.getItemNumber());
                statement.setString(2, product.getTitle());
                statement.setLong(3, product.getCustomLabel());
                statement.setInt(4, product.getAvailableQuantity());
                statement.setString(5, product.getCurrency());
                statement.setDouble(6, product.getStartPrice());
                statement.setDouble(7, product.getCurrentPrice());
                statement.setInt(8, product.getSoldQuantity());
                statement.setInt(9, product.getWatchers());
                statement.setString(10, product.getStartDate());
                statement.setString(11, product.getEndDate());
                statement.setString(12, product.getEbayCategory1Name());
                statement.setInt(13, product.getEbayCategory1Number());
                statement.setString(14, product.getCondition());
                statement.setString(15, product.getListingSite());
                statement.setLong(16, product.getP_EAN());
                statement.addBatch(); // Für Batch-Inserts
            }
            statement.executeBatch();

            System.out.println("Produkte erfolgreich eingefügt!");

        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen von Produkten: " + e.getMessage());
        }
    }

    public void deleteProductTable () {
        String sql = "DROP TABLE IF EXISTS products";

        try (Statement statement = dbConnection.connect().createStatement()) {
            statement.execute(sql);
            System.out.println("Tabelle gelöscht");
        }
        catch(SQLException exception) {

        }
    }
}
