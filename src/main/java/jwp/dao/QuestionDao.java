package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import core.jdbc.RowMapper;
import jwp.model.Question;
import jwp.model.User;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    private final JdbcTemplate<Question> jdbcTemplate = new JdbcTemplate<>();

    //1단계 - 1.READ
    public List<Question> findAll() throws SQLException {
        String sql = "SELECT * FROM QUESTION";
        return jdbcTemplate.query(sql,
                rs -> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createDate"),
                        rs.getInt("countOfAnswer")));
    }

    //1단계 - 2.CREATE

    public Question insert(Question question) throws SQLException {

        KeyHolder keyHolder = new KeyHolder(); //얘가 하는 역할이 뭔지?
        String sql = "INSERT INTO QUESTIONS VALUES (?, ?, ?, ?, ?)";       //동작이 아니라 값이 다른거임 -> 파라미터로 값을 받아주기


        jdbcTemplate.update("INSERT INTO QUESTIONS VALUES" + "(writer, title, contents, createdDate)" + "VQLUES (?, ?, ?, ?)",
                pstmt -> {
                    //pstmt.setInt(1, question.getQuestionId());
                    pstmt.setString(1, question.getWriter());
                    pstmt.setString(2, question.getTitle());
                    pstmt.setString(3, question.getContents());
                    pstmt.setDate(4, question.getCreatedDate());
                    //pstmt.setInt(5, question.getCountOfAnswer());
                },
                keyHolder);
        return findByQuestionId(keyHolder.getId());
    }

    public Question findByQuestionId(int questionId) throws SQLException{
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

