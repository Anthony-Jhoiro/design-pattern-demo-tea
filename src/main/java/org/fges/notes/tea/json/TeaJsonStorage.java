package org.fges.notes.tea.json;

import org.fges.notes.tea.Tea;
import org.fges.notes.tea.service.TeaStorage;

import java.util.List;

/**
 * TeaJsonStorage is a facade that implements the TeaStorage class.
 * It redirects to the right components that will handle each case.
 *
 * @see TeaCreatorJsonStorage
 * @see TeaReaderJsonStorage
 */
public class TeaJsonStorage implements TeaStorage {
    private final String fileName;

    public TeaJsonStorage(String fileName) {
        this.fileName = fileName;
    }

    public void createTea(Tea tea) throws Exception {
        var teaReaderJsonStorage = new TeaReaderJsonStorage(fileName);
        new TeaCreatorJsonStorage(fileName, teaReaderJsonStorage).createTea(tea);
    }

    public List<Tea> listTeas() throws Exception {
        return new TeaReaderJsonStorage(fileName).listTeas();
    }
}
