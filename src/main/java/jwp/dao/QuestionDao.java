package jwp.dao;

import core.jdbc.JdbcTemplate;
import jwp.model.Question;
import jwp.model.User;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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

    public Question findByQuestionId(String questionId) throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionId=?";
        return jdbcTemplate.queryForObject(sql,
                rs-> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")),
                pstmt -> pstmt.setString(1, questionId));
    }

    public void insert(Question question) throws SQLException {
        String sql = "INSERT INTO QUESTIONS " +
                "(writer, title, contents, createdDate) " +
                " VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                pstmt -> {
                    pstmt.setString(1, question.getWriter());
                    pstmt.setString(2,question.getTitle());
                    pstmt.setString(3,question.getContents());
                    pstmt.setObject(4,question.getCreatedDate());
                });
    }
}
