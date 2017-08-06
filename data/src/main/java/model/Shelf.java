package model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-07-30-1:16 PM
 */
@Data
public class Shelf implements Serializable{
    private String id;
    private Long bookId;
    private Long userId;
    private LocalDateTime addDate;
    private LocalDateTime updateDate;
    private Integer state;
}
