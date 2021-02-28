package com.aminormal.questions;

import java.util.ArrayList;

public class Response {

    // All attributes
    public final String text;
    final int normalcyPercent;

    // Initialize response constructor
    public Response(String text, int normlacyPercent){
        this.text = text;
        this.normalcyPercent = normlacyPercent;
    }

    public Response(String text){
        // set normlacy percent to -1 to indicate that it is yet to be assigned
        this(text, -1);
    }

    private String setResponse(String text) {
        return text;
    }

    public String toJson(){
        return "{to be coded}";
    }
}