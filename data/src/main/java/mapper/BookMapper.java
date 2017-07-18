package mapper;

import model.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by dolphin on 23/6/2017.
 */
public interface BookMapper {

    Book getBookByISBN(String isbn);

    Book getBookById(Long id);

    List<Book> getBooksByName(String name);
}
