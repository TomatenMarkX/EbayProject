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
        List<String> errors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(";"); //Zeichen durch was CSV getrennt ist
                if (values.length >= 28) {
                    Product product = new Product();

                    if (!values[0].trim().replace("\"", "").isEmpty()) {
                        product.setItemNumber(Long.parseLong(values[0].trim().replace("\"", "")));
                        System.out.println("0");
                    }
                    if (!values[1].trim().isEmpty()) {
                        product.setTitle(String.valueOf(values[1].trim()));
                        System.out.println("1");
                    }
                    if (!values[3].isEmpty()) {
                        try {
                            product.setCustomLabel(Long.parseLong(values[3].trim()));
                            System.out.println("3");
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Fehler beim Verarbeiten des CustomLabels: " + e.getMessage());
                            errors.add("Bei ItemNumber: " + values[0].trim().replace("\"", "") + " gab es einen Fehler beim Verarbeiten des CustomLabels: " + e.getMessage());
                        }
                    }
                    if (!values[4].trim().replace("\"", "").isEmpty()) {
                        product.setAvailableQuantity(Integer.parseInt(values[4].trim().replace("\"", "")));
                        System.out.println("4");
                    }
                    if (!values[6].trim().replace("\"", "").isEmpty()) {
                        product.setCurrency(String.valueOf(values[6].trim()));
                        System.out.println("6");
                    }
                    if (!values[7].trim().isEmpty()) {
                        product.setStartPrice(Double.parseDouble(values[7].trim()));
                        System.out.println("7");
                    }
                    if (!values[8].trim().isEmpty()) {
                        product.setCurrentPrice(Double.parseDouble(values[10].trim()));
                        System.out.println("10");
                    }
                    if (!values[11].trim().replace("\"", "").isEmpty()) {
                        product.setSoldQuantity(Integer.parseInt(values[11].trim().replace("\"", "")));
                        System.out.println("11");
                    }
                    if (!values[12].trim().replace("\"", "").isEmpty()) {
                        product.setWatchers(Integer.parseInt(values[12].trim().replace("\"", "")));
                        System.out.println("12");
                    }
                    if (!values[14].trim().replace("\"", "").isEmpty()) {
                        product.setStartDate(String.valueOf(values[14].trim()));
                        System.out.println("14");
                    }
                    if (!values[15].trim().replace("\"", "").isEmpty()) {
                        product.setEndDate(String.valueOf(values[15].trim()));
                        System.out.println("15");
                    }
                    if (!values[16].trim().replace("\"", "").isEmpty()) {
                        product.setEbayCategory1Name(String.valueOf(values[16].trim()));
                        System.out.println("16");
                    }
                    if (!values[17].trim().replace("\"", "").isEmpty()) {
                        product.setEbayCategory1Number(Integer.parseInt(values[17].trim().replace("\"", "")));
                        System.out.println("17");
                    }
                    if (!values[20].trim().replace("\"", "").isEmpty()) {
                        product.setCondition(String.valueOf(values[20].trim()));
                        System.out.println("20");
                    }
                    if (!values[26].trim().replace("\"", "").isEmpty()) {
                        product.setListingSite(String.valueOf(values[26].trim()));
                        System.out.println("26");
                    }
                    if (!values[28].trim().replace("\"", "").isEmpty()) {
                        try {
                            product.setP_EAN(Long.parseLong(values[28].trim().replace("\"", "")));
                            System.out.println("28");
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Fehler beim Verarbeiten der P_EAN: " + e.getMessage());
                            errors.add("Bei ItemNumber: " + values[0].trim().replace("\"", "") + " gab es einen Fehler beim Verarbeiten der P_EAN: " + e.getMessage());
                        }
                    }

                    System.out.println(product.toString());
                    products.add(product);
                }
            }
            System.out.println("Alle Produkte ausgelesen, Anzahl der Produkte: " + products.size());
            System.out.println(errors.toString());
            // Produkte in die Datenbank einfügen
            productDatabase.insertProducts(products);

            System.out.println("CSV-Datei verarbeitet und Datenbank aktualisiert.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Fehler beim Verarbeiten der CSV-Datei: " + e.getMessage());
        }
    }
}
