package top.stackpop.template;

public class VirtualOrderProcessor extends AbstractOrderProcessor{

    @Override
    protected void validate(String orderId) {
        System.out.println("虚拟商品校验：账号合法、库存或授权码可用");
    }

    @Override
    protected void doPayment(String orderId) {
        System.out.println("虚拟商品支付：支持余额或第三方");
    }

    @Override
    protected void deliver(String orderId) {
        System.out.println("虚拟商品交付：发送兑换码 / 激活账户");
    }

    @Override
    protected void afterProcess(String orderId) {
        System.out.println("虚拟商品收尾：发送电子发票、立即生效通知");
    }
    
}
