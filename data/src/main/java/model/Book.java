package model;

import lombok.Data;

/**
 * Created by dolphin on 23/6/2017.
 */
@Data
public class Book {

    /**
     * 主键
     */
    private Long id;
    /**
     * 书名
     */
    private String name;

    /**
     * isbn
     */
    private String isbn;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publisher;

    /**
     * 价格
     */
    private String price;
}
