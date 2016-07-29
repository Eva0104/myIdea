package com.zhuxiaoxue.service;

import com.zhuxiaoxue.dao.BookDAO;
import com.zhuxiaoxue.dao.BooktypeDAO;
import com.zhuxiaoxue.dao.PublisherDAO;
import com.zhuxiaoxue.pojo.Book;
import com.zhuxiaoxue.pojo.Booktype;
import com.zhuxiaoxue.pojo.Publisher;
import com.zhuxiaoxue.util.Page;
import com.zhuxiaoxue.util.SearchParam;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
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
        return bookDAO.findAll();
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
        bookDAO.delete(id);
    }

    public Page<Book> findBookByPage(Integer pageNo) {
        return bookDAO.findByPage(pageNo,5);
    }

    public Page<Book> findBookByParam(Integer pageNo,HttpServletRequest request) {
        List<SearchParam> searchParamList = SearchParam.getSearchParam(request);
        return bookDAO.findByParams(pageNo,5,searchParamList);
    }
}
