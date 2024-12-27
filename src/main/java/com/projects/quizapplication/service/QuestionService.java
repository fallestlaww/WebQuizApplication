package com.projects.quizapplication.service;
import com.projects.quizapplication.model.Question;
import com.projects.quizapplication.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represents service which contains all business-logic for all the inquiries regarding questions.
 */
@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    /**
     * Function for displaying all questions which described in database.
     * @return all questions and HTTP status code 200 if everything is correct or empty list with BAD_REQUEST HTTP status if not
     */
    public ResponseEntity<List<Question>> getAllQuestions() {
       try{
           return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Function for displaying all questions which belong to category passed in parameter.
     * @param category represents a category for which this function will find questions
     * @return all questions belong to selected category and HTTP status code 200 if everything is correct
     * or empty list with BAD_REQUEST HTTP status if not
     */
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Function for adding question to the database.
     * @param question represents a question which we want to add
     * @return string explains that everything was successfully and CREATED HTTP status
     */
    public ResponseEntity<String> addQuestion(Question question) {
        questionDAO.save(question);
        return new ResponseEntity<>("Question added", HttpStatus.CREATED);
    }

    /**
     * Function for updating question located in the database.
     * @param id represents an id of question located in database
     * @param question represents a question which we want to add instead that one located in database
     * @return string explains that everything was successfully and OK HTTP status if everything passed correct or
     * string explains that everything was unsuccessful and NOT_FOUND HTTP status if question is not in the database
     */
    public ResponseEntity<String> updateQuestionById(Integer id, Question question) {
        if(questionDAO.existsById(id)) {
            question.setId(id); // set the same id of that question located in database for new question
            questionDAO.save(question);
            return new ResponseEntity<>("Question updated", HttpStatus.OK);
        } else return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
        }

    /**
     * Function for deleting question from the database.
     * @param id represents an id of question located in database
     * @return string explains that everything was successfully and OK HTTP status if everything passed correct or
     * string explains that everything was unsuccessful and NOT_FOUND HTTP status if question is not in the database
     */
    public ResponseEntity<String> deleteQuestionByID(Integer id) {
        if(questionDAO.existsById(id)) {
            questionDAO.deleteById(id);
            return new ResponseEntity<>("Question deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
    }
}
