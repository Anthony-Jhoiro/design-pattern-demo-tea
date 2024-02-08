package org.fges.notes;

import org.fges.notes.tea.TeaStorageFactory;
import org.fges.notes.tea.service.TeaService;
import org.fges.notes.web.TeaWebServer;

public class Main {

    public static void main(String[] args) throws Exception {

        // Configuration
        String dataSourceConnectionString = "jdbc:sqlite:data.db";

        // Dependency injection
        var teaStorageFactory = new TeaStorageFactory(dataSourceConnectionString);

        var teaStorage = teaStorageFactory.getTeaStorage();
        if (teaStorage == null) {
            System.err.println("Unknown storage type, exiting...");
            System.exit(1);
        }

        var teaService = new TeaService(teaStorage);

        // Start the application
        new TeaWebServer(teaService, 8001).run();
    }
}
