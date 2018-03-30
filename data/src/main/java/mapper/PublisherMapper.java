package mapper;

import model.Publisher;

import java.util.List;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:23 PM
 */
public interface PublisherMapper {
    List<Publisher> getAll();

    int create(Publisher publisher);

    Publisher findPublisherByName(String name);
}
