package top.stackpop.visitor;

public class FileSystem {
    
    private final DirectoryNode root;

    public FileSystem(DirectoryNode root) {
        this.root = root;
    }

    public void accept(FileSystemVisitor visitor){
        root.accept(visitor);
    }
}
