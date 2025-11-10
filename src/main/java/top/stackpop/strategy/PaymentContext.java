package top.stackpop.strategy;

public class PaymentContext {
    
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    
    public boolean executePayment(long amount){
        if(strategy == null){
            throw new IllegalStateException("payment strategy is null");
        }
        System.out.println("use paymeny method: "+strategy.getStrategyName());
        return strategy.pay(amount);
    
    }

    public String getCurrentStrategy() {
        return strategy != null ? strategy.getStrategyName() : "未设置";
    }
}
