package com.randyn1080.jdbctutorial.dao.implementations;

import com.randyn1080.jdbctutorial.dao.interfaces.QuestionDao;
import com.randyn1080.jdbctutorial.model.Question;

import java.util.List;
import java.util.Optional;

public class QuestionDaoImpl implements QuestionDao {
    @Override
    public Question save(Question entity) {
        return null;
    }

    @Override
    public Optional<Question> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Question> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Question entity) {
        return false;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }
}
