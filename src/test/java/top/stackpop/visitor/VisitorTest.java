package top.stackpop.visitor;

import org.junit.Test;

public class VisitorTest {
    
    @Test
    public void test(){
        DirectoryNode root = new DirectoryNode("root");

        DirectoryNode docs = new DirectoryNode("docs");

        docs.addChild(new FileNode("readme.txt", 1024, "This is a readme file"));
        docs.addChild(new FileNode("guide.md", 2048, "# Guide This is a guide"));

        DirectoryNode images = new DirectoryNode("images");
        images.addChild(new FileNode("logo.png", 51200, "PNG image data"));

        root.addChild(docs);
        root.addChild(images);
        root.addChild(new LinkNode("docs_link", docs));

        FileSystem fileSystem = new FileSystem(root);

        System.out.println("=== JSON 导出 ===\n");
        JsonExportVisitor jsonVisitor = new JsonExportVisitor();
        fileSystem.accept(jsonVisitor);
        System.out.println(jsonVisitor.getResult());

        System.out.println("\n=== XML 导出 ===\n");
        XmlExportVisitor xmlVisitor = new XmlExportVisitor();
        fileSystem.accept(xmlVisitor);
        System.out.println(xmlVisitor.getResult());

        System.out.println("\n=== CSV 导出 ===\n");
        CsvExportVisitor csvVisitor = new CsvExportVisitor();
        fileSystem.accept(csvVisitor);
        System.out.println(csvVisitor.getResult());
    }
}
