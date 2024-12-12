package org.example;

import java.io.IOException;
import java.nio.file.*;

public class FolderWatcher {
    private final Path folderPath;
    private final CSVHandler csvHandler = new CSVHandler();

    public FolderWatcher(String folderPath) {
        this.folderPath = Paths.get(folderPath);
    }

    public void watchFolder() {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            System.out.println("Überwachung des Ordners gestartet: " + folderPath);

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path fileName = (Path) event.context();
                        System.out.println("Neue Datei erkannt: " + fileName);
                        // Hier kannst du die CSV-Verarbeitung starten
                    }
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Fehler beim Überwachen des Ordners: " + e.getMessage());
        }
    }
}
