package com.tests;



import com.aminormal.questions.Question;
import com.aminormal.questions.QuestionRepository;
import com.aminormal.questions.Response;
import com.aminormal.rest.QuestionRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class TestSpringController {

    public static void main(String[] args) {
        addToRepo();
        SpringApplication.run(QuestionRestController.class, args);
    }

    private static void addToRepo(){
        QuestionRepository questionRepository = QuestionRepository.instance;
        ArrayList<Response> responses = new ArrayList<>();
        Response response = new Response("Brush my teeth");
        responses.add(response);
        response = new Response("Look at my phone");
        responses.add(response);
        Question question = new Question(-1,"What is the first thing you do in the morning?", responses);
        questionRepository.addQuestion(question);

        // Add a couple of more questions

        question = questionRepository.getRandom();
        System.out.println(question);

    }

}

