package dolphinweb.controllers;

import combine.BookShelfComposite;
import exception.DolphinValidateException;
import exception.StandardErrorInfo;
import model.Book;
import model.ResponseCode;
import model.RestApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BookService;
import service.ShelfService;

import java.util.List;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-4:06 PM
 */
@RestController
@RequestMapping("/api/user/shelf")
public class ShelfController {

    @Autowired
    private BookShelfComposite bookShelfComposite;

    @Autowired
    private ShelfService shelfService;

    @Autowired
    private BookService bookService;

    @RequestMapping("books")
    public RestApiResponse<List<Book>> getUserShelfBooks(long userId) {
        List<Book> userShelfBooks = bookShelfComposite.getUserShelfBooks(userId);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, userShelfBooks);
    }

    @RequestMapping("add")
    public RestApiResponse<Integer> addShelfBook(Book book) {
        if (StringUtils.isBlank(book.getIsbn())) {
            throw new DolphinValidateException(StandardErrorInfo.ISBN_NULL_ERROR, StandardErrorInfo.ISBN_NULL_ERROR_MESSAGE);
        }

        /**
         * 已经存在书籍
         * 直接添加书籍与用户的关联关系
         */
        Book repoBook = bookService.getBookByISBN(book.getIsbn());
        if (repoBook == null) {
            /**
             * 不存在书籍
             * 向库中添加书籍
             */
            bookService.createBook(book);
        }
        int result = shelfService.addBook(book, 1);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, result);
    }
}
