package model;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author hldev
 * @date 18-3-28
 */
@Data
public class Publisher
{
    private Integer id;
    private String name;

    /**
     * 出版商代码
     */
    private String code;

    /**
     * 出版社所属国家
     */
    private String country;

    private Date addDate;
    private Date updateDate;
    private Integer status;
}
