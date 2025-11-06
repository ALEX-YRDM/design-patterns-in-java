package top.stackpop.builder;

import org.junit.Test;

public class ComputerBuilderTest {
    
    @Test
    public void test(){
        Computer computer = new Computer.Builder("amd 9800x3d","32gb")
                            .gpu("Rtx 5070ti")
                            .motherboard("ROG")
                            .storage("2TB").build();
        System.out.println(computer);
    }
}
