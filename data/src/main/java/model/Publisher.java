package model;

import lombok.Data;

import java.util.Date;

/**
 * Created by hldev on 18-3-28.
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
