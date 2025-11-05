package top.stackpop.singleton;

public class ThreadSafeSingleton {
    /*
     * 直接使用synchronized加在方法上，使得所有线程只能有一个在执行getInatance方法
     * 性能较差
     */
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if (instance==null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
