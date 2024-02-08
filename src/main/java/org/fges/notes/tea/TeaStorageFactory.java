package org.fges.notes.tea;

import org.fges.notes.tea.service.TeaStorage;
import org.fges.notes.tea.json.TeaJsonStorage;
import org.fges.notes.tea.sqlite.TeaSqliteStorage;

import java.util.Map;
import java.util.function.Function;

public class TeaStorageFactory {
    private final String connectionString;
    private final Map<TeaStorage, Function<String, Boolean>> teaStoragePredicates;


    public TeaStorageFactory(String connectonString) {
        this.connectionString = connectonString;

        // this list could be made with a dependency injection library
        teaStoragePredicates = Map.of(
                new TeaJsonStorage(connectionString), (cs) -> cs.endsWith(".json"),
                new TeaSqliteStorage(connectionString), (cs) -> cs.startsWith("jdbc:sqlite")
        );
    }


    public TeaStorage getTeaStorage() {
        for (Map.Entry<TeaStorage, Function<String, Boolean>> entry : teaStoragePredicates.entrySet()) {
            if (entry.getValue().apply(connectionString)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
