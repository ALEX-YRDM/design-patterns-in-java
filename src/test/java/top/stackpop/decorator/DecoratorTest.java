package top.stackpop.decorator;

import org.junit.Test;

public class DecoratorTest {
    
    @Test
    public void test(){
        UserService base = new UserServiceImpl();
        
        UserService pro = new RateLimitUserServiceDecorator(new CachingUserServiceDecorator(new LoggingUserServiceDecorator(base)), 2);

        System.out.println("第一次获取 id=1");
        pro.getUserById(1);

        System.out.println("\n第二次获取 id=1（走缓存）");
        pro.getUserById(1);

        System.out.println("\n获取 id=2");
        pro.getUserById(2);
    }
}
