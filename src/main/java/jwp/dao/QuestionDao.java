package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Question;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class QuestionDao {
    JdbcTemplate<Question> jdbcTemplate = new JdbcTemplate<>();

    public List<Question> findAll() {
        String sql = "SELECT * FROM Questions";

        return jdbcTemplate.query(sql,
                rs -> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getTimestamp("createdDate"),
                        rs.getInt("countOfAnswer")
                ));
    }

    public Question insert(Question question) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        String sql = "INSERT INTO questions(writer,title,contents,createdDate,countOfAnswer) VALUES (?, ?, ?, ?, 0)";
        jdbcTemplate.insert(sql, pstmt -> {
            pstmt.setString(1, question.getWriter());
            pstmt.setString(2, question.getTitle());
            pstmt.setString(3, question.getContents());
            pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));}, keyHolder
        );
        System.out.println(keyHolder.getId());
        return findByQuestionId(keyHolder.getId());
    }


    public Question findByQuestionId(int questionId) throws SQLException {
        String sql = "SELECT * FROM questions WHERE questionId=?";
        return jdbcTemplate.queryForObject(sql,
                pstmt -> pstmt.setInt(1, questionId),
                rs -> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getTimestamp("createdDate"),
                        rs.getInt("countOfAnswer")
                ));
    }
}
