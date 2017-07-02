package mapper;

import model.Book;
import org.apache.ibatis.annotations.Select;

/**
 * Created by dolphin on 23/6/2017.
 */
public interface BookMapper {
    //@Select("select * from book where isbn=#{isbn}")
    Book getBookByISBN(String isbn);

    Book getBookById(Long id);
}
