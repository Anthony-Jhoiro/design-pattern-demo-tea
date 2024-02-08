package org.fges.notes.tea.sqlite;

import org.fges.notes.tea.Tea;
import org.fges.notes.tea.service.TeaStorage;

import java.util.List;

public class TeaSqliteStorage implements TeaStorage {
    private final String dbConnection;

    public TeaSqliteStorage(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void createTea(Tea tea) throws Exception {
        new TeaCreatorSqliteStorage(dbConnection).createTea(tea);
    }

    @Override
    public List<Tea> listTeas() throws Exception {
        return new TeaReaderSqliteStorage(dbConnection).listTeas();
    }
}
