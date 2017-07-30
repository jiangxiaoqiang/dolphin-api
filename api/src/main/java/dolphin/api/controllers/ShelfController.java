package dolphin.api.controllers;

import combine.BookShelfComposite;
import model.Book;
import model.ResponseCode;
import model.RestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("books")
    public RestApiResponse<List<Book>> getUserShelfBooks(long userId) {
        List<Book> userShelfBooks = bookShelfComposite.getUserShelfBooks(userId);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, userShelfBooks);
    }
}
