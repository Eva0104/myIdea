package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.BookDAO;
import com.zhuxiaoxue.dao.BooktypeDAO;
import com.zhuxiaoxue.dao.PublisherDAO;
import com.zhuxiaoxue.pojo.Book;
import com.zhuxiaoxue.pojo.Booktype;
import com.zhuxiaoxue.pojo.Publisher;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class BookService {

    @Inject
    private BookDAO bookDAO;

    @Inject
    private BooktypeDAO booktypeDAO;

    @Inject
    private PublisherDAO publisherDAO;


    public List<Book> findAllBook(){
        return bookDAO.findAllBook();
    }

    public void saveBook(Book book) {
        bookDAO.save(book);
    }


    public List<Booktype> findAllBooktype() {
        return booktypeDAO.findAll();
    }

    public List<Publisher> findAllPublisher() {
        return publisherDAO.findAll();
    }

    public Book findBookById(Integer id) {
        return bookDAO.findById(id);
    }

    public void delBookByid(Integer id) {
        bookDAO.delBookByid(id);
    }
}
