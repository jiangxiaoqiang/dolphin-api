package service;

import mapper.ShelfMapper;
import model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
