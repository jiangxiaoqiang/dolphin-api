package service;

import exception.DolphinValidateException;
import exception.StandardErrorInfo;
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

    public List<Publisher> getMatch(String publisherName) {
        return publisherMapper.getMatch(publisherName);
    }

    /**
     * 添加出版社
     * @param publisher
     * @return
     */
    public int create(Publisher publisher) {
        Publisher dbPublisher = publisherMapper.findPublisherByName(publisher.getName());
        if (dbPublisher == null) {
            publisher.setStatus(1);
            publisher.setAddDate(new Date());
            publisher.setUpdateDate(new Date());
            return publisherMapper.create(publisher);
        } else {
            throw new DolphinValidateException(StandardErrorInfo.DUPLICATE_DATA_ERROR, StandardErrorInfo.DUPLICATE_DATA_ERROR_MESSAGE);
        }
    }
}
