package top.stackpop.visitor;

public class XmlExportVisitor implements FileSystemVisitor {
    private final StringBuilder out = new StringBuilder();
    private int indent = 0;
    private boolean started = false;

    private void nl(){ out.append("\n"); }
    private void ind(){ out.append("  ".repeat(indent)); }
    private String esc(String s){
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'","&apos;");
    }

    @Override
    public void visitFile(FileNode file) {
        ind(); out.append("<file name=\"").append(esc(file.getName()))
                .append("\" size=\"").append(file.getSize()).append("\">"); nl();
        indent++;
        ind(); out.append("<content>").append(esc(file.getContent())).append("</content>"); nl();
        indent--;
        ind(); out.append("</file>"); nl();
    }

    @Override
    public void visitDirectory(DirectoryNode dir) {
        if (!started) {
            out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"); nl();
            out.append("<filesystem>"); nl();
            indent++;
            started = true;
        }
        ind(); out.append("<directory name=\"").append(esc(dir.getName()))
                .append("\" size=\"").append(dir.getSize()).append("\">"); nl();
        indent++;
    }

    @Override
    public void endDirectory(DirectoryNode dir) {
        indent--;
        ind(); out.append("</directory>"); nl();
        if (started && indent == 1) {
            // 根目录关闭 filesystem
            indent--;
            out.append("</filesystem>");
        }
    }

    @Override
    public void visitLink(LinkNode link) {
        ind(); out.append("<link name=\"").append(esc(link.getName()))
                .append("\" target=\"").append(esc(link.getTarget().getName())).append("\"/>"); nl();
    }

    public String getResult() {
        return out.toString();
    }
}