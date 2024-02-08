package org.fges.notes.tea.service;

import org.fges.notes.tea.Tea;

class TeaCreatorService {
    public TeaCreatorStorage teaCreatorStorage;

    public TeaCreatorService(TeaCreatorStorage teaCreatorStorage) {
        this.teaCreatorStorage = teaCreatorStorage;
    }

    public void createTea(Tea tea) throws Exception {
        // Any logic needed to create a tea
        // examples:
        // - call external APIs to fetch more data
        // - validate the attributes
        teaCreatorStorage.createTea(tea);
    }
}
