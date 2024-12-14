package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    Connection dbConnection;

    public ProductDatabase() {
        this.dbConnection = new InMemoryDatabaseConnection().connect();
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
                                p_ean BIGINT
                            )
                        """;

        try (Statement statement = dbConnection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println("Neue Tabelle für Produkte erstellt");
        } catch (SQLException exception) {
            System.out.println("Fehler beim Erstellen der Produkttabelle");
        }
    }

    public void insertProducts(List<Product> products) {
        String sql = "INSERT INTO products (item_number, title, custom_label, available_quantity, currency, start_price, current_price, sold_quantity, watchers, start_date, end_date, ebay_category1_name, ebay_category1_number, condition, listing_site, p_ean) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dbConnection;
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Product product : products) {
                if (product.getItemNumber() != null) {
                    statement.setLong(1, product.getItemNumber());
                }
                if (product.getTitle() != null) {
                    statement.setString(2, product.getTitle());
                }
                if (product.getCustomLabel() != null) {
                    statement.setLong(3, product.getCustomLabel());
                }
                if (product.getAvailableQuantity() != null) {
                    statement.setInt(4, product.getAvailableQuantity());
                }
                if (product.getCurrency() != null) {
                    statement.setString(5, product.getCurrency());
                }
                if (product.getStartPrice() != null) {
                    statement.setDouble(6, product.getStartPrice());
                }
                if (product.getCurrentPrice() != null) {
                    statement.setDouble(7, product.getCurrentPrice());
                }
                if (product.getSoldQuantity() != null) {
                    statement.setInt(8, product.getSoldQuantity());
                }
                if (product.getWatchers() != null) {
                    statement.setInt(9, product.getWatchers());
                }
                if (product.getStartDate() != null) {
                    statement.setString(10, product.getStartDate());
                }
                if (product.getEndDate() != null) {
                    statement.setString(11, product.getEndDate());
                }
                if (product.getEbayCategory1Name() != null) {
                    statement.setString(12, product.getEbayCategory1Name());
                }
                if (product.getEbayCategory1Number() != null) {
                    statement.setInt(13, product.getEbayCategory1Number());
                }
                if (product.getCondition() != null) {
                    statement.setString(14, product.getCondition());
                }
                if (product.getListingSite() != null) {
                    statement.setString(15, product.getListingSite());
                }
                if (product.getP_EAN() != null) {
                    statement.setLong(16, product.getP_EAN());
                }
                statement.addBatch(); // Für Batch-Inserts
            }
            statement.executeBatch();

            System.out.println("Produkte erfolgreich eingefügt!");

        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen von Produkten: " + e.getMessage());
        }
    }

    public void deleteProductTable() {
        String sql = "DROP TABLE IF EXISTS products";

        try (Statement statement = dbConnection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabelle gelöscht");
        } catch (SQLException exception) {
            System.out.println("Fehler beim Löschen der Produkttabelle " + exception.getMessage());
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Statement statement = dbConnection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setItemNumber(resultSet.getLong("item_number"));
                product.setTitle(resultSet.getString("title"));
                product.setCustomLabel(resultSet.getLong("custom_label"));
                product.setAvailableQuantity(resultSet.getInt("available_quantity"));
                product.setCurrency(resultSet.getString("currency"));
                product.setStartPrice(resultSet.getDouble("start_price"));
                product.setCurrentPrice(resultSet.getDouble("current_price"));
                product.setSoldQuantity(resultSet.getInt("sold_quantity"));
                product.setWatchers(resultSet.getInt("watchers"));
                product.setStartDate(resultSet.getString("start_date"));
                product.setEndDate(resultSet.getString("end_date"));
                product.setEbayCategory1Name(resultSet.getString("ebay_category1_name"));
                product.setEbayCategory1Number(resultSet.getInt("ebay_category1_number"));
                product.setCondition(resultSet.getString("condition"));
                product.setListingSite(resultSet.getString("listing_site"));
                product.setP_EAN(resultSet.getLong("p_ean"));
                products.add(product);
            }
        }
        catch (SQLException exception) {
            System.out.println("Fehler beim Abrufen der Produkttabelle " + exception.getMessage());
        }
        return products;
    }
}
