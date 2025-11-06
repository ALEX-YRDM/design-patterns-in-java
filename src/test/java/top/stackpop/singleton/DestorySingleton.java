package top.stackpop.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class DestorySingleton {
    /**
     * 使用反射破坏单例模式
     */
    @Test
    public void testBillPughSingleton(){
        /**
         *  top.stackpop.singleton.BillPughSingleton@16b4a017
            top.stackpop.singleton.BillPughSingleton@8807e25
            false
         */
        BillPughSingleton instance = BillPughSingleton.getInstance();
        BillPughSingleton instance2 = null;
        try{
            @SuppressWarnings("rawtypes")
            Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();
            for(var constructor : constructors){
                constructor.setAccessible(true);
                instance2 = (BillPughSingleton)constructor.newInstance();
                break;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }

    @Test
    public void testDoubleCheckThreadSafeSingleton(){
        /**
         * 输出结果：
         * top.stackpop.singleton.DoubleCheckThreadSafeSingleton@3c679bde
            top.stackpop.singleton.DoubleCheckThreadSafeSingleton@16b4a017
            false
         */
        DoubleCheckThreadSafeSingleton instance = DoubleCheckThreadSafeSingleton.getInstance();
        DoubleCheckThreadSafeSingleton instance2 = null;
        try{
            @SuppressWarnings("rawtypes")
            Constructor[] constructors = DoubleCheckThreadSafeSingleton.class.getDeclaredConstructors();
            for(var constructor : constructors){
                constructor.setAccessible(true);
                instance2 = (DoubleCheckThreadSafeSingleton)constructor.newInstance();
                break;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }

    @Test
    public void testSerializationSingleton() throws FileNotFoundException, IOException, ClassNotFoundException{
        SerializationSingleton instance = SerializationSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instance);

        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializationSingleton instance2 = (SerializationSingleton)in.readObject();
        in.close();
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance==instance2);
    }

    @Test
    public void destorySerializationSingleton() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        SerializationSingleton instance = SerializationSingleton.getInstance();
        SerializationSingleton instance2 = null;
        Constructor[] constructors = SerializationSingleton.class.getDeclaredConstructors();
        for(var c: constructors){
            c.setAccessible(true);
            instance2 = (SerializationSingleton) c.newInstance();
            break;
        }
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance==instance2);
    }

    /*
     * when need to test, open the comment
     */
    @Test
    public void destoryEnumSingleton() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        // EnumSingleton instance = EnumSingleton.INSTANCE;
        // EnumSingleton instance2 = null;
        // Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();
        // for(var c: constructors){
        //     c.setAccessible(true);
        //     instance2 = (EnumSingleton) c.newInstance();
        //     break;
        // }
        // System.out.println(instance.hashCode());
        // System.out.println(instance2.hashCode());
        // System.out.println(instance==instance2);
    }
}
