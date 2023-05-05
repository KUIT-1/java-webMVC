package core.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
    void setvalues(PreparedStatement pstmt) throws SQLException;
}