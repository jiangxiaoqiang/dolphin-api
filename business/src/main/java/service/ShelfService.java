package service;

import mapper.ShelfMapper;
import model.Book;
import model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Shelf> getShelfByUserId(long userId) {
        return shelfMapper.getShelfByUserId(userId);
    }

    public int addBook(Book book,long userId){
        Shelf shelf=new Shelf();
        shelf.setBookId(book.getId());
        shelf.setUserId(userId);
        shelf.setId(UUID.randomUUID().toString());
        return shelfMapper.createShelf(shelf);
    }
}
