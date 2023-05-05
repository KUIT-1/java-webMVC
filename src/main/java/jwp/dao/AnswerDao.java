package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Answer;
import jwp.model.Answer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class AnswerDao {
    JdbcTemplate<Answer> jdbcTemplate = new JdbcTemplate<>();

    public List<Answer> findByQuestionId(int questionId) throws SQLException {
        String sql = "SELECT * FROM answers WHERE questionId=?";
        return jdbcTemplate.query(sql,
                pstmt -> pstmt.setInt(1,questionId),
                rs-> new Answer(
                        rs.getInt("answerId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getTimestamp("createdDate"),
                        rs.getInt("questionId")
                ));
    }

    public Answer insert(Answer answer) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        String sql = "INSERT INTO answers(writer,contents,createdDate,questionId) VALUES (?, ?, ?, ?)";
        jdbcTemplate.insert(sql, pstmt -> {
            pstmt.setString(1, answer.getWriter());
            pstmt.setString(2, answer.getContents());
            pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(4,answer.getQuestionId());}, keyHolder
        );
        return findByAnswerId(keyHolder.getId());
    }

    public Answer findByAnswerId(int answerId) throws SQLException {
        String sql = "SELECT * FROM answers WHERE answerId=?";
        return jdbcTemplate.queryForObject(sql,
                pstmt -> pstmt.setInt(1, answerId),
                rs -> new Answer(
                        rs.getInt("answerId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getTimestamp("createdDate"),
                        rs.getInt("questionId")
                ));
    }
}
