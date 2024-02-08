package org.fges.notes.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public abstract class WebServer {

    private final int port;

    public WebServer(int port) {
        this.port = port;
    }

    abstract Map<String, HttpHandler> getHandlers();

    public void run() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", port), 0);

        var handlers = getHandlers();

        // Add entries
        for (var entry : handlers.entrySet()) {
            server.createContext(entry.getKey(), entry.getValue());
        }

        System.err.println("Server is listening on " + server.getAddress().toString());
        server.start();
    }
}
