package top.stackpop.factory.abstractf;

public class Application {
    
    private Button button;

    private TextField textField;

    public Application(UIFactory factory) {
        this.button = factory.createButton();
        this.textField = factory.creaTextField();
    }

    public void render(){
        button.render();
        textField.render();
    }

    
}
