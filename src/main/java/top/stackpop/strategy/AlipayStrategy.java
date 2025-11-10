package top.stackpop.strategy;

public class AlipayStrategy implements PaymentStrategy{

    @Override
    public String getStrategyName() {
        return "Alipay";
    }

    @Override
    public boolean pay(long amount) {
        System.out.println("[支付宝] 调用支付宝 SDK，金额：" + amount + " 分");
        System.out.println("[支付宝] 跳转到支付宝支付页面...");
        // 模拟支付处理
        return amount > 0;
    }

    
    
}
