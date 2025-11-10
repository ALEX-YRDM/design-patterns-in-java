package top.stackpop.command;

public class FormatCommand implements Command{

    private final TextEditor editor;
    private final int start;
    private final int length;
    private final String style;
    private String originalText;
    public FormatCommand(TextEditor editor, int start, int length, String style) {
        this.editor = editor;
        this.start = start;
        this.length = length;
        this.style = style;
    }
    @Override
    public void execute() {
        originalText = editor.getContent().substring(start, Math.min(start+length, editor.getLength()));
        editor.format(start, length, style);
        
    }
    @Override
    public String getDescription() {
        return "格式化位置 " + start + " 为 " + style;
    }
    @Override
    public void undo() {
        
        if(originalText!=null){
            editor.delete(start, editor.getContent().substring(start).indexOf("[/" + style + "]") + style.length() + 4);
            editor.insert(originalText, start);
        }
    }

    
    
}
