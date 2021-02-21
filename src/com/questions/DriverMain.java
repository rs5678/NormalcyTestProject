package com.questions;

import java.util.ArrayList;

public class DriverMain {

    public static void main(String args[]){
        QuestionRepository questionRepository = new QuestionRepository();

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
