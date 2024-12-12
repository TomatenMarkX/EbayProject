package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
    public List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<String[]>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            data = reader.readAll();
        } catch (IOException | CsvException e) {
            System.out.println("Fehler beim Lesen der CSV-Datei: " + e.getMessage());
        }
        return data;
    }
}
