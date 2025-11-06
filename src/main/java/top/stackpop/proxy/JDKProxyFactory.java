package top.stackpop.proxy;

import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    
    @SuppressWarnings("unchecked")
    public static <T> T createTimingProxy(T mapper){
        Class<?>[] interfaces = mapper.getClass().getInterfaces();
        if(interfaces.length ==0 ){
            throw new IllegalArgumentException("目标对象必须至少实现一个接口");
        }
        return (T) Proxy.newProxyInstance(mapper.getClass().getClassLoader(), interfaces, new UserMapperJDKProxy(mapper));
    }
}
