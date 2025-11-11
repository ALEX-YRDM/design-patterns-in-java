package top.stackpop.iterator;

import org.junit.Test;

public class IteratorTest {
    
    @Test
    public void test(){
        UserRepository repo = new UserRepository(23);
        PagedIterable<User> iterable = new PagedIterable<>(5, repo::findPage);

        for(var u: iterable){
            System.out.println(u);
        }
    }
}
