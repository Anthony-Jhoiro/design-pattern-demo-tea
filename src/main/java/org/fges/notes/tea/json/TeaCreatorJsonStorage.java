package org.fges.notes.tea.json;

import org.fges.notes.tea.Tea;

import java.io.File;

/**
 * TeaReaderJsonStorage defines how to create a tea in a json datasource
 */
class TeaCreatorJsonStorage extends AbstractTeaJsonStorage {

    private final TeaReaderJsonStorage teaReader;


    public TeaCreatorJsonStorage(String fileName, TeaReaderJsonStorage teaReader) {
        super(fileName);
        this.teaReader = teaReader;

    }

    public void createTea(Tea tea) throws Exception {
        var file = new File(fileName);

        var teas = teaReader.listTeas();
        teas.add(tea);

        objectMapper.writeValue(file, teas);
    }
}
