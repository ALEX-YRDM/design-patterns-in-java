package top.stackpop.visitor;

public class LinkNode implements FileSystemNode{

    private final String name;

    private final FileSystemNode target;

    
    public LinkNode(String name, FileSystemNode target) {
        this.name = name;
        this.target = target;
    }

    
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitLink(this);
        
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return 0;
    }


    public FileSystemNode getTarget() {
        return target;
    }

    
    
}
