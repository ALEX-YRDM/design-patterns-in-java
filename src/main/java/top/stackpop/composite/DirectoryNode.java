package top.stackpop.composite;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode implements FileSystemNode {

    private final String name;

    private final List<FileSystemNode> children = new ArrayList<>();

    
    public DirectoryNode(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        long sum = 0L;
        for(var n: children){
            sum+=n.getSize();
        }
        return sum;
    }

    @Override
    public void add(FileSystemNode node) {
        if (node == null){
            throw new IllegalArgumentException("node is null");
        }
        children.add(node);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + getName() + "/ (" + getSize() + " bytes)");
        String next = indent + "  ";
        for (FileSystemNode n : children) {
            n.print(next);
        }
    }

    @Override
    public void remove(FileSystemNode node) {
        if(node == null){
            throw  new IllegalArgumentException("node is null");
        }
        children.remove(node);
    }

    

    
}
