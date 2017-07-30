package model;

import lombok.Data;

/**
 * Created by dolphin on 2/7/2017.
 */
@Data
public class RestApiResponse<T> {

    public RestApiResponse() {

    }

    public RestApiResponse(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     * 附加消息
     */
    private String message;
    /**
     * 状态码
     */
    private int code;
    /**
     * 数据
     */
    private T data;
}
