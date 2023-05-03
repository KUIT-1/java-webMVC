package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.Answer;
import jwp.model.Question;

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
}
