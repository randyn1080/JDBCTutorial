package com.randyn1080.jdbctutorial.dao.Implementations;

import com.randyn1080.jdbctutorial.dao.interfaces.AnswerDao;
import com.randyn1080.jdbctutorial.model.Answer;

import java.util.List;
import java.util.Optional;

public class AnswerDaoImpl implements AnswerDao {
    @Override
    public Answer save(Answer entity) {
        return null;
    }

    @Override
    public Optional<Answer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Answer> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Answer entity) {
        return false;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }
}
