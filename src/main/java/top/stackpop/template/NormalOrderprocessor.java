package top.stackpop.template;

public class NormalOrderprocessor extends AbstractOrderProcessor{

    @Override
    protected void validate(String orderId) {
        System.out.println("普通订单校验：库存、用户状态");
    }

    @Override
    protected void doPayment(String orderId) {
        System.out.println("普通订单支付：调用快捷支付");
    }

    @Override
    protected void deliver(String orderId) {
        System.out.println("普通订单发货：仓库打包 -> 快递发出");
    }

    
    
}
