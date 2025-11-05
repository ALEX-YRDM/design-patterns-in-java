package top.stackpop.singleton;

public class EagerSingleton {
    /**
     * 饿汉单例
     */
    //实例限定为private static final
    private static final EagerSingleton instance = new EagerSingleton();
    //构造函数为private 禁止外部new
    private EagerSingleton(){}
    //public static获取实例
    public static EagerSingleton getInstance(){
        return instance;
    }
}
