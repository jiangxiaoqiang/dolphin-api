package dolphin.api.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import service.BookService;
import model.Book;

/**
 * Created by dolphin on 13/6/2017.
 */
//表明这是一个 Controller
//@Controller

//RestController是一种Rest风格的Controller，可以直接返回对象而不返回视图，返回的对象可以使JSON，XML等
@RestController
public class BookController {

    @Autowired
    @Qualifier(value = "bookService")
    private BookService bookService;

    /**
     * @param isbn
     * @return
     */
    @GetMapping("isbn")
    public Book getBookByISBN(@RequestParam String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        return book;
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("id")
    public Book getBookByISBN(@RequestParam Long id) {
        Book book = bookService.getBookById(id);
        return book;
    }
}
