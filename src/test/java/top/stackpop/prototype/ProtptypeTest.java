package top.stackpop.prototype;

import org.junit.Test;

public class ProtptypeTest {
    
    @Test
    public void testShallow() throws CloneNotSupportedException{
        System.out.println("=== 浅拷贝测试 ===");
        Address address = new Address("北京", "中关村大街");
        StudentShallowCopy original = new StudentShallowCopy("张三", 20, address);
        StudentShallowCopy cloned = (StudentShallowCopy) original.clone();

        System.out.println("原始对象: " + original);
        System.out.println("克隆对象: " + cloned);
        System.out.println("是否是同一个对象: " + (original == cloned)); // false

        // 修改原始对象的基本类型
        original.setName("李四");
        original.setAge(25);
        System.out.println("\n修改原始对象的基本类型后:");
        System.out.println("原始对象: " + original);
        System.out.println("克隆对象: " + cloned); // 克隆对象不受影响

        // 修改原始对象的引用类型
        original.getAddress().setCity("上海");
        System.out.println("\n修改原始对象的引用类型后:");
        System.out.println("原始对象: " + original);
        System.out.println("克隆对象: " + cloned); // 克隆对象的address也被修改了！
        System.out.println("address是否是同一个对象: " + (original.getAddress() == cloned.getAddress()));
    }

    @Test
    public void testDeepCopy() throws CloneNotSupportedException{
        System.out.println("=== 深拷贝测试 ===");
        Address address = new Address("北京", "中关村大街");
        StudentDeepCopy original = new StudentDeepCopy("张三", 20, address);
        StudentDeepCopy cloned = (StudentDeepCopy) original.clone();

        System.out.println("原始对象: " + original);
        System.out.println("克隆对象: " + cloned);
        System.out.println("是否是同一个对象: " + (original == cloned)); // false

        // 修改原始对象的引用类型
        original.getAddress().setCity("上海");
        System.out.println("\n修改原始对象的引用类型后:");
        System.out.println("原始对象: " + original);
        System.out.println("克隆对象: " + cloned); // 克隆对象的address不受影响
        System.out.println("address是否是同一个对象: " + (original.getAddress() == cloned.getAddress())); // false
    
    }

    @Test
    public void testSerializable(){
        System.out.println("=== 序列化深拷贝测试 ===");
        AddressSerializable address = new AddressSerializable("北京", "中关村大街");
        StudentSerializable original = new StudentSerializable("张三", 20, address);
        StudentSerializable cloned = original.deepCopy();

        System.out.println("原始对象: " + original);
        System.out.println("克隆对象: " + cloned);
        System.out.println("是否是同一个对象: " + (original == cloned)); // false

        // 修改原始对象的引用类型
        original.getAddress().setCity("上海");
        System.out.println("\n修改原始对象的引用类型后:");
        System.out.println("原始对象: " + original);
        System.out.println("克隆对象: " + cloned); // 克隆对象的address不受影响
        System.out.println("address是否是同一个对象: " + (original.getAddress() == cloned.getAddress())); 
    }
}
