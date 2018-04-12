package model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

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
    @NotEmpty(message="书名不能为空")
    private String name;

    /**
     * isbn
     */
    @NotEmpty(message="ISBN不能为空")
    private String isbn;

    /**
     * 作者
     */
    @NotEmpty(message="作者不能为空")
    private String author;

    /**
     * 出版社
     */
    @NotEmpty(message="出版社不能为空")
    private String publisher;

    /**
     * 价格
     */
    @NotEmpty(message="价格不能为空")
    private String price;

    /**
     * 是不是初次添加书籍
     * 向书架(Book Shelf)中增加书籍时，如果书库中不存在此书，则是初次添加书籍
     * 将书籍信息添加到书库中，关联信息放入书架中
     * 如果书库中存在此书，则不是初次增加书籍，直接将书库中的书与书架关联即可
     */
    private String initial;
}
