package top.stackpop.visitor;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode implements FileSystemNode{

    private final String name;

    private final List<FileSystemNode> child = new ArrayList<>();

    public DirectoryNode(String name) {
        this.name = name;
    }

    public void addChild(FileSystemNode node){
        child.add(node);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<FileSystemNode> getChild() {
        return child;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        
        visitor.visitDirectory(this);
        for(var c:child){
            c.accept(visitor);
        }
        visitor.endDirectory(this); 
    }

    @Override
    public long getSize() {
        return child.stream().mapToLong(FileSystemNode::getSize).sum();
    }
    
    
    
}
