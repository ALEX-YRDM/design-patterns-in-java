package top.stackpop.chain;

import org.junit.Test;

public class ChainTest {
    @Test
    public void test(){
        RequestHandler auth = new AuthHandler();
        RequestHandler limiter = new RateLimitHandler(2);
        RequestHandler log = new LoggerHandler();

        auth.setNext(limiter).setNext(log);

        OrderService orderService = new OrderService();
        RequestContext ok = new RequestContext("/api/order", "Bearer token-123", "192.168.0.10");
        RequestContext noToken = new RequestContext("/api/order", null, "192.168.0.20");
        RequestContext flood = new RequestContext("/api/order", "Bearer token-999", "192.168.0.30");

        System.out.println("=== 正常请求 ===");
        if (auth.handle(ok)) {
            orderService.placeOrder(ok);
        }

        System.out.println("\n=== 无 Token 请求 ===");
        if (auth.handle(noToken)) {
            orderService.placeOrder(noToken);
        }

        System.out.println("\n=== 限流触发 ===");
        for(int i=0;i<5;i++){
            if (auth.handle(flood)) {
                orderService.placeOrder(flood);
            }
        }
        
        
    }

}
