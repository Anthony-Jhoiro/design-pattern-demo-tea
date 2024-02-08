package org.fges.notes.tea.service;

import org.fges.notes.tea.Tea;

import java.util.List;

class TeaReaderService {
    public TeaReaderStorage teaReaderStorage;

    public TeaReaderService(TeaReaderStorage teaReaderStorage) {
        this.teaReaderStorage = teaReaderStorage;
    }

    public List<Tea> listTeas() throws Exception {
        // Any logic needed to list teas
        // examples:
        // - default sorting
        // - grouping data from various data-sources
        return teaReaderStorage.listTeas();
    }
}
