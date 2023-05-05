package core.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    /**
     * ConnectionManager
     * h2 데이터베이스에 실제로 연결 및 소스 가져오는 클래스
     * h2 데이터베이스에 연결하기 위한 DataSource 객체를 생성하고,
     * 이를 사용하여 Connection 객체를 얻는 것을 목적으로 함
     **/

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/jwp-basic";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PW = "";

    private static BasicDataSource ds;
    public static DataSource getDataSource() {

        /**
         * 데이터베이스 연결을 관리하기 위한 DataSource 객체를 반환하는 메소드
         * BasicDataSource 객체를 사용하여 H2 데이터베이스 연결하고,
         * 필드에 저장된 드라이버의 클래스 이름, URL, 사용자 이름, 비밀번호를 설정한 후,
         * 설정된 DataSource 객체를 반환
         */

        if (ds == null) {
            ds = new BasicDataSource();
            ds.setDriverClassName(DB_DRIVER);
            ds.setUrl(DB_URL);
            ds.setUsername(DB_USERNAME);
            ds.setPassword(DB_PW);
        }
        return ds;
    }

    public static Connection getConnection() {

        /**
         * 데이터베이스와의 연결을 나타내는 Connection 객체를 반환하는 메소드
         * getDataSource를 불러 DataSource 객체를 가져온 후,
         * getConnection을 호출하여 Connection 객체를 반환한다.
         */

        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
