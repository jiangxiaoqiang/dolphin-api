package exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-11:32 AM
 */
public class DolphinDataRelationException extends DolphinBaseException {

    public static final int ERR_CODE = 400003;

    public static final String MESSAGE = "数据关联异常";

    public DolphinDataRelationException(BindingResult result) {
        this(ERR_CODE, result, MESSAGE);
    }

    public DolphinDataRelationException(int errCode, String errMsg) {
        super(errCode, errMsg);
    }

    public DolphinDataRelationException(int errCode, Object obj) {
        super(errCode, null, obj);
    }

    public DolphinDataRelationException(int errCode, BindingResult result, String errMsg) {
        super(errCode, errMsg);
        List<FieldError> fieldErrors = result.getFieldErrors();
        HashMap<String, String> map = new HashMap<String, String>();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        super.setData(map);
    }
}
