package org.fges.notes.tea.sqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Any method used to create teas
 */
abstract class AbstractTeaSqliteStorage {
    private final String dbConnection;

    public AbstractTeaSqliteStorage(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    protected Connection getDb() throws SQLException {
        System.err.println("Initializing db");
        Connection db = DriverManager.getConnection(dbConnection);

        DatabaseMetaData meta = db.getMetaData();
        System.err.println("Connected to database " + meta.getDriverName());

        // Initializing the database for each call is not great, but for this example, it will do the trick.
        db.createStatement().execute("CREATE TABLE IF NOT EXISTS teas (id integer PRIMARY KEY, name varchar, imageUrl varchar)");

        System.err.println("Database initialized.");
        return db;
    }
}
