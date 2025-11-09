package top.stackpop.mediator;

public class ChatUser extends User{

    public ChatUser(String name){
        super(name);
    }

    @Override
    public void receive(String from, String msg) {
        System.out.println("  -> " + getName() + " 收到来自 " + from + " 的消息: " + msg);
        
    }

    
    
}
