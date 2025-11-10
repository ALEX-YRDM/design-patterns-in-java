package top.stackpop.command;

import java.util.Stack;


public class CommandHistory {
    
    private final Stack<Command> history = new Stack<>();

    private final Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command){
        command.execute();
        history.push(command);
        redoStack.clear();
        System.out.println("执行命令：" + command.getDescription());
    }

    public void undo(){
        if(history.isEmpty()){
            System.out.println("没有可撤销的操作");
            return;
        }
        Command command = history.pop();
        command.undo();
        redoStack.push(command);
        System.out.println("撤销命令：" + command.getDescription());
    }

    public void redo(){
        if (redoStack.isEmpty()) {
            System.out.println("没有可重做的操作");
            return;
        }
        Command command = redoStack.pop();
        command.execute();
        history.push(command);
        System.out.println("重做命令：" + command.getDescription());
    }

    public void showHistory() {
        System.out.println("\n=== 命令历史 ===");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i).getDescription());
        }
    }
}
