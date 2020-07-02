package com.xingyu.service;

import com.xingyu.pojo.Books;

import java.util.List;

/**
 * @Created by eason.chen
 * @Date 2020-06-28 17:27
 */
public interface BookService {

    int addBook(Books books);

    int deleteBookById(int id);

    int updateBook(Books books);

    Books queryBookById(int id);

    List<Books> queryAllBook();

    Books queryByName(String bookName);

}

