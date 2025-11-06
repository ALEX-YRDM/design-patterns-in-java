package top.stackpop.factory.method;

public class SMSNotificationFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        // TODO Auto-generated method stub
        return new SMSNotification();
    }
    
     
}
