package top.stackpop.flyweight;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class ConnectionPoolSemaphore {

    

    private final Queue<DatabaseConnection> pool = new ConcurrentLinkedQueue<>();
    private final Semaphore semaphore;
    private final int maxSize;
    private volatile int createdCount = 0;

    public ConnectionPoolSemaphore(int maxSize) {
        this.maxSize = maxSize;
        this.semaphore = new Semaphore(maxSize);
    }

    public DatabaseConnection acquire() {
        try {
            semaphore.acquire(); // 控制最大并发借用数
            DatabaseConnection conn = pool.poll();
            if (conn != null) {
                System.out.println("从池中获取连接：" + conn.getId());
                return conn;
            }
            int current = nextId();
            DatabaseConnection newConn = new DatabaseConnection("Conn-" + current);
            System.out.println("新建连接并借出去：" + newConn.getId());
            return newConn;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("获取连接被中断", e);
        }
    }

    public void release(DatabaseConnection connection) {
        connection.reset();
        pool.offer(connection);
        System.out.println("归还连接 " + connection.getId());
        semaphore.release();
    }

    public int availableCount() {
        return pool.size();
    }

    public int createdCount() {
        return createdCount;
    }

    private synchronized int nextId() {
        if (createdCount >= maxSize) {
            // 在极端并发下避免超过 maxSize（可改成 AtomicInteger.compareAndSet）
            return createdCount;
        }
        createdCount++;
        return createdCount;
    }
}
