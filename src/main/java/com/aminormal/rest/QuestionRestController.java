package com.aminormal.rest;

import com.aminormal.questions.Question;
import com.aminormal.questions.QuestionRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


/**
 * https://spring.io/guides/tutorials/rest/
 * https://dzone.com/articles/how-to-create-rest-api-with-spring-boot
 */

@SpringBootApplication
@RestController
public class QuestionRestController {


    @GetMapping("/questions")
    public String getRandomQuestion(){

        // This will get the random question from repo
        Question question = QuestionRepository.instance.getRandom();

        System.out.println("Test: "+question);

        return question.toJson();
    }

    @GetMapping("/questions{id}")
    public String getQuestionForID(@PathVariable(value = "id") int questionId) {

        // get the question for specific ID

        Question question = QuestionRepository.instance.getQuestion(questionId);

        System.out.println("Get the question id= "+questionId);

        return "{'success': 'ok'}";
    }

    @GetMapping("/test")
    public String getTest() {

        return "This is my test!!!";
    }

    @PostMapping ("/questions")
    public String addQuestion(@RequestBody String json){
        // Create the question object from the JSON
        // Add the question to the Repository

        JSONObject questionJson = new JSONObject(json);


        JSONArray responseJson = new JSONArray();



        return "{'success': 'ok'}";
    }

    @DeleteMapping (("/questions/{id}"))
    public String deleteQuestion(@PathVariable(value = "id") int questionId){

        System.out.println("Request to delete question id= "+ questionId);

        if (QuestionRepository.instance.containsQuestion(questionId)) {
            deleteQuestion(questionId);
            return "{'success': 'ok'}";
        }

        return "{'failure': 'not valid'}";
    }



    @GetMapping("/counter/{questionId}/{responseId}")
    public String incrementCounter(@PathVariable(value = "questionId") int questionId, @PathVariable(value = "responseId")int responseId){
        JSONObject jsonObject = new JSONObject();

        QuestionRepository questionRepository = QuestionRepository.instance;
        if (!questionRepository.containsQuestion(questionId)) {
            jsonObject.put("Result",-1);
            jsonObject.put("Error Message", "Question not found!");
        } else if (!questionRepository.containsResponse(responseId)) {
            jsonObject.put("Result", -1);
            jsonObject.put("Error Message", "Response not found!");
        } else {
            questionRepository.incrementCounter(questionId, responseId);
            jsonObject.put("Result", 0);
            jsonObject.put("Success", "Counter is now ");
        }

        return jsonObject.toString(4);
    }

}
