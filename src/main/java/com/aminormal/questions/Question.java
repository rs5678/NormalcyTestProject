package com.aminormal.questions;

import org.json.JSONObject;

import java.util.ArrayList;

public class Question {

    // each question has a unique identity - a number
    final int id;

    // each question has its own text
    final String text;

    // each question has its own set of response
    final ArrayList<Response> responses;

    // Question identity is set to -1
    // When a new question added to the repository a question id gets assigned to it
    // Create 2 constructors

    // #1 for existing questions
    public Question(int id, String text, ArrayList<Response> responses){
        this.id = id;
        this.text = text;
        this.responses = responses;
    }

    // #2 for new question
    public Question(String text, ArrayList<Response> responses){
        this(-1, text, responses);
    }

    // #3 get Id for each question
    public int getId() {
        return id;
    }

    public String toJson(){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id",this.id);


        return jsonObject.toString(4);
    }
}