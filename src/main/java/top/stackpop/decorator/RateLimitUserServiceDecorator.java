package top.stackpop.decorator;

import java.util.concurrent.Semaphore;

public class RateLimitUserServiceDecorator extends UserServiceDecorator{

    private final Semaphore permits;

    public RateLimitUserServiceDecorator(UserService delegate, int maxConcurrent){
        super(delegate);
        this.permits = new Semaphore(maxConcurrent);
    }

    @Override
    public User getUserById(int id) {
        try{
            if(!permits.tryAcquire()){
                throw new IllegalStateException("超过最大并发请求数");
            }
            return super.getUserById(id);
        }finally{
            permits.release();
        }
    }

    
    
}
