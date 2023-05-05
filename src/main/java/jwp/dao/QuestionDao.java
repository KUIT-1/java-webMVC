package jwp.dao;

import core.jdbc.JdbcTemplate;
import jwp.model.Question;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {

    /**
     * 데이터베이스의 Question 테이블에 접근하는 클래스
     **/

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public Question insert(Question question) throws SQLException {

        /**
         * Question 객체를 인자로 받아서. 해당 정보를 데이터베이스에 삽입하는 메소드
         */

        String sql = "INSERT INTO QUESTIONS VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, question.getWriter());
            pstmt.setString(2, question.getTitle());
            pstmt.setString(3, question.getContents());
            pstmt.setDate(4,question.getCreatedDate());
            pstmt.setInt(5,question.getCountOfAnswer());
        });

        return findById(question.getQuestionId());
    }


    public List<Question> findAll() throws SQLException {

        /**
         * Questions 테이블에서 모든 튜플을 읽어서 Question 타입으로 반환하는 메서드
         */

        String sql = "SELECT * FROM QUESTIONS";
        return jdbcTemplate.query(sql, rs-> {
            return new Question(
                    rs.getInt("questionId"),
                    rs.getString("writer"),
                    rs.getString("title"),
                    rs.getString("contents"),
                    rs.getDate("createdDate"),
                    rs.getInt("countOfAnswer"));
        });

    }

    public Question findById(int id) throws SQLException {
        String sql = "SELECT questionId, writer, title, contents, createdDate, countOfAnswer FROM QUESTIONS WHERE questionid=?";
        return jdbcTemplate.queryForObject(sql,
                rs -> new Question(
                        rs.getInt("questionId"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("createdDate"),
                        rs.getInt("countOfAnswer")),
                pstmt -> pstmt.setInt(1, id));
    }
}
