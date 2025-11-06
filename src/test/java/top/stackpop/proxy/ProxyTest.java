package top.stackpop.proxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void testStaticProxy(){
        System.out.println("========== 静态代理方式 ==========");
        
        // 创建真实对象
        UserMapper realDao = new UserMapperImpl();
        
        // 创建代理对象（添加耗时统计）
        UserMapper proxyDao = new UserMapperStaticProxy(realDao);
        
        // 使用代理对象执行数据库操作
        System.out.println("\n1. 查询用户ID=1:");
        User user1 = proxyDao.findById(1);
        System.out.println("   结果: " + user1);
        
        System.out.println("\n2. 查询用户名='admin':");
        User user2 = proxyDao.findByUsername("admin");
        System.out.println("   结果: " + user2);
        
        System.out.println("\n3. 保存新用户:");
        User newUser = new User(100, "newuser", "newuser@example.com");
        proxyDao.save(newUser);
        
        System.out.println("\n4. 更新用户:");
        newUser.setEmail("updated@example.com");
        proxyDao.update(newUser);
        
        System.out.println("\n5. 删除用户:");
        proxyDao.delete(100);
    }
    

    @Test
    public void testJDKProxy(){
        UserMapper userDao = new UserMapperImpl();

        UserMapper proxyDao = JDKProxyFactory.createTimingProxy(userDao);

        // 使用代理对象执行数据库操作
        System.out.println("\n1. 查询用户ID=1:");
        User user1 = proxyDao.findById(1);
        System.out.println("   结果: " + user1);
        
        System.out.println("\n2. 查询用户名='admin':");
        User user2 = proxyDao.findByUsername("admin");
        System.out.println("   结果: " + user2);
        
        System.out.println("\n3. 保存新用户:");
        User newUser = new User(200, "dynamicuser", "dynamic@example.com");
        proxyDao.save(newUser);
        
        System.out.println("\n4. 更新用户:");
        newUser.setEmail("updated@example.com");
        proxyDao.update(newUser);
        
        System.out.println("\n5. 删除用户:");
        proxyDao.delete(200);
    }
    /**
    *    mvn test -Dtest=ProxyTest#testCglibProxy
        use this command do this test
    */
    @Test
    public void testCglibProxy(){
        
        UserMapperImpl real = new UserMapperImpl();
        UserMapperImpl proxy = CglibProxyFactory.createTimingProxy(real);
        System.out.println("\n1. 查询用户ID=1:");
        User user1 = proxy.findById(1);
        System.out.println("   结果: " + user1);

        System.out.println("\n2. 查询用户名='admin':");
        User user2 = proxy.findByUsername("admin");
        System.out.println("   结果: " + user2);

        System.out.println("\n3. 保存新用户:");
        User newUser = new User(300, "cglibuser", "cglib@example.com");
        proxy.save(newUser);

        System.out.println("\n4. 更新用户:");
        newUser.setEmail("updated@example.com");
        proxy.update(newUser);

        System.out.println("\n5. 删除用户:");
        proxy.delete(300);
    }

    @Test
    public void testCglibProxyNoInterface(){
        System.out.println("========== CGLIB 动态代理（无接口类） ==========");
        NoInterfaceMapper real = new NoInterfaceMapper();
        NoInterfaceMapper proxy = CglibProxyFactory.createTimingProxy(real);

        System.out.println("\n1. 加载用户ID=10:");
        User user = proxy.loadById(10);
        System.out.println("   结果: " + user);

        System.out.println("\n2. 持久化用户:");
        proxy.persist(new User(10, "noif", "noif@example.com"));
    }
}
