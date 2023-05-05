package core.jdbc;

import jwp.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {

    public void update(String sql, PreparedStatementSetter pstmtSetter, KeyHolder holder) {
        try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmtSetter.setValues(pstmt);
            pstmt.executeUpdate();

            if(holder == null) return;

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                holder.setId((int) rs.getLong(1));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Generic 형변환
    //User외의 다른 값이 들어오면 자동으로 T로 변환해줌
    public List<T> query(String sql, RowMapper rowMapper) throws SQLException {
        List<T> objects = new ArrayList<>();
        try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                T t = (T) rowMapper.mapRow(rs);
                objects.add(t);
            }
        }
        return objects;
    }

    public T queryForObject(String sql, RowMapper rowMapper, PreparedStatementSetter pstmtSetter) throws SQLException {


        ResultSet rs = null;
        try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmtSetter.setValues(pstmt);

            rs = pstmt.executeQuery();

            T t = null;
            if (rs.next()) {
                t = (T) rowMapper.mapRow(rs);
            }

            return t;
        } finally {
            if (rs != null) rs.close();
        }
    }
}
