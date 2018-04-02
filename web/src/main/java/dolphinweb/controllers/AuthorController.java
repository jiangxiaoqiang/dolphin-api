package dolphinweb.controllers;

import model.Author;
import model.ResponseCode;
import model.RestApiResponse;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AuthorService;
import service.UserService;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-10:51 PM
 */
@RestController
@RequestMapping("/dolphin/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @CrossOrigin
    @PostMapping()
    public RestApiResponse<Integer> addAuthor(@RequestBody Author author) {
        int addResult = authorService.create(author);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, addResult);
    }

}
