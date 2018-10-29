package service;

import exception.DolphinDataRelationException;
import exception.StandardErrorInfo;
import mapper.BookMapper;
import mapper.ShelfMapper;
import model.Book;
import model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dolphin on 23/6/2017.
 */
@Service("bookService")
public class BookService {

    @Autowired
    public BookMapper bookMapper;

    @Autowired
    public ShelfMapper shelfMapper;

    public Book getBookByISBN(String isbn) {
        return bookMapper.getBookByISBN(isbn);
    }

    public Book getBookById(Long id) {
        return bookMapper.getBookById(id);
    }

    public int createBook(Book book) {
        return bookMapper.createBook(book);
    }

    public List<Book> getBooksByName(String name) {
        return bookMapper.getBooksByName(name);
    }

    /**
     * 获取书架书籍
     */
    public List<Book> getAllBooks(Long userId) {
        List<Shelf> userShelf = shelfMapper.getShelfByUserId(userId);
        if (!CollectionUtils.isEmpty(userShelf)) {
            List<Long> bookIds = userShelf.stream()
                    .map(item -> item.getBookId())
                    .distinct()
                    .collect(Collectors.toList());
            List<Book> books = bookMapper.getBooksByIdList(bookIds);
            List<Book> shelfResultBook = new ArrayList<>();
            userShelf.forEach((singleUserShelf) -> {
                Book book = books.stream()
                        .filter(bookItem -> singleUserShelf.getBookId().equals(bookItem.getId()))
                        .findFirst()
                        .orElseThrow(() -> new DolphinDataRelationException(StandardErrorInfo.DATA_RELATION_ERROR, StandardErrorInfo.DATA_RELATION_ERROR_MESSAGE));
                shelfResultBook.add(book);
            });

            /**
             * 按照书架的书籍返回
             * 可以允许重复书籍
             **/
            return shelfResultBook;
        }
        return null;
    }

    public List<Book> getBooksByIds(String ids) {
        return getBooksByIds(ids);
    }
}