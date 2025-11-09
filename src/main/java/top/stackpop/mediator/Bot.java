package top.stackpop.mediator;

public class Bot extends User{

    public Bot(String name){
        super(name);
    }

    @Override
    public void receive(String from, String msg) {
       
        if(msg.contains("@bot")){
            send("bot收到了召唤!");
        }
        
    }

    
    
}
