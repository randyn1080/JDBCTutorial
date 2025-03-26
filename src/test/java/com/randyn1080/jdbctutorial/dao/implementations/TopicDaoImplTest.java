package com.randyn1080.jdbctutorial.dao.implementations;

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
        // get all the topics
        List<Topic> topics = topicDao.findAll();

        // verify we have all
        assertNotNull(topics);

        // if the above test passes, that doesn't mean that the list has topics
        // in it, only that it was instantiated. Check for topics within the list.
        assertFalse(topics.isEmpty(), "Should have at least one topic");
    }

    @Test
    void testUpdate() {
        // create a topic to update
        Topic topic = new Topic("Test", "This is a test");

        // save it
        Topic savedTopic = topicDao.save(topic);

        // update the description
        savedTopic.setDescription("This is an update test");
        boolean updated = topicDao.update(savedTopic);

        // verify update worked
        assertTrue(updated, "Update should return true");

        // ensure the update took effect correctly
        Optional<Topic> foundTopic = topicDao.findById(savedTopic.getTopicId());
        assertTrue(foundTopic.isPresent());
        assertEquals("This is an update test", foundTopic.get().getDescription());

        // clean up
        topicDao.deleteById(savedTopic.getTopicId());
    }

    @Test
    void testDelete() {
        // create a topic to delete
        Topic topic = new Topic("Test", "This is a test");

        // save the topic
        Topic savedTopic = topicDao.save(topic);

        // confirm it was saved
        assertNotNull(savedTopic, "Saved topic should not be null");

        // verify again it was saved
        Optional<Topic> preDeleteCheck = topicDao.findById(savedTopic.getTopicId());
        assertTrue(preDeleteCheck.isPresent(), "Topic should exist in DB after save");

        // delete it
        boolean deleted = topicDao.deleteById(savedTopic.getTopicId());

        // verify deletion worked
        assertTrue(deleted, "Delete should return true");

        // verify it's gone / cleanup
        Optional<Topic> foundTopic = topicDao.findById(savedTopic.getTopicId());
        assertFalse(foundTopic.isPresent(), "Topic should be deleted");
    }

}
