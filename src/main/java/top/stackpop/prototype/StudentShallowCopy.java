package top.stackpop.prototype;

/**
 * 原型模式通过复制现有实例创建新对象，而不是通过构造函数创建。
 */
public class StudentShallowCopy implements Cloneable{
    
    private String name;

    private int age;

    private Address address;
    
    public StudentShallowCopy(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try{
            return (StudentShallowCopy) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return "StudentShallowCopy [name=" + name + ", age=" + age + ", address=" + address + "]";
    }

    

    
}
