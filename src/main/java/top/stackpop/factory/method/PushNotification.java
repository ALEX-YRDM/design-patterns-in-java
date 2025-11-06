package top.stackpop.factory.method;

public class PushNotification  implements Notification{

    @Override
    public void send(String msg) {
        System.out.println("send push msg"+msg);
        
    }
    
    
}
