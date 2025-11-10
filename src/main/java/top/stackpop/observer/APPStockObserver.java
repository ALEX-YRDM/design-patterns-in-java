package top.stackpop.observer;

public class APPStockObserver implements StockObserver{

    private final String userId;

    public APPStockObserver(String userId) {
        this.userId = userId;
    }

    @Override
    public void onPriceChange(StockPriceEvent event) {
        String trend = event.getChangePercent() >0 ?  "📈" : "📉";

        System.out.printf("[AppPushObserver] 推送通知给用户 %s：%s %s %.2f -> %.2f (%.2f%%)%n",
        userId, event.getSymbol(), trend, event.getOldPrice(), event.getNewPrice(), event.getChangePercent());

        
    }

    
    
}
