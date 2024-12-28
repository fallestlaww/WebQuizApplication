package com.projects.quizapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * This class represents a row with all values from all columns from table "quiz" in database.
 */
@Setter
@Getter
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    private List<Question> questions;

}
