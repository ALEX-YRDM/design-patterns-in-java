package top.stackpop.chain;

public class LoggerHandler extends RequestHandler{

    @Override
    protected boolean doHandle(RequestContext context) {
        System.out.println("[AuditHandler] 记录审计日志，path=" + context.path() + ", ip=" + context.ip());
        return true;
    }
    
    
}
