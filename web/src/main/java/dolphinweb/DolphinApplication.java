package dolphinweb;

import model.Book;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dolphin on 23/6/2017.
 */
@ComponentScan(basePackages = {
        "dolphinweb.controllers",
        "service",
        "mapper",
        "dolphinweb.config",
        "combine"})
@EnableCaching
@MapperScan("mapper")
@EnableConfigurationProperties(DataSourceConfig.class)
@SpringBootApplication
public class DolphinApplication {
    public static void main(String[] args) throws Exception {
        Book book1 = new Book();
        book1.setId((long) 1);
        List<Book> bookList = new ArrayList();
        bookList.add(book1);
        long sumId = bookList.stream()
                .mapToLong(Book::getId)
                .sum();


        //SpringApplication app = new SpringApplication(DolphinApplication.class);
        //app.addListeners(new ApplicationPidFileWriter("app.pid"));
        //app.run(args);
    }
}
