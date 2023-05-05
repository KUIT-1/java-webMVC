package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.User;
import java.sql.SQLException;
import java.util.List;
//Dao : Data access object, 데이터에 접근하는 객체
//      repository
public class UserDao {
    private JdbcTemplate <User> jdbcTemplate = new JdbcTemplate<>();

    public void insert(User user) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";       //동작이 아니라 값이 다른거임 -> 파라미터로 값을 받아주기

        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        }, keyHolder);
    }

    public void update(User user) throws SQLException {
        KeyHolder keyHolder = new KeyHolder();
        String sql = "update users set password=?, name=?, email=? where userId=?";

        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserId());
        }, keyHolder);
    }

    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM USERS";

        return jdbcTemplate.query(sql, rs -> new User(
                rs.getString("userId"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email")));
    }

    public User findByUserId(String userId) throws SQLException {
        String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
        return jdbcTemplate.queryForObject(sql,
                rs -> new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")),
                pstmt -> pstmt.setString(1, userId));
    }
}