package com.projects.quizapplication.dao;

import com.projects.quizapplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This interface represents data access object(DAO) to work with data from table "question" in database.
 */
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
    /**
     * Function for finding in database values with category which we passed in same-named parameter.
     * @param category represents category by which function will find the question in database
     * @return list of question with correct category
     */
    List<Question> findByCategory(String category);

    /**
     * Function for finding in database needed number of random question with needed category by writing custom request.
     * @param category represents category by which function will find the question in database
     * @param numberOfQuestions represents a number question we need
     * @return list of question with correct category
     */
    @Query(value = "SELECT * FROM question.question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numberOfQuestions);
}
