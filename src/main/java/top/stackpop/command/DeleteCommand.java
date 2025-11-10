package top.stackpop.command;

public class DeleteCommand implements Command{

    private final TextEditor editor;
    private final int start;

    private final int length;
    private String deletedText;
    public DeleteCommand(TextEditor editor, int start, int length) {
        this.editor = editor;
        this.start = start;
        this.length = length;
    }
    @Override
    public void execute() {
        deletedText = editor.getContent().substring(start,Math.min(start+length, editor.getLength()));
        editor.delete(start, length);
        
    }
    @Override
    public String getDescription() {
        return "delete from"+ start+" length is "+length;
    }
    @Override
    public void undo() {
       if(deletedText!=null){
        editor.insert(deletedText, start);
       }
        
    }

    
    
}
