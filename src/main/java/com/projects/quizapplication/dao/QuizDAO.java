package com.projects.quizapplication.dao;

import com.projects.quizapplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents data access object(DAO) to work with data from table "quiz" in database.
 */
@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {
}
