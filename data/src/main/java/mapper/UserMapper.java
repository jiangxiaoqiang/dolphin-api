package mapper;

import model.User;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-10:46 PM
 */
public interface UserMapper {
    public default int createUser(User user) {
        return 0;
    }

    User getUserById();

    User getUserByName(String userName);
}
