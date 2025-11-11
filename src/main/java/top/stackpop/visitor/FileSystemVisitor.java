package top.stackpop.visitor;

public interface FileSystemVisitor {
    
    void visitFile(FileNode file);

    void visitDirectory(DirectoryNode directory);
    void endDirectory(DirectoryNode directory);   // 新增：目录子节点遍历完后的收尾
    void visitLink(LinkNode link);
}
