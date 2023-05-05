package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    private JdbcTemplate<Question> jdbcTemplate = new JdbcTemplate();

    public Question insert(Question question) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();

        String sql = "insert into QUESTIONS(writer, title, contents, createdDate, countOfAnswer) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, question.getWriter());
            pstmt.setString(2, question.getTitle());
            pstmt.setString(3, question.getContents());
            pstmt.setDate(4, question.getCreateDate());
            pstmt.setInt(5, question.getCountOfAnswer());
        }, keyHolder);

        System.out.println(keyHolder.getId());
        return findByQuestionId(keyHolder.getId());
    }

    public void update(Question question) throws SQLException {
        String sql = "update QUESTIONS set title=?, contents=? where questionId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, question.getTitle());
            pstmt.setString(2, question.getContents());
            pstmt.setInt(3, question.getQuestionId());
        });
    }
    public void updateCountOfAnswer(Question question) throws SQLException {
        String sql = "update QUESTIONS set countOfAnswer=? where questionId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setInt(1, question.getCountOfAnswer());
            pstmt.setInt(2, question.getQuestionId());
        });
    }
    public void delete(int questionId) throws SQLException {
        String sql = "delete from QUESTIONS where questionId=?";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setInt(1, questionId);
        });
    }

    public List<Question> findAll() throws SQLException {
        String sql = "SELECT * FROM QUESTIONS";
        return jdbcTemplate.query(sql, rs ->
                new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")
                )
        );
    }

    public Question findByQuestionId(int questionId) throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionId=?";
        return jdbcTemplate.queryForObject(sql,
                rs -> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")
                ),
                pstmt -> pstmt.setInt(1, questionId));
    }
}
