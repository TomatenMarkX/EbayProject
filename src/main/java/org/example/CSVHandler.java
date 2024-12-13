package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
    private final ProductDatabase productDatabase = new ProductDatabase();

    public void processCSV(String csvFilePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";"); // CSV sollte mit Kommas getrennt sein
                if (values.length >= 3) {
                    Product product = new Product();

                    product.setItemNumber(Long.parseLong(values[0].trim()));
                    product.setTitle(String.valueOf(values[1].trim()));
                    product.setCustomLabel(Long.parseLong(values[3].trim()));
                    product.setAvailableQuantity(Integer.parseInt(values[4].trim()));
                    product.setCurrency(String.valueOf(values[6].trim()));
                    product.setStartPrice(Double.parseDouble(values[7].trim()));
                    product.setCurrentPrice(Double.parseDouble(values[10].trim()));
                    product.setSoldQuantity(Integer.parseInt(values[11].trim()));
                    product.setWatchers(Integer.parseInt(values[12].trim()));
                    product.setStartDate(String.valueOf(values[14].trim()));
                    product.setEndDate(String.valueOf(values[15].trim()));
                    product.setEbayCategory1Name(String.valueOf(values[16].trim()));
                    product.setEbayCategory1Number(Integer.parseInt(values[17].trim()));
                    product.setCondition(String.valueOf(values[20].trim()));
                    product.setListingSite(String.valueOf(values[26].trim()));
                    product.setP_EAN(Long.parseLong(values[28].trim()));

                    System.out.println(product.toString());
                    products.add(product);
                }
            }
            // Produkte in die Datenbank einfügen
            productDatabase.insertProducts(products);

            System.out.println("CSV-Datei verarbeitet und Datenbank aktualisiert.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Fehler beim Verarbeiten der CSV-Datei: " + e.getMessage());
        }
    }
}
