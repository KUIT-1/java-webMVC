package core.jdbc;

import jwp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    public void update(String sql,PreparedStatementSetter pstmtSetter) throws SQLException {
        try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmtSetter.setValues(pstmt);

            pstmt.executeUpdate();
        }
    }

    public <T> List<T> query(String sql,RowMapper<T> rowMapper) throws SQLException {
        // TODO 구현 필요함.
        List<T> objects = new ArrayList<>();
        try (Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                T object = rowMapper.mapRow(rs);
                objects.add(object);
            }
        }
        return objects;
    }

    public <T> T queryForObject(String sql,RowMapper<T> rowMapper,PreparedStatementSetter pstmtSetter) throws SQLException {

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmtSetter.setValues(pstmt);
            rs = pstmt.executeQuery();

            T object = null;
            if (rs.next()) {
                object=rowMapper.mapRow(rs);
            }

            return object;
        } finally {
            if (rs != null) {
                rs.close();
            }

        }
    }

}
