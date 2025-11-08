package top.stackpop.flyweight;

public class DatabaseConnection {
    private final String id;

    private boolean active;

    public DatabaseConnection(String id){
        this.id=id;
        this.active=false;

        try {
            System.out.println(">> 建立真实数据库连接，id = " + id);
            Thread.sleep(200); // 模拟连接建立耗时
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void execute(String sql){
        System.out.printf("连接[%s] 执行 SQL：%s%n", id, sql);
        active = true;
    }

    public void reset(){
        active=false;
    }

    public boolean isActive(){
        return active;
    }

    public String getId(){
        return id;
    }
}
