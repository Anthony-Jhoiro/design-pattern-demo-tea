package org.fges.notes.tea.json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * AbstractTeaJsonStorage contains methods that can be used by any classes that would interact with a JSON file
 */
abstract class AbstractTeaJsonStorage {
    protected final String fileName;

    /**
     * Here, the dependency to Jackson is hard, but that's fine because it is scoped to the package
     */
    protected final ObjectMapper objectMapper = new ObjectMapper();

    public AbstractTeaJsonStorage(String fileName) {
        this.fileName = fileName;
    }
}
