package service;

import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-10:49 PM
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int createUser(User user) {
        return userMapper.createUser(user);
    }

    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }


}
