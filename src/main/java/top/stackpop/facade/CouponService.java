package top.stackpop.facade;

/**
 * 优惠券子系统。
 */
public class CouponService {

    public boolean validate(String couponCode, String userId) {
        System.out.println("优惠券系统：校验优惠券 " + couponCode + "，用户 " + userId);
        return couponCode != null && !couponCode.isEmpty();
    }

    public void markUsed(String couponCode, String userId) {
        System.out.println("优惠券系统：标记优惠券已使用 " + couponCode + "（用户 " + userId + "）");
    }
}

