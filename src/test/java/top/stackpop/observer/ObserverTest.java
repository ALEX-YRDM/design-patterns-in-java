package top.stackpop.observer;

import org.junit.Test;

public class ObserverTest {
    
    @Test
    public void test(){
        Stock appleStock = new Stock("AAPL", 150.0);

        StockObserver emailUser1 = new EmailStockObserver("aaaa@example.com", 2.0);
        StockObserver emailUser2 = new EmailStockObserver("bbbb@example.com", 1.5);
        StockObserver smsUser = new SMSStockObserver("13888888888");
        StockObserver appuser = new APPStockObserver("5732");

        appleStock.subscribe(appuser);
        appleStock.subscribe(smsUser);
        appleStock.subscribe(emailUser1);
        appleStock.subscribe(emailUser2);

        System.out.println("\n当前订阅者数量：" + appleStock.getObserverCount());
        System.out.println("\n=== 模拟价格变动 ===");

        appleStock.setPrice(152.50);
        appleStock.setPrice(155.50);
        appleStock.setPrice(148.00);
        appleStock.setPrice(145.00);

        System.out.println("=== 用户 2 取消订阅 ===");
        appleStock.unsubscribe(emailUser2);

        System.out.println("\n当前订阅者数量：" + appleStock.getObserverCount());
        appleStock.setPrice(147.50);  // 上涨 1.72%

    }
}
