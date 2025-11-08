package top.stackpop.flyweight;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolBlockingQueue {
    private final BlockingQueue<DatabaseConnection> pool;
    private final int maxSize;
    private final AtomicInteger createdCount = new AtomicInteger();

    public ConnectionPoolBlockingQueue(int maxSize) {
        this(maxSize,false);
    }

    public ConnectionPoolBlockingQueue(int maxSize,boolean eager) {
        this.maxSize = maxSize;
        this.pool = new ArrayBlockingQueue<>(maxSize);
        if(eager){
            for(int i=0;i<maxSize;i++){
                DatabaseConnection conn = newConnection();
                pool.offer(conn);
            }
        }
    }

    public DatabaseConnection acquire(){
        DatabaseConnection connection = pool.poll();
        if(connection!=null){
            System.out.println("从池中取出连接: "+connection.getId());
            return connection;
        }

        int current = createdCount.incrementAndGet();
        if(current<=maxSize){
            DatabaseConnection newConn = newConnection();
            System.out.println("新建连接并借出：" + newConn.getId());
            return newConn;
        }

        createdCount.decrementAndGet();
        try{
            connection = pool.take();
            System.out.println("等待后获取连接："+connection.getId());
            return connection;
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("获取连接被中断", e);
        }
    }

    public void release(DatabaseConnection connection){
        connection.reset();
        if(!pool.offer(connection)){
            System.out.println("连接池已满，丢弃连接："+connection.getId());
        }else{
            System.out.println("归还连接: "+connection.getId());
        }
    }

    public int availableCount(){
        return pool.size();
    }

    public int createdCount(){
        return createdCount.get();
    }

    private DatabaseConnection newConnection(){
        return new DatabaseConnection("conn-"+createdCount.incrementAndGet());
    }

    
    
}
