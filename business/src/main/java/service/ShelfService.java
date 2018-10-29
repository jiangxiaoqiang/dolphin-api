package service;

import mapper.BookMapper;
import mapper.ShelfMapper;
import model.Book;
import model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:32 PM
 */
@Service
public class ShelfService {

    @Autowired
    private ShelfMapper shelfMapper;

    @Autowired
    private BookMapper bookMapper;

    public List<Shelf> getShelfByUserId(long userId) {
        return shelfMapper.getShelfByUserId(userId);
    }

    public int addBook(Book book, long userId) {
        if ("1".equals(book.getInitial())) {
            /**
             * 首次增加，直接往书库中写入书籍信息
             * 暂时不考虑增加审核过程
             */
            bookMapper.createBook(book);
        }
        Shelf shelf = new Shelf();
        shelf.setBookId(book.getId());
        shelf.setUserId(userId);
        shelf.setState(1);
        shelf.setAddDate(new Date());
        shelf.setUpdateDate(new Date());
        return shelfMapper.createShelf(shelf);
    }
}
