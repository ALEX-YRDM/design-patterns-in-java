package top.stackpop.bridge;

import java.util.List;
import java.util.Map;
import java.util.Collections;
public class PostgresJdbcDriver implements JdbcDriver{

    @Override
    public Connection connect(String url, String username, String password) {
        System.out.println("[PostgreSQL] 建立连接：" + url + ", user=" + username);
        return new Connection(url, username);
    }

    @Override
    public List<Map<String, Object>> executeQuery(Connection connection, String sql) {
        System.out.println("[PostgreSQL] 执行查询：" + sql);
        return Collections.singletonList(Map.of("driver", "postgres", "sql", sql));
    }

    @Override
    public int executeUpdate(Connection connection, String sql) {
        System.out.println("[PostgreSQL] 执行更新：" + sql);
        return 1;
    }

    @Override
    public void close(Connection connection) {
        System.out.println("[PostgreSQL] 关闭连接：" + connection);
    }

    @Override
    public String driverName() {
        return "PostgreSQL JDBC Driver";
    }
    
    
}
