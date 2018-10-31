package service;

import exception.DolphinValidateException;
import exception.StandardErrorInfo;
import mapper.AuthorMapper;
import mapper.PublisherMapper;
import model.Author;
import model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:32 PM
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    public int create(Author author) {
        author.setAddDate(new Date());
        author.setUpdateDate(new Date());
        author.setCountry(1);
        int result = authorMapper.createAuthor(author);
        return result;
    }
}
