import com.zhuxiaoxue.dao.UserDAO;
import com.zhuxiaoxue.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testGetUserDAO(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDao");
        userDAO.sayHello();
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        userService.sayHi();
    }
}
