package top.stackpop.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class StockSubject {
    
    private final List<StockObserver> observers = new ArrayList<>();

    public void subscribe(StockObserver observer){
        observers.add(observer);
        System.out.println("新增订阅者：" + observer.getClass().getSimpleName());
    }

    public void unsubscribe(StockObserver observer){
        observers.remove(observer);
        System.out.println("移除订阅者: "+ observer.getClass().getSimpleName());
    }

    protected void notifyObservers(StockPriceEvent event){
        for(var observer:observers){
            observer.onPriceChange(event);
        }
    }

    public int getObserverCount() {
        return observers.size();
    }
}
