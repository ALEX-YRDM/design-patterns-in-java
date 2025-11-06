package top.stackpop.factory.abstractf;

public class MacUIFactory implements UIFactory{

    @Override
    public TextField creaTextField() {
        // TODO Auto-generated method stub
        return new MacTextField();
    }

    @Override
    public Button createButton() {
        // TODO Auto-generated method stub
        return new MacButton();
    }
    
}
