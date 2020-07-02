package com.xingyu.service;

import com.xingyu.dao.BookMapper;
import com.xingyu.pojo.Books;

import java.util.List;

/**
 * @Created by eason.chen
 * @Date 2020-06-28 17:28
 */

public class BookServiceImpl implements BookService {

    //    service调用dao
    private BookMapper bookMapper;

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }

}
