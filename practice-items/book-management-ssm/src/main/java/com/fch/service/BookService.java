package com.fch.service;

import com.fch.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName BookService
 * @Description 业务层接口
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:53
 * @Version 1.0
 */

@Transactional
public interface BookService {
    /**
     * 添加书籍
     *
     * @param book 请求参数 书本信息载体
     * @return 返回添加书本状态
     */
    boolean addBook(Book book);

    /**
     * 通过书籍id删除书本
     *
     * @param bookId 书本id
     * @return 返回删除书本状态
     */
    boolean deleteBook(Integer bookId);

    /**
     * 更新书籍
     *
     * @param book 请求参数 书本信息载体
     * @return 返回更新书本状态
     */
    boolean updateBook(Book book);

    /**
     * 通过bookId查询书本信息
     *
     * @param bookId 书本id
     * @return 返回书本对象
     */
    Book getBook(Integer bookId);

    /**
     * 查询所有书本对象
     *
     * @return 返回书本集合
     */
    List<Book> getBooks();
}
