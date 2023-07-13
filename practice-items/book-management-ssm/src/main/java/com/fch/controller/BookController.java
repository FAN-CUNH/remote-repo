package com.fch.controller;

import com.fch.domain.Book;
import com.fch.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName BookController
 * @Description 表现层 处理请求和响应数据
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:50
 * @Version 1.0
 */

@Slf4j
@RestController // REST风格
@RequestMapping("/books") // 二级目录 表名的复数形式
public class BookController {
    /**
     * 业务层对象
     */
    @Resource
    private BookService bookService;

    /**
     * 添加书籍
     *
     * @param book 请求参数 书本信息载体
     * @return 返回添加书本状态
     */
    @PostMapping
    public Result addBook(@RequestBody Book book) {
        log.info("添加书籍参数：book = " + book);
        boolean flag = bookService.addBook(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "添加成功" : "添加失败");
    }

    /**
     * 通过书籍id删除书本
     *
     * @param bookId 书本id
     * @return 返回删除书本状态
     */
    @DeleteMapping("/{bookId}")
    public Result deleteBook(@PathVariable Integer bookId) {
        log.info("删除书本参数：bookId = " + bookId);
        boolean flag = bookService.deleteBook(bookId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功" : "删除失败");
    }

    /**
     * 更新书籍
     *
     * @param book 请求参数 书本信息载体
     * @return 返回更新书本状态
     */
    @PutMapping
    public Result updateBook(@RequestBody Book book) {
        log.info("更新书本参数：book = " + book);
        boolean flag = bookService.updateBook(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "更新成功" : "更新失败");
    }

    /**
     * 通过bookId查询书本信息
     *
     * @param bookId 书本id
     * @return 返回书本对象
     */
    @GetMapping("/{bookId}")
    public Result getBook(@PathVariable Integer bookId) {
        log.info("查询参数：bookId = " + bookId);
        List<Book> books = new ArrayList<>(16);
        Book book = bookService.getBook(bookId);
        if (book != null) {
            books.add(book);
        }
        return new Result(book != null ? Code.GET_OK : Code.GET_ERR, books, book != null ? "查询成功" : "查询失败");
    }

    /**
     * 查询所有书本对象
     *
     * @return 返回书本集合
     */
    @GetMapping
    public Result getBooks() {
        log.info("查询所有");
        List<Book> books = bookService.getBooks();
        return new Result(books != null ? Code.GET_OK : Code.GET_ERR, books, books != null ? "查询成功" : "查询失败");
    }
}
