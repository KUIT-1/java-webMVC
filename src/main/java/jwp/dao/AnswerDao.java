package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Answer;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class AnswerDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public Answer insert(Answer answer) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        String sql = "INSERT INTO ANSWERS (writer, contents, questionId) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, answer.getWriter());
            pstmt.setString(2, answer.getContents());
            pstmt.setObject(3, answer.getQuestionId());
        }, keyHolder);
        return findByAnswerId(keyHolder.getId());
    }

    public void update(Answer answer) throws SQLException {
        // TODO 구현 필요함.
        String sql = "update answers set writer=?, contents=? where answerId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, answer.getWriter());
            pstmt.setString(2, answer.getContents());
            pstmt.setObject(3, answer.getAnswerId());
        });
    }
    public List<Answer> findAll() throws SQLException{
        String sql = "SELECT * FROM ANSWERS";
        return jdbcTemplate.query(sql,
                rs -> new Answer(
                        rs.getInt("answerId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("questionId"))
        );
    }

    public Answer findByAnswerId(int answerId) throws SQLException {
        String sql = "SELECT * FROM ANSWERS WHERE answerId=?";
        return jdbcTemplate.queryForObject(sql,
                rs -> new Answer(
                        rs.getInt("answerId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("questionId")),
                pstmt -> pstmt.setObject(1, answerId));

    }

    public List<Answer> findAllByquestionId(int questionId) throws SQLException {
        String sql = "SELECT * FROM ANSWERS WHERE questionId=?";
        return jdbcTemplate.query(sql,
                rs -> new Answer(
                        rs.getInt("answerId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("questionId")),
                pstmt -> pstmt.setObject(1, questionId));

    }
}
