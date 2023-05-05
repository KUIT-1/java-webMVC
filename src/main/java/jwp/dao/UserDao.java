package jwp.dao;

import core.jdbc.ConnectionManager;
import core.jdbc.JdbcTemplate;
import jwp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /**
     * 데이터베이스의 User 테이블에 접근하는 클래스
     **/

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void insert(User user) throws SQLException {

        /**
         * User 객체를 인자로 받아서. 해당 정보를 데이터베이스에 삽입하는 메소드
         */

        String sql= "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,pstmt-> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        });

//        Connection con = null;
//        PreparedStatement pstmt = null;
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, user.getUserId());
//            pstmt.setString(2, user.getPassword());
//            pstmt.setString(3, user.getName());
//            pstmt.setString(4, user.getEmail());
//
//            pstmt.executeUpdate();
//        } finally {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//
//            if (con != null) {
//                con.close();
//            }
//        }
    }

    public void update(User user) throws SQLException {

        /**
         * User 객체를 인자로 받아서, 해당 정보로 데이터베이스의 특정 레코드를 업데이트
         * 구현 필요
         */

        String sql= "update users set password=?, name=?, email=? where userId=?";
        jdbcTemplate.update(sql,pstmt-> {
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserId());
        });

//        Connection con = null;
//        PreparedStatement pstmt = null;
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = "update users set password=?, name=?, email=? where userId=?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, user.getPassword());
//            pstmt.setString(2, user.getName());
//            pstmt.setString(3, user.getEmail());
//            pstmt.setString(4, user.getUserId());
//
//            pstmt.executeUpdate();
//        } finally {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//
//            if (con != null) {
//                con.close();
//            }
//      }
    }

    public List<User> findAll() throws SQLException {
        // TODO 구현 필요함.

        String sql = "SELECT * FROM USERS";
        return jdbcTemplate.query(sql, rs-> {
            return new User(
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("email"));
        });

//        List<User> users = new ArrayList<>();
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = "SELECT * FROM USERS";
//            pstmt = con.prepareStatement(sql);
//
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                User user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"),
//                        rs.getString("email"));
//                users.add(user);
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pstmt != null) {
//                pstmt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
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

//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            con = ConnectionManager.getConnection();
//            String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, userId);
//
//            rs = pstmt.executeQuery();
//
//            User user = null;
//            if (rs.next()) {
//                user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"),
//                        rs.getString("email"));
//            }
//
//            return user;
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pstmt != null) {
//                pstmt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
}