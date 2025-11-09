package top.stackpop.bridge;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MySqlJdbcDriver implements JdbcDriver{

    @Override
    public void close(Connection connection) {
        System.out.println("[MySQL] 关闭连接：" + connection);
        
    }

    @Override
    public Connection connect(String url, String username, String password) {
        System.out.println("[MySQL] 建立连接：" + url + ", user=" + username);
        return new Connection(url, username);
    }

    @Override
    public String driverName() {
        
        return "MySQL JDBC Driver";
    }

    @Override
    public List<Map<String, Object>> executeQuery(Connection connection, String sql) {
        System.out.println("[MySQL] 执行查询：" + sql);
        return Collections.singletonList(Map.of("driver", "mysql", "sql", sql));
    }

    @Override
    public int executeUpdate(Connection connection, String sql) {
        System.out.println("[MySQL] 执行更新：" + sql);
        return 1;
    }
        
}
