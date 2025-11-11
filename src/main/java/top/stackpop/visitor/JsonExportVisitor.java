package top.stackpop.visitor;

import java.util.ArrayDeque;
import java.util.Deque;

public class JsonExportVisitor implements FileSystemVisitor {
    private final StringBuilder out = new StringBuilder();
    private final Deque<Boolean> firstChildStack = new ArrayDeque<>();
    private int indent = 0;
    private boolean started = false;

    private void nl() { out.append("\n"); }
    private void ind() { out.append("  ".repeat(indent)); }
    private void beforeChild() {
        if (!firstChildStack.isEmpty()) {
            boolean first = firstChildStack.peek();
            if (!first) out.append(",").append("\n");
            else out.append("\n");
            firstChildStack.pop();
            firstChildStack.push(false);
        }
    }

    @Override
    public void visitFile(FileNode file) {
        beforeChild();
        ind();
        out.append("\"").append(escape(file.getName())).append("\": {"); nl();
        indent++;
        ind(); out.append("\"type\": \"file\","); nl();
        ind(); out.append("\"size\": ").append(file.getSize()).append(","); nl();
        ind(); out.append("\"content\": \"").append(escape(file.getContent())).append("\""); nl();
        indent--;
        ind(); out.append("}");
    }

    @Override
    public void visitDirectory(DirectoryNode dir) {
        if (!started) {
            // 根对象包装
            out.append("{"); nl();
            indent++;
            started = true;
        }
        beforeChild();
        ind();
        out.append("\"").append(escape(dir.getName())).append("\": {"); nl();
        indent++;
        ind(); out.append("\"type\": \"directory\","); nl();
        ind(); out.append("\"size\": ").append(dir.getSize()).append(","); nl();
        ind(); out.append("\"children\": {");
        // 进入 children 对象，初始化“首子项”标记
        firstChildStack.push(true);
        indent++;
    }

    @Override
    public void endDirectory(DirectoryNode dir) {
        nl();
        indent--;
        ind(); out.append("}"); nl(); // 结束 children
        indent--;
        ind(); out.append("}");
        // 如果回到根的第一层，需要在最后补齐根的收尾
        if (indent == 1) {
            nl();
        }
        // 若该目录是某父目录的 children 的元素，交给父层 beforeChild 控制逗号
    }

    @Override
    public void visitLink(LinkNode link) {
        beforeChild();
        ind();
        out.append("\"").append(escape(link.getName())).append("\": {"); nl();
        indent++;
        ind(); out.append("\"type\": \"link\","); nl();
        ind(); out.append("\"target\": \"").append(escape(link.getTarget().getName())).append("\""); nl();
        indent--;
        ind(); out.append("}");
    }

    public String getResult() {
        // 结束根对象
        while (!firstChildStack.isEmpty()) firstChildStack.pop();
        if (started) {
            indent--;
            out.append("}");
        }
        return out.toString();
    }

    private String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
    }
}