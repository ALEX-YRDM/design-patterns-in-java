package top.stackpop.visitor;

public class FileNode implements FileSystemNode{

    private final String name;

    private final long size;

    private final String content;

    public FileNode(String name, long size, String content) {
        this.name = name;
        this.size = size;
        this.content = content;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        
        visitor.visitFile(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    public String getContent(){return content;}
    
    
}
