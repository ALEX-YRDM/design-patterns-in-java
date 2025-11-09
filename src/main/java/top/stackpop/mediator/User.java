package top.stackpop.mediator;

public abstract class User {
    protected ChatMediator mediator;

    private final String name;

    protected User(String name){
        this.name=name;
    }

    public void setMediator(ChatMediator mediator) {
        this.mediator = mediator;
    }


    public String getName() {
        return name;
    }


    public void send(String msg){
        mediator.broadcast(name, msg);
    }

    public abstract void receive(String from,String msg);
    
}
