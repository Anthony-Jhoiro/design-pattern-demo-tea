package org.fges.notes.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fges.notes.tea.Tea;
import org.fges.notes.tea.service.TeaService;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Defines how to render the main page to a client.
 */
public class MainPage implements HttpHandler {

    private final TeaService teaService;

    public MainPage(TeaService teaService) {
        this.teaService = teaService;
    }

    record CreateTeaFormResult(String name, String imageUrl) {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if ("POST".equals(exchange.getRequestMethod())) {
            var objectMapper = new ObjectMapper();
            var form = objectMapper.readValue(exchange.getRequestBody(), CreateTeaFormResult.class);

            var newTea = new Tea(form.name, form.imageUrl);

            try {
                teaService.createTea(newTea);
            } catch (Exception e) {
                throw new IOException(e);
            }
        }

        try {
            generatePage(exchange, teaService.listTeas());
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public void generatePage(HttpExchange exchange, List<Tea> teas) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache template = mf.compile("web/index.mustache");

        var os = exchange.getResponseBody();

        Map<String, Object> context = new HashMap<>();
        context.put("teas", teas);

        StringWriter writer = new StringWriter();

        template.execute(writer, context);

        var body = writer.toString();

        exchange.getResponseHeaders().set("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, 0);

        os.write(body.getBytes());
        os.flush();
        os.close();
    }
}
