package top.stackpop.command;

import org.junit.Test;

public class Commandtest {
    
    @Test
    public void test(){
        TextEditor editor = new TextEditor();
        CommandHistory history = new CommandHistory();

        System.out.println("=== 初始状态 ===");
        System.out.println("内容：" + editor.getContent() + "\n");

        System.out.println("=== 执行一系列操作 ===");
        Command cmd1 = new InsertCommand(editor, "Hello", 0);
        history.executeCommand(cmd1);
        System.out.println("当前内容：" + editor.getContent() + "\n");

        Command cmd2 = new InsertCommand(editor, " World", 5);
        history.executeCommand(cmd2);
        System.out.println("当前内容：" + editor.getContent() + "\n");

        Command cmd3 = new FormatCommand(editor, 0, 5, "bold");
        history.executeCommand(cmd3);
        System.out.println("当前内容：" + editor.getContent() + "\n");

        Command cmd4 = new DeleteCommand(editor, 5, 6);
        history.executeCommand(cmd4);
        System.out.println("当前内容：" + editor.getContent() + "\n");

        System.out.println("=== 撤销操作 ===");
        history.undo();
        System.out.println("当前内容：" + editor.getContent() + "\n");

        history.undo();
        System.out.println("当前内容：" + editor.getContent() + "\n");

        System.out.println("=== 重做操作 ===");
        history.redo();
        System.out.println("当前内容：" + editor.getContent() + "\n");

        history.showHistory();
    }
}
