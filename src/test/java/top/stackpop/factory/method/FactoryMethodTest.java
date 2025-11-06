package top.stackpop.factory.method;

import org.junit.Test;

public class FactoryMethodTest {
    
    @Test
    public void test(){
        Notification emailNotification = new MailNotificationFactory().createNotification();
        emailNotification.send(" click this to register deepseek");

        Notification smsNotification = new SMSNotificationFactory().createNotification();
        smsNotification.send(" login to deepseek phone code is 878869");

        Notification pushNotification = new PushNotificationFactory().createNotification();
        pushNotification.send(" your lover send you a msg");
    }
}
