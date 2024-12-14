package org.example;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        CSVHandler csvHandler = new CSVHandler();
        //TODO
        String userHome = System.getProperty("user.home");
        Path path = Paths.get(userHome, "Documents", "EbayCSV", "DennisEbay.csv");
        //Path path = Paths.get("C:/Users/mplat/Documents/EbayCSV/DennisEbay.csv");
        csvHandler.processCSV(path.toString());

        Gui gui = new Gui();
        gui.main(args);
        }
    }
