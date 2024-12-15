package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import javax.naming.Context;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.List;

public class Gui extends Application {
    Connection connection;

    public void main(String[] args, Connection connection) {
        if(connection != null) {
            System.out.println("Connection is null");
            this.connection = connection;
            launch(args);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab produktTab = new Tab("Produkte");
        produktTab.setClosable(false);
        produktTab.setContent(createProductView());

        Tab kundenTab = new Tab("Kunden");
        kundenTab.setClosable(false);
        kundenTab.setContent(createKundenView());

        Tab bestellungenTab = new Tab("Bestellungen");
        bestellungenTab.setClosable(false);
        bestellungenTab.setContent(createBestellungenView());

        tabPane.getTabs().addAll(produktTab, kundenTab, bestellungenTab);

        BorderPane root = new BorderPane();
        root.setCenter(tabPane);

        // Scene und Stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Produkt- und Kundenverwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public BorderPane createProductView() {
        Connection connection = new InMemoryDatabaseConnection().connect();
        ProductDatabase productDB = new ProductDatabase(connection);

        List<Product> products = productDB.getAllProducts();

        TableView<Product> productTableView = new TableView<>();

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
        ebayCategoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("ebayCategory1Name"));

        TableColumn<Product, Integer> ebayCategoryNumberColumn = new TableColumn<>("Ebay Category Number");
        ebayCategoryNumberColumn.setCellValueFactory(new PropertyValueFactory<>("ebayCategory1Number"));

        TableColumn<Product, String> conditionColumn = new TableColumn<>("Condition");
        conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));

        TableColumn<Product, String> listingSiteColumn = new TableColumn<>("ListingSite");
        listingSiteColumn.setCellValueFactory(new PropertyValueFactory<>("listingSite"));

        TableColumn<Product, String> p_eanColumn = new TableColumn<>("P_ean");
        p_eanColumn.setCellValueFactory(new PropertyValueFactory<>("P_EAN"));

        productTableView.getColumns().addAll(itemNumberColumn, titleColumn, customLabelColumn, availableQuantityColumn, currencyColumn, startPriceColumn, currentPriceColumn, soldQuantityColumn, watchersColumn, startDateColumn, endDateColumn, ebayCategoryNameColumn, ebayCategoryNumberColumn, conditionColumn, listingSiteColumn, p_eanColumn);

        productTableView.getItems().setAll(products);

        BorderPane productLayout = new BorderPane();
        productLayout.setCenter(productTableView);
        return productLayout;
    }

    public BorderPane createKundenView() {
        BorderPane kundenLayout = new BorderPane();
        return kundenLayout;
    }

    public BorderPane createBestellungenView() {
        Button addBestellungButton = new Button("Neue Bestellung hinzufügen");
        addBestellungButton.setOnAction(e -> addBestellung());
        BorderPane bestellungenLayout = new BorderPane();
        bestellungenLayout.setBottom(addBestellungButton);

        return bestellungenLayout;
    }

    public void addBestellung() {
        TextInputDialog vornameDialog = new TextInputDialog();
        vornameDialog.setTitle("Neue Bestellung");
        vornameDialog.setHeaderText("Geben Sie den Vorname des Kunden ein");
        vornameDialog.showAndWait().ifPresent(vorname -> {
            TextInputDialog nameDialog = new TextInputDialog();
            nameDialog.setTitle("Neue Bestellung");
            nameDialog.setHeaderText("Geben sie den Nachnamen des Kunden ein");
            nameDialog.showAndWait().ifPresent(nachName -> {
                TextInputDialog artikelDialog = new TextInputDialog();
                artikelDialog.setTitle("Neue Bestellung");
                artikelDialog.setHeaderText("Geben sie den Namen des Artikels ein");
                artikelDialog.showAndWait().ifPresent(artikel -> {
                    Bestellung bestellung = new Bestellung(vorname, nachName, Bestellung.Status.IN_BEARBEITUNG);
                });
        });});

    }
}

