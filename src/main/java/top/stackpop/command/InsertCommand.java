package top.stackpop.command;

public class InsertCommand implements Command{
    private final TextEditor editor;

    private final String text;

    private final int position;

    private String backup;

    public InsertCommand(TextEditor editor, String text, int position) {
        this.editor = editor;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        backup = editor.getContent();
        editor.insert(text, position);
        
    }

    @Override
    public String getDescription() {
        return "insert "+text;
    }

    @Override
    public void undo() {
        editor.setCursorPosition(0);
        editor.delete(0, editor.getLength());
        if(backup!=null){
            editor.insert(backup,0);
        }
        
    }

    
    
}
