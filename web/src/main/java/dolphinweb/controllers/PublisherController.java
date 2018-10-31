package dolphinweb.controllers;

import combine.BookShelfComposite;
import exception.DolphinValidateException;
import exception.StandardErrorInfo;
import model.Book;
import model.Publisher;
import model.ResponseCode;
import model.RestApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BookService;
import service.PublisherService;
import service.ShelfService;

import java.util.List;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-4:06 PM
 */
@RestController
@RequestMapping("/dolphin/api/dic/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @CrossOrigin
    @GetMapping("/all")
    public RestApiResponse<List<Publisher>> getAll() {
        List<Publisher> publisherList = publisherService.getAll();
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, publisherList);
    }

    @CrossOrigin
    @GetMapping("/match")
    public RestApiResponse<List<Publisher>> getMatch(String publisherName) {
        List<Publisher> publisherList = publisherService.getMatch(publisherName);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, publisherList);
    }

    @CrossOrigin
    @PostMapping("")
    public RestApiResponse<Integer> create(@RequestBody Publisher publisher) {
        if(StringUtils.isBlank(publisher.getName())){
            throw new DolphinValidateException(StandardErrorInfo.PUBLISHER_NAME_NULL_ERROR, StandardErrorInfo.PUBLISHER_NAME_NULL_ERROR_MESSAGE);
        }
        int publisherCreateResult = publisherService.create(publisher);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, publisherCreateResult);
    }
}
