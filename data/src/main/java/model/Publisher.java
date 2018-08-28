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
    private String code;
    private Date addDate;
    private Date updateDate;
    private Integer status;
}
