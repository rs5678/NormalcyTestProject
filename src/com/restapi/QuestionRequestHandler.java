package com.restapi;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class QuestionRequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("HTTP Verb:"+httpExchange.getRequestMethod());

        String response = "{this is where the JSON will go}";

        // Create a stream
        OutputStream outputStream = httpExchange.getResponseBody();

        httpExchange.sendResponseHeaders(200, response.length());
        outputStream.write(response.getBytes());

        outputStream.flush();

        outputStream.close();
    }
}
