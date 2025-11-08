package top.stackpop.facade;

import org.junit.Test;

public class OrderFacadeTest {
/**
 * 外观模式通过提供单一入口，屏蔽底层复杂流程，使客户端调用简洁、稳定；
 */
    @Test
    public void testPlaceOrderSuccess() {
        OrderFacade facade = new OrderFacade();
        boolean success = facade.placeOrder(
                "user-123",
                "sku-001",
                2,
                39900,
                "COUPON-2025",
                "上海市浦东新区世纪大道 1 号"
        );
        System.out.println("下单结果：" + success);
    }

    @Test
    public void testPlaceOrderFailBecauseStock() {
        OrderFacade facade = new OrderFacade();
        boolean success = facade.placeOrder(
                "user-123",
                "sku-001",
                0,
                39900,
                "COUPON-2025",
                "上海市浦东新区世纪大道 1 号"
        );
        System.out.println("下单结果：" + success);
    }
}

