package com.randyn1080.jdbctutorial.service;

import com.randyn1080.jdbctutorial.dao.interfaces.*;
import com.randyn1080.jdbctutorial.dao.implementations.*;
import com.randyn1080.jdbctutorial.model.*;

import java.util.List;
import java.util.Optional;

public class QuizService {

    private final TopicDao topicDao;
    private final QuestionDao questionDao;
    private final AnswerDao answerDao;
    private final UserDao userDao;
    private final UserAnswerDao userAnswerDao;

    public QuizService() {
        this.topicDao = new TopicDaoImpl();
        this.questionDao = new QuestionDaoImpl();
        this.answerDao = new AnswerDaoImpl();
        this.userDao = new UserDaoImpl();
        this.userAnswerDao = new UserAnswerDaoImpl();
    }

    // Methods for quiz functionality

    public List<Topic> getAllTopics() {
        return topicDao.findAll();
    }

    public List<Question> getQuestionsByTopic(int topicId) {
        // TODO: Implement this method
        return null;
    }

    public List<Answer> getAnswersForQuestion(int questionId) {
        // TODO: Implement this method
        return null;
    }

    public boolean submitAnswer(int userId, int questionId, int answerId) {
        // TODO: Implement this method to record a user's answer
        return false;
    }

    public Optional<User> getUserByUsername(String username) {
        // TODO: Implement this method
        return Optional.empty();
    }

    public User createUser(String username, String email) {
        // TODO: Implement this method
        return null;
    }
}
