package top.stackpop.decorator;

public class UserServiceImpl implements UserService{

    @Override
    public User getUserById(int id) {
        System.out.println("UserServiceImpl：查询数据库 id = " + id);
        return new User(id, "user" + id, "user" + id + "@example.com");
    }

    
    
}
