package com.projects.quizapplication.controller;

import com.projects.quizapplication.model.Response;
import com.projects.quizapplication.wrapper.QuestionWrapper;
import com.projects.quizapplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This class represents controller to show on the website all the inquiries regarding quizzes described in this class, such as "create quiz","get quiz question", etc.
 */
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    /**
     * Function for displaying the results of function from {@link QuizService#createQuiz(String, int, String)} on the website.
     * You can work with this method only using a "Postman" application, guide how to work you can read in README.md.
     * @param category represents a category of created quiz
     * @param numberOfQuestion represents a number of questions in created quiz
     * @param title represents a name of created quiz
     * @return results from {@link QuizService#createQuiz(String, int, String)}
     */
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numberOfQuestion, @RequestParam String title) {
        return quizService.createQuiz(category, numberOfQuestion, title);
    }

    /**
     * Function for displaying the results of function from {@link QuizService#getQuizQuestions(Integer)} on the website.
     * You can work with this method only using a "Postman" application, guide how to work you can read in README.md.
     * @param id represents an id of question represented in database
     * @return results from {@link QuizService#getQuizQuestions(Integer)}
     */
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    /**
     * Function for displaying the results of function from {@link QuizService#calculateResult(Integer, List)} on the website.
     * You can work with this method only using a "Postman" application, guide how to work you can read in README.md.
     * @param id represents an id of question represented in database
     * @param responses represents a list of correct answers for our question
     * @return results from {@link QuizService#calculateResult(Integer, List)}
     */
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
