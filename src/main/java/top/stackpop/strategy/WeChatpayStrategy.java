package top.stackpop.strategy;

public class WeChatpayStrategy implements PaymentStrategy{

    @Override
    public String getStrategyName() {
        return "WeChatPay";
    }

    @Override
    public boolean pay(long amount) {
        System.out.println("[微信支付] 调用微信支付 API，金额：" + amount + " 分");
        System.out.println("[微信支付] 生成支付二维码...");
        // 模拟支付处理
        return amount > 0;
    }

    
    
}
