package mapper;

import model.Shelf;

import java.util.List;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:23 PM
 */
public interface ShelfMapper {
    List<Shelf> getShelfByUserId(Long userId);

    int createShelf(Shelf shelf);
}
