package core.jdbc;

import java.sql.PreparedStatement;

public interface PreparedStatmentSetter {
    void setValues(PreparedStatement pstmt);
}
