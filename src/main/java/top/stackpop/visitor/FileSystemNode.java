package top.stackpop.visitor;

public interface FileSystemNode {
    
    String getName();

    long getSize();

    void accept(FileSystemVisitor visitor);
}
