package top.stackpop.facade;

/**
 * 库存子系统，负责锁定与释放商品。
 */
public class InventoryService {

    /**
     * 预占库存。
     *
     * @param sku      商品编码
     * @param quantity 数量
     * @return 是否预占成功
     */
    public boolean reserve(String sku, int quantity) {
        System.out.println("库存系统：锁定商品 " + sku + " 数量 " + quantity);
        return quantity > 0;
    }

    /**
     * 释放库存，占用失败或后续流程异常时调用。
     */
    public void release(String sku, int quantity) {
        System.out.println("库存系统：释放商品 " + sku + " 数量 " + quantity);
    }
}

