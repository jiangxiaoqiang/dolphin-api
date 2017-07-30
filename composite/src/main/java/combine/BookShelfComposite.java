package combine;

import mapper.BookMapper;
import mapper.ShelfMapper;
import model.Book;
import model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:46 PM
 */
@Component
public class BookShelfComposite {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ShelfMapper shelfMapper;

    public List<Book> getUserShelfBooks(long userId) {
        List<Shelf> userShelf = shelfMapper.getShelfByUserId(userId);
        if (userShelf == null || userShelf.isEmpty()) {
            return null;
        }
        String ids = userShelf.stream()
                .map(shelf -> shelf.getBookId().toString())
                .collect(Collectors.joining(","));
        return bookMapper.getBooksByIds(ids);
    }

}
