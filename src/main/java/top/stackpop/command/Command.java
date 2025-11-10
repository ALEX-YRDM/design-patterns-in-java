package top.stackpop.command;

public interface Command {
    
    void execute();

    void undo();

    String getDescription();
}
