package top.stackpop.facade;

/**
 * 支付子系统。
 */
public class PaymentService {

    public boolean pay(String userId, long amount) {
        System.out.println("支付系统：扣款用户 " + userId + " 金额 " + amount);
        return amount >= 0;
    }

    public void refund(String userId, long amount) {
        System.out.println("支付系统：退款用户 " + userId + " 金额 " + amount);
    }
}

