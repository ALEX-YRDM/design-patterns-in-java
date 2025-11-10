package top.stackpop.observer;

public class Stock extends StockSubject{

    private final String symbol;

    private double currentPrice;

    public Stock(String symbol, double currentPrice) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public void setPrice(double newPrice){
        if(newPrice!=currentPrice){
            double oldPrice = currentPrice;
            this.currentPrice = newPrice;
            System.out.println("\n[Stock] " + symbol + " 价格变动");
            notifyObservers(new StockPriceEvent(symbol, oldPrice, newPrice));
        }
    }

    public String getSymbol(){
        return symbol;
    }

    public double getCurrentPrice(){return currentPrice;}

    
    
}
