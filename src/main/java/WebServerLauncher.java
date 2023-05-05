import org.apache.catalina.startup.Tomcat;


import java.io.File;
import java.util.logging.Logger;

public class WebServerLauncher {

    /**
     * Tomcat을 이용하여 웹 애플리케이션을 실행
     */

    private static final Logger logger = Logger.getLogger(WebServerLauncher.class.getName());

    public static void main(String[] args) throws Exception {

        /**
         * Tomcat 객체를 생성하고 포트를 설정하여 Tomcat 서버를 시작
         * addWepapp()을 사용하여 웹 애플리케이션의 경로와 실제 파일 경로를 설정하고,
         * start()을 이용하여 서버를 실행
         * await()을 이용하여 서버가 종료될 때까지 대기
         */

        String webappDirLocation = "./webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
        logger.info("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
