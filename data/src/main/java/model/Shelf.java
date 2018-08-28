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

    private String id;

    @NotEmpty(message="书ID不能为空")
    private Long bookId;

    @NotEmpty(message="用户ID不能为空")
    private Long userId;

    private Date addDate;

    private Date updateDate;
    private Integer state;
}
