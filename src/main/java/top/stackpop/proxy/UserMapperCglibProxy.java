package top.stackpop.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class UserMapperCglibProxy implements MethodInterceptor{
    private final Object target;

    
    public UserMapperCglibProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName=  method.getName();
        String argsStr = formatArgs(args);
        System.out.println("[耗时统计] 开始执行 " + methodName + "(" + argsStr + ")");
        try{
            Object result = proxy.invoke(target, args);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("[耗时统计] " + methodName + "(" + argsStr + ") 执行完成，耗时: " + duration + "ms");
            return result;
        } catch (Throwable t) {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("[耗时统计] " + methodName + "(" + argsStr + ") 执行异常，耗时: " + duration + "ms");
            throw t;
        }
    }

    private String formatArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(args[i]);
        }
        return sb.toString();
    }
    
}
