package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.util.List;

public class Gui extends Application {
    ProductDatabase productDB = new ProductDatabase();

    public static void main(String[] args) {
        launch(args);
        CustomerDatabase customerDB = new CustomerDatabase();
        // Beispiel: Alle Kunden anzeigen
        customerDB.listAllCustomers();
    }

    @Override
    public void start(Stage primaryStage) {
        List<Product> products = productDB.getAllProducts();

        TableView<Product> tableView = new TableView<>();

        TableColumn<Product, Long> itemNumberColumn = new TableColumn<>("Item Number");
        itemNumberColumn.setCellValueFactory(new PropertyValueFactory<>("itemNumber"));

        TableColumn<Product, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Product, Long> customLabelColumn = new TableColumn<>("CustomLabel");
        customLabelColumn.setCellValueFactory(new PropertyValueFactory<>("customLabel"));

        TableColumn<Product, Integer> availableQuantityColumn = new TableColumn<>("Available Quantity");
        availableQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("availableQuantity"));

        TableColumn<Product, String> currencyColumn = new TableColumn<>("Currency");
        currencyColumn.setCellValueFactory(new PropertyValueFactory<>("currency"));

        TableColumn<Product, Double> startPriceColumn = new TableColumn<>("Start Price");
        startPriceColumn.setCellValueFactory(new PropertyValueFactory<>("startPrice"));

        TableColumn<Product, Double> currentPriceColumn = new TableColumn<>("Current Price");
        currentPriceColumn.setCellValueFactory(new PropertyValueFactory<>("currentPrice"));

        TableColumn<Product, Integer> soldQuantityColumn = new TableColumn<>("Sold Quantity");
        soldQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("soldQuantity"));

        TableColumn<Product, Integer> watchersColumn = new TableColumn<>("Watchers");
        watchersColumn.setCellValueFactory(new PropertyValueFactory<>("watchers"));

        TableColumn<Product, String> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<Product, String> endDateColumn = new TableColumn<>("End Date");
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        TableColumn<Product, String> ebayCategoryNameColumn = new TableColumn<>("Ebay Category Name");
        ebayCategoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("ebayCategoryName"));

        TableColumn<Product, Integer> ebayCategoryNumberColumn = new TableColumn<>("Ebay Category Number");
        ebayCategoryNumberColumn.setCellValueFactory(new PropertyValueFactory<>("ebayCategoryNumber"));

        TableColumn<Product, String> conditionColumn = new TableColumn<>("Condition");
        conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));

        TableColumn<Product, String> listingSiteColumn = new TableColumn<>("ListingSite");
        listingSiteColumn.setCellValueFactory(new PropertyValueFactory<>("listingSite"));

        TableColumn<Product, String> p_eanColumn = new TableColumn<>("P_ean");
        p_eanColumn.setCellValueFactory(new PropertyValueFactory<>("P_ean"));

        tableView.getColumns().addAll(itemNumberColumn, titleColumn, customLabelColumn, availableQuantityColumn, currencyColumn, startPriceColumn, currentPriceColumn, soldQuantityColumn, watchersColumn, startDateColumn, endDateColumn, ebayCategoryNameColumn, ebayCategoryNumberColumn, conditionColumn, listingSiteColumn, p_eanColumn);

        tableView.getItems().setAll(products);

        StackPane root = new StackPane();
        root.getChildren().add(tableView);
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Produktübersicht");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

