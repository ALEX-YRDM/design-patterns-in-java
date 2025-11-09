package top.stackpop.template;

public class PreSaleOrderProcessor extends AbstractOrderProcessor{

    @Override
    protected void validate(String orderId) {
        System.out.println("预售订单校验：名额、定金支付状态");
    }

    @Override
    protected void doPayment(String orderId) {
        System.out.println("预售订单支付：先扣定金，再约定尾款时间");
    }

    @Override
    protected void deliver(String orderId) {
        System.out.println("预售订单交付：发布尾款提醒，尾款到账后安排发货");
    }
    
}
