package top.stackpop.bridge;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SqlServerJdbcDriver implements JdbcDriver{

    @Override
    public Connection connect(String url, String username, String password) {
        System.out.println("[SQLServer] 建立连接：" + url + ", user=" + username);
        return new Connection(url, username);
    }

    @Override
    public List<Map<String, Object>> executeQuery(Connection connection, String sql) {
        System.out.println("[SQLServer] 执行查询：" + sql);
        return Collections.singletonList(Map.of("driver", "sqlserver", "sql", sql));
    }

    @Override
    public int executeUpdate(Connection connection, String sql) {
        System.out.println("[SQLServer] 执行更新：" + sql);
        return 1;
    }

    @Override
    public void close(Connection connection) {
        System.out.println("[SQLServer] 关闭连接：" + connection);
    }

    @Override
    public String driverName() {
        return "SQLServer JDBC Driver";
    }
}
