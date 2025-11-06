package top.stackpop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserMapperJDKProxy implements InvocationHandler{

    private final Object target;

    
    public UserMapperJDKProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName = method.getName();
        String argsStr = formatArgs(args);
        System.out.println("[耗时统计] 开始执行 " + methodName + "(" + argsStr + ")");
        try{
            Object result = method.invoke(target, args);
            long endTime = System.currentTimeMillis();
            long duration = endTime-startTime;
            System.out.println("[耗时统计] " + methodName + "(" + argsStr + ") 执行完成，耗时: " + duration + "ms");
            
            return result;
        }catch(Exception e){
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("[耗时统计] " + methodName + "(" + argsStr + ") 执行异常，耗时: " + duration + "ms");
            throw e;
        }
    }
    
     /**
     * 格式化参数，用于日志输出
     */
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
