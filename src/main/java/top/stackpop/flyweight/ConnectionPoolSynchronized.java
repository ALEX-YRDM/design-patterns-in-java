package top.stackpop.flyweight;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectionPoolSynchronized {
    //大量使用Synchronized 性能较差
    private final Queue<DatabaseConnection> pool = new ArrayDeque<>();

    private final int maxSize;

    private int createdCount = 0;

    public ConnectionPoolSynchronized(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized DatabaseConnection acquire(){
        if(!pool.isEmpty()){
            DatabaseConnection connection = pool.poll();
            System.out.println("从池中获取连接："+connection.getId());
            return connection;

        }

        if(createdCount<maxSize){
            createdCount++;
            DatabaseConnection connection = new DatabaseConnection("Conn-"+createdCount);
            System.out.println("新建连接并借出去："+connection.getId());
            return connection;
        }

        try{
            System.out.println("连接池已经耗尽，等待中...");
            wait();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return acquire();
    }

    public synchronized void release(DatabaseConnection connection){
        connection.reset();
        pool.offer(connection);
        System.out.println("归还连接"+connection.getId());
        notifyAll();
    }

    public synchronized int availableCount(){
        return pool.size();
    }

    public synchronized int createdCount(){
        return createdCount;
    }
}
