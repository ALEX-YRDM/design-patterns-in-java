package top.stackpop.observer;

public class SMSStockObserver implements StockObserver{

    private final String phoneNumber;

    public SMSStockObserver(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void onPriceChange(StockPriceEvent event) {

        if(Math.abs(event.getChangePercent())>=3.0){
            System.out.printf("[SMSObserver] 发送短信到 %s：%s 价格大幅波动 %.2f%%%n",
                    phoneNumber, event.getSymbol(), event.getChangePercent());
        }
        
    }

    
    
}
