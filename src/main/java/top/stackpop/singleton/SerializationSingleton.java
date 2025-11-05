package top.stackpop.singleton;

import java.io.Serializable;

public class SerializationSingleton implements Serializable{

    private static final long serialVersionUID = -1L;
    private SerializationSingleton(){}

    private static class SingletonHelper{
        private static final SerializationSingleton instance = new SerializationSingleton();
    }

    public static SerializationSingleton getInstance(){
        return SingletonHelper.instance;
    }
    
    protected Object readResolve(){
        return getInstance();
    }
}
