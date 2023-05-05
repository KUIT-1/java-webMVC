package jwp.support.context;

<<<<<<< HEAD
=======
import core.jdbc.ConnectionManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

>>>>>>> f0a8f3d (server 5주차 미션 1-2까지”)
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
<<<<<<< HEAD
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(new ClassPathResource("jwp.sql"));
//        ConnectionManager.getDataSource();
//        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
=======
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("jwp.sql"));
        ConnectionManager.getDataSource();
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
>>>>>>> f0a8f3d (server 5주차 미션 1-2까지”)

        logger.info("Completed Load ServletContext!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}