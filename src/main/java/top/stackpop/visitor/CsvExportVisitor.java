package top.stackpop.visitor;

public class CsvExportVisitor implements FileSystemVisitor {
    private final StringBuilder out = new StringBuilder();
    private boolean header = false;

    private String esc(String s){
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            return "\"" + s.replace("\"","\"\"") + "\"";
        }
        return s;
    }

    private void ensureHeader(){
        if (!header){
            out.append("Type,Name,Size,Content/Target\n");
            header = true;
        }
    }

    @Override
    public void visitFile(FileNode file) {
        ensureHeader();
        out.append("File,")
           .append(esc(file.getName())).append(",")
           .append(file.getSize()).append(",")
           .append(esc(file.getContent())).append("\n");
    }

    @Override
    public void visitDirectory(DirectoryNode dir) {
        ensureHeader();
        out.append("Directory,")
           .append(esc(dir.getName())).append(",")
           .append(dir.getSize()).append(",")
           .append("").append("\n");
    }

    @Override
    public void endDirectory(DirectoryNode dir) {
        // CSV 无需特别处理
    }

    @Override
    public void visitLink(LinkNode link) {
        ensureHeader();
        out.append("Link,")
           .append(esc(link.getName())).append(",")
           .append(0).append(",")
           .append(esc(link.getTarget().getName())).append("\n");
    }

    public String getResult(){
        return out.toString();
    }
}