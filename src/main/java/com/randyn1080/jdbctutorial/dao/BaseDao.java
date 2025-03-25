package com.randyn1080.jdbctutorial.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T, ID> {

    // Create
    T save(T entity);
    // Read
    Optional<T> findById(ID id);
    List<T> findAll();
    // Update
    boolean update(T entity);
    // Delete
    boolean deleteById(ID id);
}
