package com.randyn1080.jdbctutorial.dao.implementations;

import com.randyn1080.jdbctutorial.dao.Implementations.TopicDaoImpl;
import com.randyn1080.jdbctutorial.dao.interfaces.TopicDao;
import com.randyn1080.jdbctutorial.model.Topic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TopicDaoImplTest {

    private TopicDao topicDao;

    @BeforeEach
    void setUp() {
        topicDao = new TopicDaoImpl();
    }

    @Test
    void testSaveAndFindById() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testUpdate() {

    }

    @Test
    void testDelete() {

    }
}
