package com.questions;

import java.util.ArrayList;

public class Question {

    final int id;

    public Question(int id, String text, ArrayList<Response> responses){
        this.id = id;
    }

    public Question(String text, ArrayList<Response> responses){
        this(-1, text, responses);
    }

    public int getId() {
        return id;
    }

    public String toJson(){
        return "{to be coded}";
    }
}


