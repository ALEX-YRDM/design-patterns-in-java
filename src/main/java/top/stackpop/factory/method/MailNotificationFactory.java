package top.stackpop.factory.method;

public class MailNotificationFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        
        return new EmailNotification();
    }
    
    
}
