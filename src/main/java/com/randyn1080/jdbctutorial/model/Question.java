package com.randyn1080.jdbctutorial.model;

public class Question {
    private int questionId;
    private int topicId;
    private String questionText;
    private String difficulty;

    public Question(int questionId, int topicId, String questionText, String difficulty) {
        this.questionId = questionId;
        this.topicId = topicId;
        this.questionText = questionText;
        this.difficulty = difficulty;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", topicId=" + topicId +
                ", questionText='" + questionText + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
