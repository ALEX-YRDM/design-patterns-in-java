package top.stackpop.chain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimitHandler extends RequestHandler{

    private final Map<String,AtomicInteger> counter = new ConcurrentHashMap<>();

    private final int limit;

    public RateLimitHandler(int limit) {
        this.limit = limit;
    }

    @Override
    protected boolean doHandle(RequestContext context) {
        String key = context.ip();
        counter.putIfAbsent(key, new AtomicInteger());
        int current = counter.get(key).incrementAndGet();
        if(current>limit){
            System.out.println("[RateLimitHandler] 限流触发，IP=" + key);
            return false;
        }
        System.out.println("[RateLimitHandler] 当前计数：" + current + "/" + limit);
        return true;
    }

    
    
}
