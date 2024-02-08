package org.fges.notes.tea.service;

import org.fges.notes.tea.Tea;

import java.util.List;

/**
 * TeaService is the logic layer of the codebase.
 * It is a Facade which role is to dispatch functions to the right implementation.
 * It can be accepted to not make it implement an interface but it can be interesting
 * for a microservice app for example.
 * <p>
 * The service must only use domains to communicate between each part of your application.
 * It avoids having hard dependencies on the core of your application.
 */
public class TeaService {
    private final TeaStorage teaStorage;

    public TeaService(TeaStorage teaStorage) {
        this.teaStorage = teaStorage;
    }

    public void createTea(Tea tea) throws Exception {
        new TeaCreatorService(teaStorage).createTea(tea);
    }

    public List<Tea> listTeas() throws Exception {
        return new TeaReaderService(teaStorage).listTeas();
    }
}
