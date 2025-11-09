package top.stackpop.bridge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class PooledJdbcClient extends JdbcClient{

    private final String url;
    private final String username;
    private final String password;
    private final Deque<Connection> pool =new ArrayDeque<>();
    private final int maxSize;
    public PooledJdbcClient(JdbcDriver driver, String url, String username, String password, int maxSize) {
        super(driver);
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxSize = maxSize;
    }
    @Override
    public synchronized List<Map<String, Object>> query(String sql) {
        Connection conn=acquire();
        try{
            return driver.executeQuery(conn, sql);
        }finally{
            release(conn);
        }
    }
    @Override
    public synchronized int update(String sql) {
        Connection conn = acquire();
        try{
            return driver.executeUpdate(conn, sql);
        }finally{
            release(conn);
        }
    }

    private Connection acquire(){
        Connection conn = pool.pollFirst();
        if(conn!=null){
            System.out.println("【PooledClient]复用连接: "+conn);
            return conn;
        }
        if(pool.size()<maxSize){
            return driver.connect(url, username, password);
        }
        return driver.connect(url, username, password);
    }


    public void release(Connection conn){
        if(pool.size()<maxSize){
            System.out.println("[PooledClient] 归还连接：" + conn);
            pool.offerLast(conn);
        }else{
            driver.close(conn);
        }
    }
    
}
