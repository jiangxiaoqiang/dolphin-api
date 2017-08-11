package dolphinweb.controllers;

import model.ResponseCode;
import model.RestApiResponse;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-10:51 PM
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("reg")
    public RestApiResponse<Integer> getUserShelfBooks(User user) {
        int registResult = userService.createUser(user);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, registResult);
    }

}
