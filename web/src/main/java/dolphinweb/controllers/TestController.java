package dolphinweb.controllers;

import model.ResponseCode;
import model.RestApiResponse;
import model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dolphin/api/test")
public class TestController {

    @RequestMapping("reg")
    public RestApiResponse<String> test(String id) {
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, "ok");
    }
}
