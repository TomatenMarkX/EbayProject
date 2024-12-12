package org.example;

public class Main {
    public static void main(String[] args) {
        FolderWatcher watcher = new FolderWatcher("Pfad/zum/Ordner");
        watcher.watchFolder();
    }
}