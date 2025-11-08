package top.stackpop.flyweight;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class FlyWeightTest {
    // 享元模式：通过共享一些对象来避免创建大量重复的对象
    @Test
    public void testSync() throws InterruptedException{
        ConnectionPoolSynchronized pool =new ConnectionPoolSynchronized(10);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch endLatch = new CountDownLatch(30);
        for(int i=0;i<30;i++){
            final int taskId = i;
            executor.submit(()->{
                DatabaseConnection connection = pool.acquire();
                try{
                    String sql = "SELECT * FROM orders WHERE id = " + taskId;
                    connection.execute(sql);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 100));
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally{
                    pool.release(connection);
                    endLatch.countDown();
                }
            });
        }
        endLatch.await();
        executor.shutdown();
    }
    
    @Test
    public void testSamaphore() throws InterruptedException{
        ConnectionPoolSemaphore pool = new ConnectionPoolSemaphore(10);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch endLatch = new CountDownLatch(30);
        for(int i=0;i<30;i++){
            final int taskId = i;
            executor.submit(()->{
                DatabaseConnection connection = pool.acquire();
                try{
                    String sql = "SELECT * FROM orders WHERE id = " + taskId;
                    connection.execute(sql);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 100));
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally{
                    pool.release(connection);
                    endLatch.countDown();
                }
            });
        }
        endLatch.await();
        executor.shutdown();
    }

    @Test
    public void testBlockingQueue() throws InterruptedException{
        ConnectionPoolBlockingQueue pool=new ConnectionPoolBlockingQueue(10,true);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        CountDownLatch endLatch = new CountDownLatch(30);
        for(int i=0;i<30;i++){
            final int taskId = i;
            executor.submit(()->{
                DatabaseConnection connection = pool.acquire();
                try{
                    String sql = "SELECT * FROM orders WHERE id = " + taskId;
                    connection.execute(sql);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100,200));
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally{
                    pool.release(connection);
                    endLatch.countDown();
                }
            });
        }
        endLatch.await();
        executor.shutdown();
    }
}
