package top.stackpop.strategy;

public class BalanceStrategy implements PaymentStrategy{

    private final long userBalance;

    

    public BalanceStrategy(long userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String getStrategyName() {
        // TODO Auto-generated method stub
        return "余额支付";
    }

    @Override
    public boolean pay(long amount) {
        if (userBalance < amount) {
            System.out.println("[余额支付] 余额不足，当前余额：" + userBalance + " 分，需要：" + amount + " 分");
            return false;
        }
        System.out.println("[余额支付] 从账户余额扣款，金额：" + amount + " 分，剩余余额：" + (userBalance - amount) + " 分");
        return true;
    }

    
}
