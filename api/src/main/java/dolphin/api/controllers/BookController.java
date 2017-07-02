package dolphin.api.controllers;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dolphin on 13/6/2017.
 */
//表明这是一个 Controller
@Controller

//RestController是一种Rest风格的Controller，可以直接返回对象而不返回视图，返回的对象可以使JSON，XML等
//@RestController

//使用自动配置，主动添加并解析bean，配置文件等信息
@EnableAutoConfiguration
@RequestMapping("/api/")
public class BookController {
    //设置访问的url
    @RequestMapping("/")
    //表示返回JSON格式的结果，如果前面使用的是@RestController可以不用写
    @ResponseBody
    String home() {
        return "Hello World 发发分为无法lwjfwlfjwe";//返回结果为字符串
    }

    public static void main(String[] args) throws Exception {
        //通过SpringApplication的run()方法启动应用，无需额外的配置其他的文件
        SpringApplication.run(BookController.class, args);
    }
}
