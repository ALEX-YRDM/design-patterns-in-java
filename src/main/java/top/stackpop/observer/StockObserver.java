package top.stackpop.observer;

public interface StockObserver {
    
    void onPriceChange(StockPriceEvent event);
}
