package top.stackpop.factory.method;

public class SMSNotification implements Notification{

    @Override
    public void send(String msg) {
        System.out.println("send MSM msg"+msg);
        
    }
    
}
