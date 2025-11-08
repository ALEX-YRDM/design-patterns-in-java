package top.stackpop.facade;

/**
 * 外观类：封装下单流程，对外提供统一接口。
 */
public class OrderFacade {

    private final InventoryService inventoryService;
    private final CouponService couponService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.couponService = new CouponService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    /**
     * 一键下单流程：库存预占 → 优惠券校验 → 支付 → 标记优惠券 → 创建运单 → 通知
     */
    public boolean placeOrder(String userId,
                              String sku,
                              int quantity,
                              long amount,
                              String couponCode,
                              String address) {
        System.out.println("==== OrderFacade：开始处理下单 ====");
        if (!inventoryService.reserve(sku, quantity)) {
            notificationService.notifyFailure(userId, "库存不足");
            return false;
        }

        try {
            if (couponCode != null && !couponCode.isEmpty()) {
                if (!couponService.validate(couponCode, userId)) {
                    throw new IllegalStateException("优惠券校验失败");
                }
            }

            if (!paymentService.pay(userId, amount)) {
                throw new IllegalStateException("支付失败");
            }

            if (couponCode != null && !couponCode.isEmpty()) {
                couponService.markUsed(couponCode, userId);
            }

            String trackingNo = shippingService.createShipment("ORDER-" + System.currentTimeMillis(), address);
            notificationService.notifySuccess(userId, "下单成功，运单号：" + trackingNo);
            System.out.println("==== OrderFacade：下单流程完成 ====");
            return true;

        } catch (Exception ex) {
            System.out.println("OrderFacade：异常回滚 - " + ex.getMessage());
            paymentService.refund(userId, amount);
            inventoryService.release(sku, quantity);
            notificationService.notifyFailure(userId, "下单失败：" + ex.getMessage());
            return false;
        }
    }
}

