package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {

    JdbcTemplate<Question> jdbcTemplate = new JdbcTemplate<>();

    public Question insert(Question question) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        String sql = "INSERT INTO QUESTIONS (writer, title, contents, createdDate, countOfAnswer) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, question.getWriter());
            pstmt.setString(2, question.getTitle());
            pstmt.setString(3, question.getContents());
            pstmt.setDate(4, question.getCreatedDate());
            pstmt.setInt(5, question.getCountOfAnswer());
        }, keyHolder);

        return findById(keyHolder.getId());
    }

    public void update(Question q) {
        String sql = "UPDATE QUESTIONS set title=?, contents=? WHERE questionId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, q.getTitle());
            pstmt.setString(2, q.getContents());
            pstmt.setInt(3, q.getQuestionId());
        });
    }

    public List<Question> findAll() {
        String sql = "SELECT * FROM QUESTIONS";

        return jdbcTemplate.query(sql, rs -> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")));
    }


    public Question findById(int id) throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionId=?";
        return jdbcTemplate.queryForObject(sql,
                pstmt -> pstmt.setInt(1, id),
                rs -> new Question(rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")));
    }

    public void updateCountOfAnswer(Question question) {
        String sql = "UPDATE QUESTIONS set countOfAnswer=? WHERE questionId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, String.valueOf(question.getCountOfAnswer()));
            pstmt.setInt(2, question.getQuestionId());
        });
    }
}
