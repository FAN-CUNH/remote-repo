package com.fch.dao;

import com.fch.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @packageName com.fch.dao
 * @ClassName BookDao
 * @Description 数据层
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:52
 * @Version 1.0
 */
public interface BookDao {
    @Insert("insert into practice_db.book values (null, #{bookName}, #{bookType}, #{description})")
    /*@Results({
            @Result(column = "book_name", property = "bookName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_type", property = "bookType", jdbcType = JdbcType.VARCHAR),
    })*/
    boolean addBook(Book book);

    @Delete("delete from practice_db.book where book_id = #{bookId}")
    /*@Results(@Result(column = "book_id", property = "bookId", jdbcType = JdbcType.INTEGER, id = true))*/
    boolean deleteBook(Integer bookId);

    @Update("update practice_db.book set book_name = #{bookName}, book_type = #{bookType}, description = #{description} where book_id = #{bookId}")
    /*@Results({
            @Result(column = "book_name", property = "bookName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_type", property = "bookType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_id", property = "bookId", jdbcType = JdbcType.INTEGER, id = true)
    })*/
    boolean updateBook(Book book);

    @Select("select * from practice_db.book where book_id = #{bookId}")
    /*@Results({
            @Result(column = "book_name", property = "bookName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_type", property = "bookType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_id", property = "bookId", jdbcType = JdbcType.INTEGER, id = true)
    })*/
    Book getBook(Integer bookId);

    @Select("select * from practice_db.book")
    /*@Results({
            @Result(column = "book_name", property = "bookName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_type", property = "bookType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "book_id", property = "bookId", jdbcType = JdbcType.INTEGER, id = true)
    })*/
    List<Book> getBooks();
}
