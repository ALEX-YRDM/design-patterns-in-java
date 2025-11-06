package top.stackpop.proxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    
    public static <T> T createTimingProxy(T target){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new UserMapperCglibProxy(target));
        return (T) enhancer.create();
    }
}
