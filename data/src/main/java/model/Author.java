package model;

import lombok.Data;

import java.util.Date;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-10:43 PM
 */
@Data
public class Author {
    /**
     * 主键
     */
    private Long id;

    /**
     * 作者名字
     */
    private String name;

    /**
     * 国家
     */
    private Integer country;

    private Date addDate;

    private Date updateDate;
}
