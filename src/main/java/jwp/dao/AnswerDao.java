package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Answer;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class AnswerDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public List<Answer> findAllByQuestionId(int questionId) throws SQLException {
        String sql = "SELECT * FROM ANSWERS WHERE questionId=?";
        return jdbcTemplate.query(sql,
                rs-> new Answer(
                        rs.getInt("answerId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("questionId")),
                pstmt -> pstmt.setInt(1, questionId));
    }


    public Answer findByAnswerId(int answerId) throws SQLException {
        String sql = "SELECT answerId, writer, contents, createdDate, questionId FROM ANSWERS WHERE answerId = ?";
        return jdbcTemplate.queryForObject(sql,
                rs-> new Answer(
                        rs.getInt("answerId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("questionId")),
                pstmt -> pstmt.setObject(1, answerId));
    }

    public Answer insert(Answer answer) throws SQLException {
        String sql = "INSERT INTO ANSWERS " +
                "(questionId, writer, contents, createdDate) " +
                " VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new KeyHolder();
        jdbcTemplate.update(sql,
                pstmt -> {
                    pstmt.setInt(1, answer.getQuestionId());
                    pstmt.setString(2,answer.getWriter());
                    pstmt.setString(3,answer.getContents());
                    pstmt.setObject(4,answer.getCreatedDate());
                }, keyHolder);
        return findByAnswerId(keyHolder.getId());
    }
}
