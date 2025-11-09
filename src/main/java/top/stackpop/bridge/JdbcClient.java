package top.stackpop.bridge;

import java.util.List;
import java.util.Map;

public abstract class JdbcClient {
    protected final JdbcDriver driver;

    public JdbcClient(JdbcDriver driver) {
        this.driver = driver;
    }

    public abstract List<Map<String,Object>> query(String sql);

    public abstract int update(String sql);
}
