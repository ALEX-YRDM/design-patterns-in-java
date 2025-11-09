package top.stackpop.bridge;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class BridgeTest {
    
    @Test
    public void test(){
        JdbcDriver mysql =  new MySqlJdbcDriver();
        JdbcDriver postgres = new PostgresJdbcDriver();
        JdbcDriver sqlServer = new SqlServerJdbcDriver();

        JdbcClient mysqlSimple = new SimpleJdbcClient(mysql, "jdbc:mysql://localhost:3306/demo", "root", "123456");
        JdbcClient mysqlPool = new PooledJdbcClient(mysql,"jdbc:mysql://localhost:3306/demo", "root", "123456", 5);
        JdbcClient postgresSimple = new SimpleJdbcClient(postgres,"jdbc:postgresql://localhost:5432/demo", "postgres", "123456");
        JdbcClient sqlServerLogging = new LoggingJdbcClient(new SimpleJdbcClient(sqlServer,"jdbc:sqlserver://localhost:1433;databaseName=demo",
                        "sa", "123456"));

        runScenario("MySQL + Simple", mysqlSimple);
        runScenario("MySQL + Pooled", mysqlPool);
        runScenario("PostgreSQL + Simple", postgresSimple);
        runScenario("SQLServer + Logging", sqlServerLogging);
    }

    public void runScenario(String scenario, JdbcClient client) {
        System.out.println("===== 场景：" + scenario + " =====");
        List<Map<String, Object>> rows = client.query("SELECT * FROM orders WHERE id = 1");
        System.out.println("查询结果：" + rows);
        int updated = client.update("UPDATE orders SET status = 'PAID' WHERE id = 1");
        System.out.println("更新行数：" + updated);
        System.out.println();
    }
}
