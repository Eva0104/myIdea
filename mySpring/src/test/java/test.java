import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.dao.UserDAOImp;
import com.zhuxiaoxue.dao.UserDAOImp2;
import com.zhuxiaoxue.service.BookService;
import com.zhuxiaoxue.service.UserService;
import org.junit.Test;
import org.omg.CORBA.Object;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testGetUserDAO(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserDAOImp userDAOImp = (UserDAOImp) context.getBean("userDAOImp");
        userDAOImp.save();
    }

    @Test
    public void testUserService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        userService.sayHi();
    }

    @Test
    public void testBookService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.showBook();
    }
}
