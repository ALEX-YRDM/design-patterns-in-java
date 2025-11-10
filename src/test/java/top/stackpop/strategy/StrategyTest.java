package top.stackpop.strategy;

import org.junit.Test;

public class StrategyTest {
    
    @Test
    public void test(){
        long orderAmount = 10000;

        System.out.println("=== 订单金额："+orderAmount + " 分===\n");

        PaymentContext context = new PaymentContext(new AlipayStrategy());
        context.executePayment(orderAmount);

        System.out.println("\n=== 用户切换支付方式 ===\n");
        context.setStrategy(new WeChatpayStrategy());
        context.executePayment(orderAmount);

        System.out.println("\n=== 用户使用信用卡 ===\n");

        // 场景3：用户使用信用卡
        context.setStrategy(new CreditCardStrategy("1234567890123456", "123"));
        context.executePayment(orderAmount);

        System.out.println("\n=== 用户使用余额支付 ===\n");

        // 场景4：用户使用余额（余额充足）
        context.setStrategy(new BalanceStrategy(50000));
        context.executePayment(orderAmount);

        System.out.println("\n=== 余额不足的情况 ===\n");

        // 场景5：余额不足
        context.setStrategy(new BalanceStrategy(5000));
        context.executePayment(orderAmount);
    }
}
