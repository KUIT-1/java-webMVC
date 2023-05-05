package jwp.dao;

import core.jdbc.ConnectionManager;
import core.jdbc.JdbcTemplate;
import core.jdbc.KeyHolder;
import jwp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class UserDao {
    private JdbcTemplate<User> jdbcTemplate = new JdbcTemplate();
    public void insert(User user) throws SQLException {

        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        },null);
    }

    public void update(User user) throws SQLException {
        String sql = "update users set password=?, name=?, email=? where userId=?";

        jdbcTemplate.update(sql, pstmt -> {
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserId());
        }, null);
    }

    public List<User> findAll() throws SQLException {

        // TODO 구현 필요함.
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        return jdbcTemplate.query(sql, rs ->
                new User(rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")));
    }

    public User findByUserId(String userId) throws SQLException {

        String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";

        return jdbcTemplate.queryForObject(sql, rs -> new User(rs.getString("userId"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email")),
                ps -> ps.setString(1, userId));
    }
}