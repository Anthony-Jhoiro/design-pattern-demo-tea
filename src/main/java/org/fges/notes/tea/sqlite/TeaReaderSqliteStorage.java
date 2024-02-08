package org.fges.notes.tea.sqlite;

import org.fges.notes.tea.Tea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TeaReaderJsonStorage defines how to list teas from a sqlite datasource
 */
class TeaReaderSqliteStorage extends AbstractTeaSqliteStorage {
    private final Random idGenerator = new Random();


    public TeaReaderSqliteStorage(String dbConnection) {
        super(dbConnection);
    }

    public List<Tea> listTeas() throws Exception {
        var db = getDb();
        var stmt = db.createStatement();
        var teas = new ArrayList<Tea>();

        var resultSet = stmt.executeQuery("select name, imageUrl from teas");

        while (resultSet.next()) {
            var tea = new Tea(
                    resultSet.getString("name"),
                    resultSet.getString("imageUrl")
            );

            teas.add(tea);
        }
        return teas;
    }
}
