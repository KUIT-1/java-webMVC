package core.jdbc;

import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    public void update(String sql, PreparedStatementSetter pstmtSetter) throws SQLException {
        try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmtSetter.setValues(pstmt);

            pstmt.executeUpdate();
        }
    }

    //Generic 형변환
    //User외의 다른 값이 들어오면 자동으로 T로 변환해줌
    public <T> List<T> query(String sql, RowMapper rowMapper) throws SQLException {
        List<T> objects = new ArrayList<>();
        try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                T t = (T) rowMapper.mapRow(rs);
                objects.add(t);
            }
        }
        return objects;
    }

    public <T> T queryForObject(String sql, RowMapper rowMapper, PreparedStatementSetter pstmtSetter) throws SQLException {


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
