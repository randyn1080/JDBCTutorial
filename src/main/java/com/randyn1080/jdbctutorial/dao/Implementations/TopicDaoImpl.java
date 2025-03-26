package com.randyn1080.jdbctutorial.dao.Implementations;

import com.randyn1080.jdbctutorial.dao.interfaces.TopicDao;
import com.randyn1080.jdbctutorial.model.Topic;
import com.randyn1080.jdbctutorial.util.ConnectionFactory;

import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;

public class TopicDaoImpl implements TopicDao {

    //CREATE
    @Override
    public Topic save(Topic topic) {
        String sql = "INSERT INTO topics (name, description) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, topic.getName());
            ps.setString(2, topic.getDescription());

            int affectedRows = ps.executeUpdate();

            // creating, so expect affectedRows > 0 if it worked
            if (affectedRows == 0) {
                throw new SQLException("Creating topic failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    topic.setTopicId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating topic failed, no ID obtained.");
                }
            }

            return topic;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //READ
    @Override
    public Optional<Topic> findById(Integer id) {
        String sql = "SELECT * FROM topics WHERE topic_id = ?";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Topic topic = new Topic(rs.getInt("topic_id"),
                                            rs.getString("name"),
                                            rs.getString("description"));
                    return Optional.of(topic);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    //READ
    @Override
    public List<Topic> findAll() {
        List<Topic> topics = new ArrayList<>();
        String sql = "SELECT * FROM topics";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                topics.add(new Topic(rs.getInt("topic_id"),
                                    rs.getString("name"),
                                    rs.getString("description")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }

    //UPDATE
    @Override
    public boolean update(Topic topic) {
        String sql = "UPDATE topics SET name = ?, description = ? WHERE topic_id = ?";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, topic.getName());
            ps.setString(2, topic.getDescription());
            ps.setInt(3, topic.getTopicId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //DELETE
    @Override
    public boolean deleteById(Integer id) {
        String sql = "DELETE FROM topics WHERE topic_id = ?";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
