package core.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {  //동작을 받아들여주는 함수형 인터페이스
    void setValues(PreparedStatement pstmt) throws SQLException;
}
