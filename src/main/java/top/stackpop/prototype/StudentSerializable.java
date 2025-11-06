package top.stackpop.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudentSerializable implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;

    private int age;

    private AddressSerializable address;

    public StudentSerializable(String name, int age, AddressSerializable address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressSerializable getAddress() {
        return address;
    }

    public void setAddress(AddressSerializable address) {
        this.address = address;
    }

    
    public StudentSerializable deepCopy(){
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            StudentSerializable cloned = (StudentSerializable)ois.readObject();
            ois.close();
            return cloned;
        }catch(IOException | ClassNotFoundException e){
            throw new RuntimeException("Deep copy failed", e);
        }
    }

    @Override
    public String toString() {
        return "StudentSerializable [name=" + name + ", age=" + age + ", address=" + address + "]";
    }

    
    
}
