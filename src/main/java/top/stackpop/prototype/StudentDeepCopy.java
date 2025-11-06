package top.stackpop.prototype;

public class StudentDeepCopy implements Cloneable{
    private String name;

    private int age;

    private Address address;

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

    
    public StudentDeepCopy(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDeepCopy [name=" + name + ", age=" + age + ", address=" + address + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        try {
            StudentDeepCopy cloned = (StudentDeepCopy) super.clone();
            if (this.address != null){
                cloned.address = new Address(this.address.getCity(), this.address.getStreet());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
        
    }

    
}
