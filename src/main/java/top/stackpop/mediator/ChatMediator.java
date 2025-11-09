package top.stackpop.mediator;

public interface ChatMediator {

    void register(User user);

    void broadcast(String from,String msg);
    
} 
