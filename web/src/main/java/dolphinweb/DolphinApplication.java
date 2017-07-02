package dolphinweb;

import dolphin.api.controllers.BookController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import service.BookService;

/**
 * Created by dolphin on 23/6/2017.
 */
@ComponentScan(basePackages = {"dolphin.api.controllers","service","mapper","dolphinweb.config"})
@EnableCaching
@MapperScan("mapper")
@EnableConfigurationProperties(DataSourceConfig.class)
@SpringBootApplication
public class DolphinApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(DolphinApplication.class);
        app.addListeners(new ApplicationPidFileWriter("app.pid"));
        app.run(args);
        //通过SpringApplication的run()方法启动应用，无需额外的配置其他的文件
        //SpringApplication.run(BookController.class, args);
    }
}
