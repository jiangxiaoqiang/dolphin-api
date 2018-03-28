package service;

import mapper.BookMapper;
import mapper.PublisherMapper;
import mapper.ShelfMapper;
import model.Book;
import model.Publisher;
import model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:32 PM
 */
@Service
public class PublisherService {

    @Autowired
    private PublisherMapper publisherMapper;

    public List<Publisher> getAll() {
        return publisherMapper.getAll();
    }
}
