package top.stackpop.strategy;

public interface PaymentStrategy {
    
    boolean pay(long amount);

    String getStrategyName();
    
}
