package com.fch;

import com.fch.config.SpringConfig;
import com.fch.domain.Book;
import com.fch.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @packageName com.fch
 * @ClassName BookServiceTest
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/5 20:28
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    /**
     * 注入service对象
     */
    @Resource
    private BookService bookService;

    @Test
    public void testAddBook() {
        boolean addBook = bookService.addBook(new Book(null, "Java入门到入土", "计算机理论", "程序员到外卖员之间的桥梁"));
        System.out.println("测试添加书本结果：add = " + addBook);
    }

    @Test
    public void testDeleteBook() {
        boolean deleteBook = bookService.deleteBook(12);
        System.out.println("测试删除书本结果deleteBook = " + deleteBook);
    }

    @Test
    public void testGetBook() {
        Book book = bookService.getBook(2);
        System.out.println("测试查询单个对象结果：book = " + book);
    }

    @Test
    public void testGetBooks() {
        List<Book> books = bookService.getBooks();
        System.out.println("测试查询全部书籍结果：books = " + books);
    }
}
