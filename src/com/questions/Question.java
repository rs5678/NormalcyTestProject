package com.questions;

import java.util.ArrayList;

public class Question {

    // each question has a unique identity - a number
    final int id;

    // Define other attributes as final variables

    // Question identity is set to -1
    // When a new question added to the repository a question id gets assigned to it
    // Create 2 constructors

    // #1 for existing quetions
    public Question(int id, String text, ArrayList<Response> responses){
        this.id = id;
    }

    // #2 for new question
    public Question(String text, ArrayList<Response> responses){
        this(-1, text, responses);
    }

    public String toJson(){
        return "{to be coded}";
    }
}
