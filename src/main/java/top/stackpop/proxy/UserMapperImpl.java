package top.stackpop.proxy;

public class UserMapperImpl implements UserMapper{

    public User findById(int id) {
        // 模拟执行SQL: SELECT * FROM users WHERE id = ?
        System.out.println("  [SQL] SELECT * FROM users WHERE id = " + id);
        simulateDatabaseDelay(100, 200); // 模拟数据库查询耗时
        return new User(id, "user" + id, "user" + id + "@example.com");
    }
    
    @Override
    public User findByUsername(String username) {
        // 模拟执行SQL: SELECT * FROM users WHERE username = ?
        System.out.println("  [SQL] SELECT * FROM users WHERE username = '" + username + "'");
        simulateDatabaseDelay(80, 150);
        return new User(1, username, username + "@example.com");
    }
    
    @Override
    public void save(User user) {
        // 模拟执行SQL: INSERT INTO users (id, username, email) VALUES (?, ?, ?)
        System.out.println("  [SQL] INSERT INTO users (id, username, email) VALUES (" 
            + user.getId() + ", '" + user.getUsername() + "', '" + user.getEmail() + "')");
        simulateDatabaseDelay(150, 250);
        System.out.println("  [SQL] 保存成功");
    }
    
    @Override
    public void delete(int id) {
        // 模拟执行SQL: DELETE FROM users WHERE id = ?
        System.out.println("  [SQL] DELETE FROM users WHERE id = " + id);
        simulateDatabaseDelay(50, 100);
        System.out.println("  [SQL] 删除成功");
    }
    
    @Override
    public void update(User user) {
        // 模拟执行SQL: UPDATE users SET username = ?, email = ? WHERE id = ?
        System.out.println("  [SQL] UPDATE users SET username = '" + user.getUsername() 
            + "', email = '" + user.getEmail() + "' WHERE id = " + user.getId());
        simulateDatabaseDelay(120, 200);
        System.out.println("  [SQL] 更新成功");
    }
    
     /**
     * 模拟数据库操作的延迟（随机耗时）
     */
    private void simulateDatabaseDelay(int minMs, int maxMs) {
        try {
            int delay = minMs + (int)(Math.random() * (maxMs - minMs));
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
