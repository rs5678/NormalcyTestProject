package com.aminormal.questions;

import java.util.ArrayList;
import java.util.Random;

/**
 * Implemented as a Singleton
 */

public class QuestionRepository {

    public final static QuestionRepository instance = new QuestionRepository();

    // ArrayList of all of the questions in the database
    private ArrayList<Question> questionList;

    // Constructor to initialize ArrayList
    private QuestionRepository() {
        this.questionList = new ArrayList<>();
    }

    // Boolean method to get a question from the repository
    // Returns true if question does not already exist, otherwise false
    public boolean addQuestion(Question question) {
        for (Question value : questionList) {
            if (value == question) {
                return false;
            }
        }
        questionList.add(question);
        return true;
    }

    // Returns a random question from the repository
    public Question getRandom() {
        Random ranVal = new Random();
        int minVal = 0;
        int maxVal = questionList.size();
        int randomValue = ranVal.nextInt(maxVal-minVal) + minVal;
        return questionList.get(randomValue);
    }

    // Get question when given a specific id number
    public Question getQuestion(int id){
        for (int i = 0; i < questionList.size(); i++) {
            if (questionList.get(i).getId() == id) {
                return questionList.get(i);
            }
        }
        return null;
    }
}
