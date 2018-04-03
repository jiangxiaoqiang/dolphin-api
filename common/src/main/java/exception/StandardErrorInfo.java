package exception;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-11:45 AM
 */
public class StandardErrorInfo {

    public static final int ISBN_NULL_ERROR = 400003;
    public static final String ISBN_NULL_ERROR_MESSAGE = "ISBN编号不能为空";

    public static final int PUBLISHER_NAME_NULL_ERROR = 400004;
    public static final String PUBLISHER_NAME_NULL_ERROR_MESSAGE = "参数非法,出版社名称不能为空";

    public static final int DUPLICATE_DATA_ERROR = 400005;
    public static final String DUPLICATE_DATA_ERROR_MESSAGE = "重复数据";

    public static final int DATA_RELATION_ERROR = 400006;
    public static final String DATA_RELATION_ERROR_MESSAGE = "数据关联异常";
}
