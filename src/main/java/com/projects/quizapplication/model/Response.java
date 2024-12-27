package com.projects.quizapplication.model;

import lombok.RequiredArgsConstructor;
/**
 * This class represents a row with values from columns id and right_answer  from table "question" in database.
 */
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response; //represent a value from column "right_answer"

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
