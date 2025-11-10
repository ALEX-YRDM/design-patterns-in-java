package top.stackpop.observer;

public class EmailStockObserver implements StockObserver{

    private final String email;

    private final double alertThreshold;

    public EmailStockObserver(String email, double alertThreshold) {
        this.email = email;
        this.alertThreshold = alertThreshold;
    }

    @Override
    public void onPriceChange(StockPriceEvent event) {
        double changePercent = Math.abs(event.getChangePercent());
        if(changePercent>=alertThreshold){
            String direction = event.getChangePercent() > 0 ? "上涨" : "下跌";
            System.out.printf("[EmailObserver] 发送邮件到 %s：%s %s %.2f%%，当前价格 %.2f%n",
                    email, event.getSymbol(), direction, changePercent, event.getNewPrice());
        }
        
    }

    
    
}
