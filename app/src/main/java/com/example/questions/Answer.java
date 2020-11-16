package com.example.questions;

public class Answer {
    private Boolean answer;
    private String question;

    public Answer(String question, Boolean answer) {
        this.setAnswer(answer);
        this.setQuestion(question);
    }


    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
