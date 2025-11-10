package top.stackpop.observer;

public class StockPriceEvent {
    
    private final String symbol;
    private final double oldPrice;
    private final double newPrice;
    private final double changePercent;
    public StockPriceEvent(String symbol, double oldPrice, double newPrice) {
        this.symbol = symbol;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.changePercent = (newPrice-oldPrice)/oldPrice*100;
    }
    public String getSymbol() {
        return symbol;
    }
    public double getOldPrice() {
        return oldPrice;
    }
    public double getNewPrice() {
        return newPrice;
    }
    public double getChangePercent() {
        return changePercent;
    }
    @Override
    public String toString() {
        return "StockPriceEvent [symbol=" + symbol + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice
                + ", changePercent=" + changePercent + "]";
    }

    

    
}
