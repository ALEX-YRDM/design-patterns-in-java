package top.stackpop.bridge;

import java.util.List;
import java.util.Map;

public interface JdbcDriver {

    Connection connect(String url,String username, String password);

    List<Map<String,Object>> executeQuery(Connection connection,String sql);

    int executeUpdate(Connection connection,String sql);

    void close(Connection connection);

    String driverName();
    
} 