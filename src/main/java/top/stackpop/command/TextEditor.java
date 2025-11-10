package top.stackpop.command;


public class TextEditor {
    
    private final StringBuilder content = new StringBuilder();

    private int cursorPosition = 0;

    public void insert(String text,int position){
        content.insert(position, text);
        cursorPosition = position+text.length();
        System.out.println("[TextEditor] 在位置 " + position + " 插入文本：" + text);
   
    }

    public void delete(int start, int length){
        String deleted = content.substring(start,start+length);

        content.delete(start,start+length);
        cursorPosition = start;
        System.out.println("[TextEditor] 删除位置 " + start + " 到 " + (start + length) + " 的内容：" + deleted);
    
    }

    public void format(int start, int length, String style){
        String formatted = content.substring(start,start+length);
        content.replace(start, start + length, "[" + style + "]" + formatted + "[/" + style + "]");
        System.out.println("[TextEditor] 格式化位置 " + start + " 到 " + (start + length) + " 为 " + style);
    }

    public String getContent(){
        return content.toString();
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(int cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public int getLength(){
        return content.length();
    }
}
