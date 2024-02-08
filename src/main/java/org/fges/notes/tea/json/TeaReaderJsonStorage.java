package org.fges.notes.tea.json;

import com.fasterxml.jackson.core.type.TypeReference;
import org.fges.notes.tea.Tea;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * TeaReaderJsonStorage defines how to list teas from a json datasource
 */
class TeaReaderJsonStorage extends AbstractTeaJsonStorage {
    public TeaReaderJsonStorage(String fileName) {
        super(fileName);
    }

    public List<Tea> listTeas() throws Exception {
        String fileContent;
        try {
            fileContent = Files.readString(Path.of(fileName));
        } catch (Exception _ignored) {
            fileContent = "[]";
        }

        return objectMapper.readValue(fileContent, new TypeReference<>() {
        });
    }
}
