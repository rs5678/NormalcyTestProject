package com.questions;

import java.util.ArrayList;
import java.util.Random;

public class QuestionRepository {
    private ArrayList<Question> questionList;
    private Question question;

    public boolean addQuestion(Question question) {
        for (Question value : questionList) {
            if (value == question) {
                return false;
            }
        }
        questionList.add(question);
        return true;
    }

    public Question getRandom() {
        Random ranVal = new Random();
        int minVal = 0;
        int maxVal = questionList.size();
        int randomValue = ranVal.nextInt(maxVal-minVal) + minVal;
        return questionList.get(randomValue);
    }

    public Question getQuestion(int id){
        for (int i = 0; i < questionList.size(); i++) {
            if (questionList.get(i).getId() == id) {
                return questionList.get(i);
            }
        }
        return null;
    }
}
