package com.projects.quizapplication.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * This class represents a row with values from columns id and right_answer  from table "question" in database.
 */
@Setter
@Getter
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response; //represent a value from column "right_answer"
}
