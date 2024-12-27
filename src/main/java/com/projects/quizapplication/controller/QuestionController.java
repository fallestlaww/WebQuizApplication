package com.projects.quizapplication.controller;

import com.projects.quizapplication.model.Question;
import com.projects.quizapplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This class represents controller to show on the website all the inquiries regarding questions described in this class, such as "get all questions","get question by category", etc.
 */
@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    /**
     * Function for displaying the results of function from {@link QuestionService#getAllQuestions()} on the website.
     * To see the result of the function, after starting the project follow the link localhost:8080/question/allQuestion.
     * @return results from {@link QuestionService#getAllQuestions()}
     */
    @GetMapping("allQuestion")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * Function for displaying the results of function from {@link QuestionService#getQuestionByCategory(String)} on the website.
     * To see the result of the function, after starting the project follow the link localhost:8080/question/category/(value you passed in "category" parameter).
     * @param category create a new link for each category passed in the parameter as String
     * @return results from {@link QuestionService#getQuestionByCategory(String)}
     */
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    /**
     * Function for displaying the results of function from {@link QuestionService#addQuestion(Question)} on the website.
     * You can work with this method only using a "Postman" application, guide how to work you can read in README.md.
     * @param question represents a question which we need to add in database.
     * @return results from {@link QuestionService#addQuestion(Question)}
     */
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
       return questionService.addQuestion(question);
    }

    /**
     * Function for displaying the results of function from {@link QuestionService#updateQuestionById(Integer, Question)} on the website.
     * You can work with this method only using a "Postman" application, guide how to work you can read in README.md.
     * @param id represents an id of our question represents in database.
     * @param question represents a question which we need to add in database.
     * @return results from {@link QuestionService#updateQuestionById(Integer, Question)}
     */
    @PostMapping("update/{id}")
    public ResponseEntity<String> updateQuestionById(@PathVariable Integer id, @RequestBody Question question){
        return questionService.updateQuestionById(id, question);
    }

    /**
     * Function for displaying the results of function from {@link QuestionService#deleteQuestionByID(Integer)} on the website.
     * You can work with this method only using a "Postman" application, guide how to work you can read in README.md.
     * @param id represents an id of our question represents in database.
     * @return results from {@link QuestionService#deleteQuestionByID(Integer)}
     */
    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id) {
        return questionService.deleteQuestionByID(id);
    }
}
