package com.randyn1080.jdbctutorial.model;

public class Topic {
    private int topicId;
    private String name;
    private String description;

    public Topic() {}

    public Topic(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Topic(int topicId, String name, String description) {
        this.topicId = topicId;
        this.name = name;
        this.description = description;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
