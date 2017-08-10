package exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-11:32 AM
 */
public class DolphinValidateException extends DolphinBaseException {

    public static final int ERR_CODE = 400002;
    public static final String MESSAGE = "字段校验异常";

    public DolphinValidateException(BindingResult result) {
        this(ERR_CODE, result, MESSAGE);
    }

    public DolphinValidateException(int errCode, String errMsg) {
        super(errCode, errMsg);
    }

    public DolphinValidateException(int errCode, Object obj) {
        super(errCode, null, obj);
    }

    public DolphinValidateException(int errCode, BindingResult result, String errMsg) {
        super(errCode, errMsg);
        List<FieldError> fieldErrors = result.getFieldErrors();
        HashMap<String, String> map = new HashMap<String, String>();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        super.setData(map);
    }
}
