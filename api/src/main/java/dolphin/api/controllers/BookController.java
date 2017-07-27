package dolphin.api.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import model.ResponseCode;
import model.RestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import service.BookService;
import model.Book;

import java.util.List;

/**
 * Created by dolphin on 13/6/2017.
 */
//表明这是一个 Controller
//@Controller

//RestController是一种Rest风格的Controller，可以直接返回对象而不返回视图，返回的对象可以使JSON，XML等
@RestController
@RequestMapping("/api/book")
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
    @CrossOrigin
    @GetMapping("/{id}")
    public RestApiResponse<Book> getBookByISBN(@PathVariable Long id) {
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setCode(ResponseCode.REQUEST_SUCCESS);
        restApiResponse.setMessage(ResponseCode.REQUEST_SUCCESS_MESSAGE);
        Book book = bookService.getBookById(id);
        restApiResponse.setData(book);
        return restApiResponse;
    }

    @CrossOrigin
    @GetMapping()
    public RestApiResponse<List<Book>> getBooksByName(@RequestParam String name){
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setCode(ResponseCode.REQUEST_SUCCESS);
        restApiResponse.setMessage(ResponseCode.REQUEST_SUCCESS_MESSAGE);
        List<Book> books = bookService.getBooksByName(name);
        restApiResponse.setData(books);
        return restApiResponse;
    }
}
