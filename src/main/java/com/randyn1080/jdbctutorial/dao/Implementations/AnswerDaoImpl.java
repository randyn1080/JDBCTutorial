package com.randyn1080.jdbctutorial.dao.Implementations;

import com.randyn1080.jdbctutorial.dao.interfaces.AnswerDao;
import com.randyn1080.jdbctutorial.model.Answer;
import com.randyn1080.jdbctutorial.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class AnswerDaoImpl implements AnswerDao {
    @Override
    public Answer save(Answer answer) {
        String sql = "INSERT INTO answers (question_id, answer_text, is_correct) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, answer.getQuestionId());
            ps.setString(2, answer.getAnswerText());
            ps.setBoolean(3, answer.isCorrect());

            int affectedRows = ps.executeUpdate();

            // creating, so expect affectedRows > 0 if it worked
            if (affectedRows == 0) {
                throw new SQLException("Creating topic failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    answer.setAnswerId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating topic failed, no ID obtained.");
                }
            }

            return answer;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Answer> findById(Integer id) {
        String sql = "SELECT * FROM answers WHERE answer_id = ?";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Answer answer = new Answer(rs.getInt("answer_id"),
                                                rs.getInt("question_id"),
                                                rs.getString("answer_text"),
                                                rs.getBoolean("is_correct"));
                    return Optional.of(answer);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Answer> findAll() {
        List<Answer> answers = new ArrayList<>();
        String sql = "SELECT * FROM answers";

        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                answers.add(new Answer(rs.getInt("answer_id"),
                                        rs.getInt("question_id"),
                                        rs.getString("answer_text"),
                                        rs.getBoolean("is_correct")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answers;
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
