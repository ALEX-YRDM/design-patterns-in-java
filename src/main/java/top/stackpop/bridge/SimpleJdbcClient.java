package top.stackpop.bridge;

import java.util.List;
import java.util.Map;

public class SimpleJdbcClient extends JdbcClient {

    private final String url;

    private final String username;

    private final String password;

    
    public SimpleJdbcClient(JdbcDriver driver, String url, String username, String password) {
        super(driver);
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Map<String, Object>> query(String sql) {
        Connection conn = driver.connect(url,username,password);
        try{
            return driver.executeQuery(conn, sql);
        }
        finally{
            driver.close(conn);
        }
    }

    @Override
    public int update(String sql) {
        Connection conn = driver.connect(url, username,password);
        try{
            return driver.executeUpdate(conn, sql);
        }finally{
            driver.close(conn);
        }
    }
    
    
}
