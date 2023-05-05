package jwp.support.context;

import core.jdbc.ConnectionManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    /**
     * 웹 애플리케이션을 시작 시 jwp.sql 파일을 이용하여 데이터베이스를 초기화하고,
     * ConnectionManager 클래스를 이용하여 h2 데이터베이스를 실행하는 등의 초기화 작업 수행 목적
     */

    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        /**
         * jwp.sql문을 실행시켜서 데이터베이스를 초기화
         * ConnectionManager를 이용해 h2 데이터베이스를 실행
         */

        System.out.println("ContextLoaderListener contextInitialized 함수");

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("jwp.sql"));
        ConnectionManager.getDataSource();
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());

        logger.info("Completed Load ServletContext!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}