package top.stackpop.facade;

/**
 * 物流子系统。
 */
public class ShippingService {

    public String createShipment(String orderId, String address) {
        String trackingNo = "SF-" + System.currentTimeMillis();
        System.out.println("物流系统：为订单 " + orderId + " 生成运单号 " + trackingNo + "，地址 " + address);
        return trackingNo;
    }
}

