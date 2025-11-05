package top.stackpop.singleton;

public class DoubleCheckThreadSafeSingleton {
    /**
     * 必须使用volatile关闭指令重排
     * 
     * 两阶段检查：
     * 第一段检查：如果实例已经创建，可以极速返回
     * 如果没有创建：假设有2个线程AB进行同步代码块：
     * A拿到了锁，进入内部，发现instance仍为null，即创建并返回
     * 随后B拿到锁，进入内部，发现instance不为null，返回已有的实例，如果没有第二段检查，可能会创建多个instance
     * 
     * 关闭指令重排的原因是：
     * instance = new DoubleCheckSingleton() 并不是原子操作
     * 分为3步：
     * 第一步：分配内存空间
     * 第二部：调用构造函数，初始化对象
     * 第三部：将instance指向分配的内存地址
     * 在开启指令重排时，有可能将3移动到2前面执行
     * 即先将instance指向第一步分配的内存地址，再调用构造函数初始化对象
     */
    private static volatile DoubleCheckThreadSafeSingleton instance;

    private DoubleCheckThreadSafeSingleton(){}

    public static DoubleCheckThreadSafeSingleton getInstance(){
        if(instance == null){
            synchronized(DoubleCheckThreadSafeSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
