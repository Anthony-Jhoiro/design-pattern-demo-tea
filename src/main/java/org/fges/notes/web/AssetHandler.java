package org.fges.notes.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * Defines how to render a static asset to the client
 */
public class AssetHandler implements HttpHandler {
    private final String asset;

    public AssetHandler(String asset) {
        this.asset = asset;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("web/assets/" + asset);

        exchange.getResponseHeaders().set("Content-Type", "image/jpeg");
        exchange.sendResponseHeaders(200, 0);

        var os = exchange.getResponseBody();
        os.write(is.readAllBytes());
        os.flush();
        os.close();
    }
}
