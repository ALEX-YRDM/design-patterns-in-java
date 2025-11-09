package top.stackpop.bridge;

import java.util.List;
import java.util.Map;

public class LoggingJdbcClient extends JdbcClient {
    private final JdbcClient delegate;

    public LoggingJdbcClient(JdbcClient delegate) {
        super(delegate.driver);
        this.delegate = delegate;
    }

    @Override
    public List<Map<String, Object>> query(String sql) {
        System.out.println("[LoggingClient] SQL 查询：" + sql);
        return delegate.query(sql);
    }

    @Override
    public int update(String sql) {
        System.out.println("[LoggingClient] SQL 更新：" + sql);
        return delegate.update(sql);
    }
}
