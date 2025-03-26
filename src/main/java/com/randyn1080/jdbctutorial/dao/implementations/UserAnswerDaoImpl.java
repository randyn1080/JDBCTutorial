package com.randyn1080.jdbctutorial.dao.implementations;

import com.randyn1080.jdbctutorial.dao.interfaces.UserAnswerDao;
import com.randyn1080.jdbctutorial.model.UserAnswer;

import java.util.List;
import java.util.Optional;

public class UserAnswerDaoImpl implements UserAnswerDao {
    @Override
    public UserAnswer save(UserAnswer entity) {
        return null;
    }

    @Override
    public Optional<UserAnswer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<UserAnswer> findAll() {
        return List.of();
    }

    @Override
    public boolean update(UserAnswer entity) {
        return false;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }
}
