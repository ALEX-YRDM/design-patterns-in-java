package top.stackpop.mediator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator{

    private final List<User> users = new ArrayList<>();

    @Override
    public void broadcast(String from, String msg) {
        String filtered = msg.replaceAll("fuck","****");

        System.out.printf("[%s] %s: %s%n",LocalDateTime.now(),from,filtered);

        for(var user:users){
            if(!user.getName().equals(from)){
                user.receive(from, msg);
            }
        }
        
    }

    @Override
    public void register(User user) {
       
        users.add(user);
        user.setMediator(this);
        
    }

    
    
}
