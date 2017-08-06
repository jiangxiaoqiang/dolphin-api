package exception;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-11:27 AM
 */
public class DolphinBaseException extends RuntimeException{

    private int errCode;
    private String errMsg;
    private Object data;

    public DolphinBaseException(int errCode, String errMsg) {
        this(errCode, errMsg, null);
    }

    public DolphinBaseException(int errCode, String errMsg, Object data) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
