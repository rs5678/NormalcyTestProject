package com.aminormal.questions;

import com.aminormal.db.MongoDBBase;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static javax.management.Query.in;

public class QuestionRepositoryMongoDB extends MongoDBBase {

    public final static String COLLECTION_QUESTIONS="questions";

    public boolean addQuestion(Question question) {
        return false;
    }


    public static void main(String[] args){
        String json = "{'question_id': 2, 'text': '2-This is the question from java'}";

        QuestionRepositoryMongoDB questionRepositoryMongoDB = new QuestionRepositoryMongoDB();

//        questionRepositoryMongoDB.executeInsert(COLLECTION_QUESTIONS, json);

        Bson filter = eq("question_id",3);

//        int[] x = {Integer(1) ,2};
//        filter = in("question_id",x);

        FindIterable iterable = questionRepositoryMongoDB.find(COLLECTION_QUESTIONS, filter);
        ArrayList<Document> docs = new ArrayList<Document>();

        iterable.into(docs);

        for(int i=0; i<docs.size();i++){
            System.out.println(docs.get(i));
        }
    }
}
