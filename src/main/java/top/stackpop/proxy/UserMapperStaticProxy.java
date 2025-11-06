package top.stackpop.proxy;

public class UserMapperStaticProxy implements UserMapper{
    /**
     * 内部包含了要代理的类
     * 重写其内部方法，每一个，大量重复
     */

    private final UserMapper target;

    
    public UserMapperStaticProxy(UserMapper target) {
        this.target = target;
    }

    @Override
    public User findById(int id) {
        long startTime = System.currentTimeMillis();
        System.out.println("[耗时统计] 开始执行 findById(" + id + ")");
        
        User result = target.findById(id);
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("[耗时统计] findById(" + id + ") 执行完成，耗时: " + duration + "ms");
        return result;
    }
    
    @Override
    public User findByUsername(String username) {
        long startTime = System.currentTimeMillis();
        System.out.println("[耗时统计] 开始执行 findByUsername('" + username + "')");
        
        User result = target.findByUsername(username);
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("[耗时统计] findByUsername('" + username + "') 执行完成，耗时: " + duration + "ms");
        return result;
    }
    
    @Override
    public void save(User user) {
        long startTime = System.currentTimeMillis();
        System.out.println("[耗时统计] 开始执行 save(" + user + ")");
        
        target.save(user);
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("[耗时统计] save(" + user + ") 执行完成，耗时: " + duration + "ms");
    }
    

    @Override
    public void delete(int id) {
        long startTime = System.currentTimeMillis();
        System.out.println("[耗时统计] 开始执行 delete(" + id + ")");
        
        target.delete(id);
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("[耗时统计] delete(" + id + ") 执行完成，耗时: " + duration + "ms");
    }
    
    @Override
    public void update(User user) {
        long startTime = System.currentTimeMillis();
        System.out.println("[耗时统计] 开始执行 update(" + user + ")");
        
        target.update(user);
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("[耗时统计] update(" + user + ") 执行完成，耗时: " + duration + "ms");
    }
    
    
}
