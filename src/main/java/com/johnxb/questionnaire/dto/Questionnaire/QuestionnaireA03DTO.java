package com.johnxb.questionnaire.dto.Questionnaire;

import java.util.List;

public class QuestionnaireA03DTO {
    private String title;
    private String description;

    private List<QuestionDTO> questions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
