package org.example;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

public class  Main {
    public static void main(String[] args) {
        InMemoryDatabaseConnection inMemoryDatabaseConnection = new InMemoryDatabaseConnection();
        Connection connection = inMemoryDatabaseConnection.connect();
        CSVHandler csvHandler = new CSVHandler(connection);
        //TODO
        String userHome = System.getProperty("user.home");
        Path path = Paths.get(userHome, "Documents", "EbayCSV", "DennisEbay.csv");
        //Path path = Paths.get("C:/Users/mplat/Documents/EbayCSV/DennisEbay.csv");
        csvHandler.processCSV(path.toString());

        if(connection != null) {
            System.out.println("connection null");
        }
        Gui gui = new Gui();
        gui.main(args, connection);
        }
    }
