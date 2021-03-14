package com.aminormal.rest;

import com.aminormal.questions.Question;
import com.aminormal.questions.QuestionRepository;
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
    public String getRandomQuestion(@PathVariable(value = "id") int questionId) {

        // get the question for specific ID

        System.out.println("Get the qustion id="+questionId);

        return "{'success': 'ok'}";
    }

    @GetMapping("/test")
    public String getTest() {

        return "This is my test!!!";
    }

    @PostMapping ("/questions")
    public String addQuestion(@RequestBody String json){

        System.out.println(json);

        // Create the question object from the JSON

        // Add the question to the Repository

        return "{'success': 'ok'}";
    }

    @DeleteMapping (("/questions/{id}"))
    public String deleteQuestion(@PathVariable(value = "id") int questionId){

        System.out.println("Request to delete qustion id="+questionId);

        return "{'success': 'ok'}";
    }


    @GetMapping("/counter/{questionId}/{responseId}")
    public String incrementCounter(@PathVariable(value = "questionId") int questionId, @PathVariable(value = "responseId")String responseId){

        // Increment code goes here



        return "Successfull Increment!!! "+questionId+" "+responseId;
    }

}
