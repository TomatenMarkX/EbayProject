package org.example;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        CSVHandler csvHandler = new CSVHandler();
        //TODO
        Path path = Paths.get("C:/Users/mplat/Documents/EbayCSV/DennisEbay.csv");
        csvHandler.processCSV(path.toString());

        Gui gui = new Gui();
        gui.main(args);
        }
    }
