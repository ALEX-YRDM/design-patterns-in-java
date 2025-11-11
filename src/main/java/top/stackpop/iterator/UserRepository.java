package top.stackpop.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserRepository {
    
    private final List<User> data;

    public UserRepository(int total){
        this.data = new ArrayList<>(total);
        IntStream.rangeClosed(1,total).forEach(
            i-> data.add(new User(i, "user-"+i))
        );
    }

    public List<User> findPage(int pageNo, int pageSize){
        int from = (pageNo-1)*pageSize;

        if(from >=data.size()) return List.of();

        int to = Math.min(from+pageSize, data.size());

        return data.subList(from, to);
    }
}
