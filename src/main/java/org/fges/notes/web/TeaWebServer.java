package org.fges.notes.web;

import com.sun.net.httpserver.HttpHandler;
import org.fges.notes.tea.service.TeaService;
import org.fges.notes.tea.service.TeaStorage;

import java.util.HashMap;
import java.util.Map;

public class TeaWebServer extends WebServer {

    /**
     * Here, the assets list is constant, but it could be dynamic
     */
    private static final String[] assets = {"tea1.jpg", "tea2.jpg", "tea3.jpg", "tea4.jpg", "tea5.jpg"};

    private final TeaService teaService;

    public TeaWebServer(TeaService teaService, int port) {
        super(port);
        this.teaService = teaService;
    }

    @Override
    Map<String, HttpHandler> getHandlers() {
        var handlers = new HashMap<String, HttpHandler>();
        handlers.put("/", new MainPage(teaService));

        for (var asset : assets) {
            handlers.put("/assets/" + asset, new AssetHandler(asset));
        }
        return handlers;
    }
}
