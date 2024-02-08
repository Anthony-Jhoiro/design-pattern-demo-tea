package org.fges.notes.tea.service;

import org.fges.notes.tea.Tea;

import java.util.List;

public interface TeaReaderStorage {
    List<Tea> listTeas() throws Exception;
}
