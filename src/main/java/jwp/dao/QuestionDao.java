package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public List<Question> findAll() throws SQLException {
        String sql = "SELECT * FROM QUESTIONS";
        return jdbcTemplate.query(sql,
                rs-> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")));
    }

    public Question findByQuestionId(int questionId) throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionId=?";
        return jdbcTemplate.queryForObject(sql,
                rs-> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")),
                pstmt -> pstmt.setInt(1, questionId));
    }

    public Question insert(Question question) throws SQLException {
        String sql = "INSERT INTO QUESTIONS " +
                "(writer, title, contents, createdDate) " +
                " VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new KeyHolder();
        jdbcTemplate.update(sql,
                pstmt -> {
                    pstmt.setString(1, question.getWriter());
                    pstmt.setString(2,question.getTitle());
                    pstmt.setString(3,question.getContents());
                    pstmt.setObject(4,question.getCreatedDate());
                },
                keyHolder);
        return findByQuestionId(keyHolder.getId());
    }

    public void update(Question question) throws SQLException {
        String sql = "UPDATE QUESTIONS SET title=?, contents=? where questionId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setInt(3, question.getQuestionId());
            pstmt.setString(1, question.getTitle());
            pstmt.setString(2, question.getContents());
        });
    }

    public void delete(Question question) throws SQLException{
        String sql = "DELETE FROM QUESTIONS WHERE questionId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setInt(1, question.getQuestionId());
        });
    }
}
