package com.aminormal.rest;

import com.aminormal.questions.Question;
import com.aminormal.questions.QuestionRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * https://spring.io/guides/tutorials/rest/
 */

@SpringBootApplication
@RestController
public class QuestionRestController {


    @GetMapping("/questions")
    public String getRandomQuestion(){

        Question question = QuestionRepository.instance.getRandom();

        return question.toJson();
    }
}
