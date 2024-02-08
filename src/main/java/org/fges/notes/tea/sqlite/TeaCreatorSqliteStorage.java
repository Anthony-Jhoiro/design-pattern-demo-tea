package org.fges.notes.tea.sqlite;

import org.fges.notes.tea.Tea;

import java.sql.SQLException;
import java.util.Random;

/**
 * TeaReaderJsonStorage defines how to create a tea in a sqlite datasource
 */
class TeaCreatorSqliteStorage extends AbstractTeaSqliteStorage {
    private final Random idGenerator = new Random();


    public TeaCreatorSqliteStorage(String dbConnection) {
        super(dbConnection);
    }

    public void createTea(Tea tea) throws SQLException {
        var db = getDb();
        var stmt = db.prepareStatement("INSERT INTO teas (id, name, imageUrl) VALUES (?, ?, ?)");
        stmt.setInt(1, idGenerator.nextInt());
        stmt.setString(2, tea.name());
        stmt.setString(3, tea.imageLink());
        stmt.executeUpdate();
    }
}
