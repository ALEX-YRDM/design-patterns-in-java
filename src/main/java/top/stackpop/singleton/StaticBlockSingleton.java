package top.stackpop.singleton;

public class StaticBlockSingleton {
    /**
     * 静态代码块初始化，和饿汉一样
     */
    private static final StaticBlockSingleton instance;

    static{
        try{
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private StaticBlockSingleton(){}

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
