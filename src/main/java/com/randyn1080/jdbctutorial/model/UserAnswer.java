package com.randyn1080.jdbctutorial.model;

import java.time.ZonedDateTime;

public class UserAnswer {
    private int attemptId;
    private int userId;
    private int questionId;
    private int answerId;
    private ZonedDateTime attemptTime;

    public UserAnswer(int attemptId, int userId, int questionId, int answerId, ZonedDateTime attemptTime) {
        this.attemptId = attemptId;
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.attemptTime = attemptTime;
    }

    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public ZonedDateTime getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(ZonedDateTime attemptTime) {
        this.attemptTime = attemptTime;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "attemptId=" + attemptId +
                ", userId=" + userId +
                ", questionId=" + questionId +
                ", answerId=" + answerId +
                ", attemptTime=" + attemptTime +
                '}';
    }
}
