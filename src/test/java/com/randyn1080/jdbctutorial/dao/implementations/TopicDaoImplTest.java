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
        // make a new topic
        Topic topic = new Topic();
        topic.setName("Test");
        topic.setDescription("This is a test");

        // save it to the db
        Topic savedTopic = topicDao.save(topic);

        // verify it was saved correctly
        assertNotNull(savedTopic);
        assertTrue(savedTopic.getTopicId() > 0, "ID should be assigned");

        // find it by id
        Optional<Topic> foundTopic = topicDao.findById(savedTopic.getTopicId());

        // verify it was found
        assertTrue(foundTopic.isPresent(), "Topic should be found");
        assertEquals("Test", foundTopic.get().getName());
        assertEquals("This is a test", foundTopic.get().getDescription());

        // clean up
        topicDao.deleteById(savedTopic.getTopicId());
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
