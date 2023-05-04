package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Answer;

import java.sql.SQLException;
import java.util.List;

public class AnswerDao {

    private final JdbcTemplate<Answer> jdbcTemplate = new JdbcTemplate<>();

    public Answer insert(Answer answer) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        String sql = "INSERT INTO ANSWERS" +
                "(writer, contents, createdDate, questionId)" +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, answer.getWriter());
            pstmt.setString(2, answer.getContents());
            pstmt.setDate(3, answer.getCreatedDate());
            pstmt.setInt(4, answer.getQuestionId());
        }, keyHolder);
        System.out.println("keyHolder = " + keyHolder.getId());
        return findById(keyHolder.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM ANSWERS WHERE answerId=?",
                pstmt -> pstmt.setObject(1,id));
    }

    public List<Answer> findAllByQuestionId(int questionId) {
        return jdbcTemplate.query("SELECT * FROM ANSWERS WHERE questionId=? order by answerId",
                pstmt -> pstmt.setObject(1, questionId),
                rs -> new Answer(rs.getInt("answerId"),
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getDate("createdDate")));
    }

    public Answer findById(int answerId) throws SQLException {
        return jdbcTemplate.queryForObject("SELECT answerId, writer, contents, createdDate, questionId FROM ANSWERS WHERE answerId = ?",
                pstmt -> pstmt.setObject(1, answerId),
                rs -> new Answer(rs.getInt("answerId"),
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("contents"),
                        rs.getDate("createdDate")));
    }
}