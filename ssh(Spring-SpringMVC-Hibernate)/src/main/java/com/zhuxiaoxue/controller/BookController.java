package com.zhuxiaoxue.controller;

import com.zhuxiaoxue.pojo.Book;
import com.zhuxiaoxue.pojo.Booktype;
import com.zhuxiaoxue.pojo.Publisher;
import com.zhuxiaoxue.service.BookService;
import com.zhuxiaoxue.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model,
                       @RequestParam(name = "p",required = false,defaultValue = "1")Integer pageNo,
                       HttpServletRequest request){

        Page<Book> page = bookService.findBookByParam(pageNo,request);

        List<Booktype> booktypeList = bookService.findAllBooktype();
        List<Publisher> publisherList = bookService.findAllPublisher();

        model.addAttribute("booktypeList",booktypeList);
        model.addAttribute("publisherList",publisherList);
        model.addAttribute("page",page);
        return "/book/list";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String addBook( Model model){
        List<Booktype> booktypeList = bookService.findAllBooktype();
        List<Publisher> publisherList = bookService.findAllPublisher();

        model.addAttribute("booktypeList",booktypeList);
        model.addAttribute("publisherList",publisherList);
        return "/book/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String addBook(Book book,RedirectAttributes redirectAttributes){
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("message","添加成功");
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}/update",method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id, Model model){

        Book book = bookService.findBookById(id);

        List<Booktype> booktypeList = bookService.findAllBooktype();
        List<Publisher> publisherList = bookService.findAllPublisher();

        model.addAttribute("book",book);
        model.addAttribute("booktypeList",booktypeList);
        model.addAttribute("publisherList",publisherList);
        return "/book/update";
    }

    @RequestMapping(value = "/{id:\\d+}/update",method = RequestMethod.POST)
    public String editBook(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String delBook(@PathVariable Integer id){
        bookService.delBookByid(id);
        return "redirect:/books";
    }
}
