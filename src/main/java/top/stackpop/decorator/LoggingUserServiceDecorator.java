package top.stackpop.decorator;

public class LoggingUserServiceDecorator extends UserServiceDecorator{


    public LoggingUserServiceDecorator(UserService delegate) {
        super(delegate);
    }

    @Override
    public User getUserById(int id) {
        System.out.println("[日志] 请求 getUserById(" + id + ")");
        User user = super.getUserById(id);
        System.out.println("[日志] 返回结果：" + user);
        return user;
    }

}


