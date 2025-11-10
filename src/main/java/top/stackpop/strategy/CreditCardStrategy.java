package top.stackpop.strategy;

public class CreditCardStrategy implements PaymentStrategy{

    private final String cardNumber;

    private final String cvv;

    public CreditCardStrategy(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public String getStrategyName() {
        return "CreditCard";
    }

    @Override
    public boolean pay(long amount) {
        System.out.println("[信用卡] 使用卡号 " + maskCard(cardNumber) + " 支付，金额：" + amount + " 分");
        System.out.println("[信用卡] 验证 CVV，调用银行接口...");
        // 模拟支付处理
        return amount > 0 && cardNumber != null && !cardNumber.isEmpty();
    }

    private String maskCard(String card) {
        if (card == null || card.length() < 4) return "****";
        return "****" + card.substring(card.length() - 4);
    }
    
    
}
