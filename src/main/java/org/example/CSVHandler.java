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
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(";"); // CSV sollte mit Kommas getrennt sein
                if (values.length >= 28) {
                    Product product = new Product();

                    if(!values[0].trim().replace("\"", "").isEmpty()) {
                        product.setItemNumber(Long.parseLong(values[0].trim().replace("\"", "")));
                        System.out.println("0");
                    }
                    if (!values[1].trim().isEmpty()) {
                        product.setTitle(String.valueOf(values[1].trim()));
                        System.out.println("1");
                    }
                    if (!values[3].isEmpty()) {
                        product.setCustomLabel(Long.parseLong(values[3].trim()));
                        System.out.println("3");
                    }
                    product.setAvailableQuantity(Integer.parseInt(values[4].trim().replace("\"", "")));
                    System.out.println("4");
                    product.setCurrency(String.valueOf(values[6].trim()));
                    System.out.println("6");
                    product.setStartPrice(Double.parseDouble(values[7].trim()));
                    System.out.println("7");
                    product.setCurrentPrice(Double.parseDouble(values[10].trim()));
                    System.out.println("10");
                    product.setSoldQuantity(Integer.parseInt(values[11].trim().replace("\"", "")));
                    System.out.println("11");
                    product.setWatchers(Integer.parseInt(values[12].trim().replace("\"", "")));
                    System.out.println("12");
                    product.setStartDate(String.valueOf(values[14].trim()));
                    System.out.println("14");
                    product.setEndDate(String.valueOf(values[15].trim()));
                    System.out.println("15");
                    product.setEbayCategory1Name(String.valueOf(values[16].trim()));
                    System.out.println("16");
                    product.setEbayCategory1Number(Integer.parseInt(values[17].trim().replace("\"", "")));
                    System.out.println("17");
                    product.setCondition(String.valueOf(values[20].trim()));
                    System.out.println("20");
                    product.setListingSite(String.valueOf(values[26].trim()));
                    System.out.println("26");
                    if (!values[28].trim().replace("\"", "").isEmpty()) {
                        product.setP_EAN(Long.parseLong(values[28].trim()));
                        System.out.println("28");
                    }

                    System.out.println(product.toString());
                    products.add(product);
                }
            }
            System.out.println("Alle Produkte ausgelesen, Anzahl der Produkte: " + products.size());
            // Produkte in die Datenbank einfügen
            productDatabase.insertProducts(products);

            System.out.println("CSV-Datei verarbeitet und Datenbank aktualisiert.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Fehler beim Verarbeiten der CSV-Datei: " + e.getMessage());
        }
    }
}
