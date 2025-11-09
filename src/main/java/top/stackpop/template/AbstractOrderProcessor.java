package top.stackpop.template;


public abstract class AbstractOrderProcessor {
    
    public final void processOrder(String orderId){
        System.out.println("=== 开始处理订单 "+orderId+"===");
        validate(orderId);
        doPayment(orderId);
        deliver(orderId);
        afterProcess(orderId);
        System.out.println("=== 订单 "+orderId+ " 处理完毕 ===");
    }

    protected abstract void validate(String orderId);

    protected abstract void doPayment(String orderId);

    protected void deliver(String orderId){
        System.out.println("默认交付方式：线下物流发货 orderId=" + orderId);
    }

    protected void afterProcess(String orderId){
        System.out.println("通用收尾操作：记录日志、发送通知");
    }



}
