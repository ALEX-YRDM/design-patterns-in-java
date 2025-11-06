package top.stackpop.factory.simple;

import org.junit.Test;

public class ShapeFactoryTest {
    
    /**
     * only get what you want
     * do not care how object was created
     */
    @Test
    public void test(){
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();

        Shape rectangle=  ShapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = ShapeFactory.getShape("square");
        square.draw();
    }
}
