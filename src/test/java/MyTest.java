import com.xingyu.pojo.Books;
import com.xingyu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Created by eason.chen
 * @Date 2020-06-28 23:54
 */
public class MyTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        for (Books books : bookServiceImpl.queryAllBook()){
            System.out.println(books);
        }
    }
}
