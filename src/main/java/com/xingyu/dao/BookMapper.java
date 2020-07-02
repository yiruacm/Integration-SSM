package com.xingyu.dao;

import com.xingyu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Created by eason.chen
 * @Date 2020-06-28 17:12
 */
public interface BookMapper {

    int addBook(Books books);

    int deleteBookById(@Param("bookId") int id);

    int updateBook(Books books);

    Books queryBookById(@Param("bookId") int id);

    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName") String bookName);
}
