package top.stackpop.factory.method;

public class EmailNotification implements Notification{

    @Override
    public void send(String msg) {
        
        System.out.println("send mail msg"+msg);
        
    }

    
    
}
