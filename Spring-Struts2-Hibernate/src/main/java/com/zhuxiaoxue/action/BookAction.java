package com.zhuxiaoxue.action;

import com.zhuxiaoxue.pojo.Book;
import com.zhuxiaoxue.pojo.Booktype;
import com.zhuxiaoxue.pojo.Publisher;
import com.zhuxiaoxue.service.BookService;
import com.zhuxiaoxue.util.Page;
import com.zhuxiaoxue.util.SearchParam;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

@Namespace("/book")
public class BookAction extends BaseAction{

    @Inject
    private BookService bookService;

    private List<Book> bookList;
    private List<Booktype> booktypeList;
    private List<Publisher> publisherList;
    private Integer id;
    private Integer p;
    private Page<Book> page;

    private Book book;


    @Action("list")
    @Override
    public String execute() throws Exception {

//        bookList = bookService.findAllBook();
        if(p == null){
            p = 1;
        }

        List<SearchParam> searchParamList = SearchParam.getSearchParam(getHttpRequest());
        page = bookService.findBookByParam(p,searchParamList);
        booktypeList = bookService.findAllBooktype();
        publisherList = bookService.findAllPublisher();

        return SUCCESS;
    }

    @Action("new")
    public String newBook(){
        booktypeList = bookService.findAllBooktype();
        publisherList = bookService.findAllPublisher();
        return SUCCESS;
    }

    @Action(value = "save",results = {
            @Result(type = "redirectAction",
                    params = {"actionName","list","namespace","/book"})})
    public String saveBook(){
        bookService.saveBook(book);
        return SUCCESS;
    }

    @Action("edit")
    public String editBook(){
        book = bookService.findBookById(id);
        booktypeList = bookService.findAllBooktype();
        publisherList = bookService.findAllPublisher();
        return SUCCESS;
    }

    @Action(value = "update",results = {
            @Result(type = "redirectAction",params = {"actionName","list","namespace","/book"})
    })
    public String update(){
        bookService.saveBook(book);
        return SUCCESS;
    }

    @Action(value = "del",results = {
            @Result(type = "redirectAction",params = {"actionName","list","namespace","/book"})
    } )
    public String del(){
        bookService.delBookByid(id);
        return SUCCESS;
    }

    //get set

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Booktype> getBooktypeList() {
        return booktypeList;
    }

    public void setBooktypeList(List<Booktype> booktypeList) {
        this.booktypeList = booktypeList;
    }

    public List<Publisher> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        this.publisherList = publisherList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Page<Book> getPage() {
        return page;
    }

    public void setPage(Page<Book> page) {
        this.page = page;
    }
}
