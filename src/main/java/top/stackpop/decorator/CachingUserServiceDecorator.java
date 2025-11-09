package top.stackpop.decorator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachingUserServiceDecorator extends UserServiceDecorator{

    private final Map<Integer,User> cache = new ConcurrentHashMap<>();

    public CachingUserServiceDecorator(UserService delegate){
        super(delegate);
    }

    @Override
    public User getUserById(int id) {
        User cached = cache.get(id);

        if(cached!=null){
            System.out.println("[缓存] 命中 id = " + id);
            return cached;
        }
        User user = super.getUserById(id);
        cache.put(id, user);
        System.out.println("[缓存] 存入 id = " + id);
        return user;
    }
    
    
}
