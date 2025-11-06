package top.stackpop.composite;

import org.junit.Test;

public class CompositeTest {
    
    @Test
    public void test(){

        DirectoryNode root = new DirectoryNode("root");
        DirectoryNode src = new DirectoryNode("src");
        DirectoryNode img = new DirectoryNode("img");

        FileNode readme = new FileNode("README.md", 1200);
        FileNode mainJava = new FileNode("Main.java", 3400);
        FileNode logoPng = new FileNode("logo.png", 20480);

        root.add(readme);
        root.add(src);
        src.add(mainJava);
        root.add(img);
        img.add(logoPng);

        // 统一调用：目录与文件都实现同一接口
        root.print("");
        System.out.println("Total size = " + root.getSize() + " bytes");
    }
}
