package top.stackpop.factory.abstractf;
import org.junit.Test;



public class AbstractFactoryTest {
    
    @Test
    public void windowsUi(){
        Application app = new Application(new WindowsUIFactory());
        app.render();
    }

    @Test
    public void macUi(){
        Application app = new Application(new MacUIFactory());
        app.render();
    }

}
