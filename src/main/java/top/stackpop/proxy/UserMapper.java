package top.stackpop.proxy;

public interface UserMapper {
    
    User findById(int id);

    User findByUsername(String username);

    void save(User user);

    void delete(int id);

    void update(User user);
}
