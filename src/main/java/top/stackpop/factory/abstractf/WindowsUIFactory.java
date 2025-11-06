package top.stackpop.factory.abstractf;

public class WindowsUIFactory implements UIFactory{

    @Override
    public TextField creaTextField() {
        // TODO Auto-generated method stub
        return new WindowsTextField();
    }

    @Override
    public Button createButton() {
        // TODO Auto-generated method stub
        return new WindowsButton(); 
    }
    
    
}
