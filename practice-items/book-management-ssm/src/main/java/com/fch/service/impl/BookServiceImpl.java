package com.fch.service.impl;

import com.fch.dao.BookDao;
import com.fch.domain.Book;
import com.fch.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName BookServiceImpl
 * @Description 业务层实现
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:53
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    /**
     * 数据层对象
     */
    @Resource
    private BookDao bookDao;

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        return bookDao.deleteBook(bookId);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book getBook(Integer bookId) {
        return bookDao.getBook(bookId);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
}
