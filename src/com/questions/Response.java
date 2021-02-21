package com.questions;

public class Response {

    // Setup all attributes
    public final String text;

    // Constructor that taes all attributes as arguments
    public Response(String text, int normlacyPercent){
        this.text = text;
        // setup the attributes here
    }

    public Response(String text){

        // set normlacy percent to -1 to indicate that it is yet to be assigned

        this(text, -1);
    }

    public String toJson(){
        return "{to be coded}";
    }
}
