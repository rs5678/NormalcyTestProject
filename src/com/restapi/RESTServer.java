package com.restapi;

import com.questions.QuestionRepository;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * This class will be our REST API Server
 * https://dzone.com/articles/simple-http-server-in-java
 */
public class RESTServer {

    // Single instance of Repository Object
    // Pattern: Singleton
    private static  QuestionRepository  questionRepoistory = new QuestionRepository();

    public static void main(String[] args)
    throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);

        server.start();

    }


    /**
     * This will use the repository to get the random question
     * @return
     */
    public static String getRandomQuestion(){
        return null;
    }


}
