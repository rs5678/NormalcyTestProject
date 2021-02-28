package com.aminormal.questions;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Response {

    // All attributes

    // Every response will have a UNIQUE ID

    // Every response will have a counter
    // Counter will be incremented every time some one responds

    public final String text;
    final int id;
    public int counter;

    // Initialize response constructor
    public Response(int id, String text){
        this.id = id;
        this.text = text;
    }

    public Response(String text){
        // set normlacy percent to -1 to indicate that it is yet to be assigned
        this(-1,text);
    }

    public int getCounter() {
        return counter;
    }

    public int incrementCounter(int id) {
        if (this.id == id) {
            counter += 1;
        }
        return counter;
    }

    private String setResponse(String text) {
        return text;
    }

    private int getId() {
        return this.id;
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id",this.id);
        jsonObject.put("text",this.text);
        jsonObject.put("counter", this.counter);

        return jsonObject;
    }
}