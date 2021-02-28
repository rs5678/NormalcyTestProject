package com.aminormal.rest;

import com.aminormal.questions.Question;
import com.aminormal.questions.QuestionRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping("/test")
    public String getTest() {

        return "This is my test!!!";
    }

}
