package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Question;
import jwp.model.User;


import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public List<Question> findAll() throws SQLException {
        String sql = "SELECT * FROM QUESTIONS";

        return jdbcTemplate.query(sql, rs -> new Question(
                rs.getInt("questionId"),
                rs.getString("writer"),
                rs.getString("title"),
                rs.getString("contents"),
                rs.getDate("createdDate"),
                rs.getInt("countOfAnswer")));

    }

    public Question insert(Question question) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        jdbcTemplate.update("INSERT INTO QUESTIONS " +
                        "(writer, title, contents, createdDate) " +
                        " VALUES (?, ?, ?, ?)",
                pstmt -> {
                    pstmt.setString(1, question.getWriter());
                    pstmt.setString(2, question.getTitle());
                    pstmt.setString(3, question.getContents());
                    pstmt.setObject(4, question.getCreatedDate());
                });
        return findByQuestionId(keyHolder.getId());
    }

    public Question findByQuestionId(int questionId) throws SQLException {
        return jdbcTemplate.queryForObject("SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionId=?",
                rs -> new Question(rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")),
                pstmt -> pstmt.setObject(1, questionId));
    }




}
