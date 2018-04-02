package model;

import lombok.Data;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-10:43 PM
 */
@Data
public class User {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    private String salt;

    private String saltedPassword;

    private String password;
}
