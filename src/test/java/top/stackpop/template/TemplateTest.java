package top.stackpop.template;

import org.junit.Test;

public class TemplateTest {
    
    @Test
    public void test(){
        AbstractOrderProcessor normal = new NormalOrderprocessor();
        AbstractOrderProcessor presale = new PreSaleOrderProcessor();
        AbstractOrderProcessor virtual = new VirtualOrderProcessor();

        normal.processOrder("N-20250101");
        presale.processOrder("P-20250102");
        virtual.processOrder("V-20250103");
    }
}
