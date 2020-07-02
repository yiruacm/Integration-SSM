package com.xingyu.controller;

import com.xingyu.pojo.Books;
import com.xingyu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by eason.chen
 * @Date 2020-06-28 23:08
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdate")
    public String toUpdatePager(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        int i = bookService.updateBook(books);
        if (i>0){
            System.out.println("添加books成功！"+books);
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if (books == null){
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",list);
        return "allBook";
    }

}
