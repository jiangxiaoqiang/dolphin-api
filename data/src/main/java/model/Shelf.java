package model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:16 PM
 */
@Data
public class Shelf implements Serializable{

    private Long id;

    /**
     * 对外暴露
     */
    private String uuid;

    @NotEmpty(message="书ID不能为空")
    private Long bookId;

    /**
     * 存储ISBN
     * 书架的书不会因为ID的变化失去关联关系
     */
    private String isbn;

    /**
     * 存放位置
     */
    private String store_area;

    @NotEmpty(message="用户ID不能为空")
    private Long userId;

    private Date addDate;

    private Date updateDate;

    /**
     * 1.正常
     * -1.删除
     */
    private Integer state;
}
