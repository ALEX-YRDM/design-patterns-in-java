package top.stackpop.factory.method;

public abstract class NotificationFactory {
    
    /**
     * 每个产品对应一个工厂
     */
    public abstract Notification createNotification();

    public void sendNotification(String msg){
        Notification n= createNotification();
        n.send(msg);
    }
}
