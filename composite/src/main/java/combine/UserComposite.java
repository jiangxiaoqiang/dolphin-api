package combine;

import mapper.UserMapper;
import model.Book;
import model.Shelf;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import security.PasswordOperation;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserComposite {

    @Autowired
    private UserMapper userMapper;

    public User Login(String userName, String userInputPassword) {
        User user = userMapper.getUserByName(userName);
        if (PasswordOperation.matchPassword(userInputPassword, user.getSalt(), user.getSaltedPassword())) {
            return user;
        }
        return null;
    }
}
