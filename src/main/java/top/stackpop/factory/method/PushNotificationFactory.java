package top.stackpop.factory.method;


public class PushNotificationFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        // TODO Auto-generated method stub
        return new PushNotification();
    }
    
}
