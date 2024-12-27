package com.projects.quizapplication.service;

import com.projects.quizapplication.model.Response;
import com.projects.quizapplication.wrapper.QuestionWrapper;
import com.projects.quizapplication.model.Question;
import com.projects.quizapplication.model.Quiz;
import com.projects.quizapplication.dao.QuestionDAO;
import com.projects.quizapplication.dao.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * This class represents service which contains all business-logic for all the inquiries regarding quizzes.
 */
@Service
public class QuizService {
    @Autowired
    QuizDAO quizDAO;
    @Autowired
    QuestionDAO questionDAO;

    /**
     * Function for creating new quiz by user, which will be immediately added to the database in table "quiz".
     * Since the questions select randomly, program will immediately create table "quiz_questions" or add selected questions to table "quiz_questions" if table already created.
     * @param category represents a category of created quiz
     * @param numberOfQuestion represents a number of questions in created quiz
     * @param title represents a name of created quiz
     * @return string explains that everything was successfully and CREATED HTTP status
     */
    public ResponseEntity<String> createQuiz(String category, int numberOfQuestion, String title) {
        List<Question> questions = questionDAO.findRandomQuestionsByCategory(category, numberOfQuestion);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    /**
     * Function for displaying questions belongs to our quiz. Function fetches elements from database into default list.
     * Therefore, this function gives us a list of right answers we can work with.
     * @param id represents an id of question belongs to the created quiz located in database
     * @return a list of right answers and OK HTTP status
     */
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question question : questionsFromDB) {
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(),
                    question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    /**
     * Function for calculating user`s result after completing the quiz.
     * @param id represents an id of created quiz located in database
     * @param respons represents a list of right answers fetched in function {@link #getQuizQuestions(Integer)}
     * @return a number of right answers and OK HTTP status
     */
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> respons) {
        Quiz quiz = quizDAO.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        for (Response response : respons) {
            for (Question question : questions) {
                if (question.getId().equals(response.getId())) {
                    if (question.getRightAnswer().equals(response.getResponse())) {
                        right++;
                    }
                    break;
                }
            }
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
