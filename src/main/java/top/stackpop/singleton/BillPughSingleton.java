package top.stackpop.singleton;

public class BillPughSingleton {
    /**
     * 使用java虚拟机类加载机制实现线程安全
     * 实现了：
     * 懒加载
     * 线程安全
     * 高性能
     */
    private BillPughSingleton(){}

    /**
     * jvm的类加载是懒惰的 只要没有主动访问SingletonHelper，JVM就不会加载和初始化它
     */
    private static class SingletonHelper{
        // 属于该类的静态初始化操作  JVM保证类的加载是线程安全的
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.instance;
    }
}
