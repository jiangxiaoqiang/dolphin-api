package dolphinweb.controllers;

import model.ResponseCode;
import model.RestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import service.BookService;
import model.Book;
//import service.ScalaBookService;
import sun.rmi.runtime.Log;
import java.util.List;

/**
 * Created by dolphin on 13/6/2017.
 */
@RestController
@RequestMapping("/dolphin/api/book")
public class BookController {

    @Autowired
    @Qualifier(value = "bookService")
    private BookService bookService;

    /*public BookController(ScalaBookService bookServiceScala) {
        this.bookServiceScala = bookServiceScala;
    }*/


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
    public RestApiResponse<List<Book>> getBooksByName(@RequestParam String name) {
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setCode(ResponseCode.REQUEST_SUCCESS);
        restApiResponse.setMessage(ResponseCode.REQUEST_SUCCESS_MESSAGE);
        List<Book> books = bookService.getBooksByName(name);
        restApiResponse.setData(books);
        return restApiResponse;
    }

    @CrossOrigin
    @GetMapping("/all/{id}")
    public RestApiResponse<List<Book>> getAllBooks(@PathVariable Long id) {
        List<Book> books = bookService.getAllBooks(id);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, books);
    }
}
