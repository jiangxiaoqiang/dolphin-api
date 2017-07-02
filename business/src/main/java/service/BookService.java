package service;

import mapper.BookMapper;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

/**
 * Created by dolphin on 23/6/2017.
 */
@Service("bookService")
public class BookService {

    @Autowired
    public BookMapper bookMapper;

    public Book getBookByISBN(String isbn){
        return bookMapper.getBookByISBN(isbn);
    }

    public Book getBookById(Long id){
        return bookMapper.getBookById(id);
    }
}
