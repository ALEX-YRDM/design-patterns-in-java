package top.stackpop.chain;

public class AuthHandler extends RequestHandler{

    @Override
    protected boolean doHandle(RequestContext context) {
        if(context.token() == null ||!context.token().startsWith("Bearer ")){
            System.out.println("[AuthHandler] 认证失败：缺少或非法 Token");
            return false;
        }
        System.out.println("[AuthHandler] 认证通过");
        return true;
    }

    
    
}
