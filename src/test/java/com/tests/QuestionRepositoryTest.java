package com.tests;

import com.aminormal.questions.Question;
import com.aminormal.questions.QuestionRepository;
import com.aminormal.questions.Response;

import java.util.ArrayList;

public class QuestionRepositoryTest {

    public static void main(String args[]){
        QuestionRepository questionRepository = QuestionRepository.instance;

        ArrayList<Response> responses = new ArrayList<>();
        Response response = new Response(1,"Brush my teeth");
        responses.add(response);
        response = new Response(2,"Look at my phone");
        responses.add(response);
        response.incrementCounter(2);
        response.incrementCounter(2);
        Question question = new Question(1,"What is the first thing you do in the morning?", responses);
        questionRepository.addQuestion(question);

        // Add a couple of more questions

        question = questionRepository.getRandom();
        System.out.println(question.toJson());

    }
}

