package top.stackpop.chain;

public abstract class RequestHandler {
    
    private RequestHandler next;

    public RequestHandler setNext(RequestHandler next) {
        this.next = next;
        return next;
    }

    public final boolean handle(RequestContext context){
        if(!doHandle(context)){
            return false;
        }
        if(next!=null){
            return next.handle(context);
        }
        return true;
    }

    protected abstract boolean doHandle(RequestContext context);

    
}
