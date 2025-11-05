package top.stackpop.singleton;

import org.junit.Test;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;

public class BillPughSingletonTest {
    
    @Test
    public void test(){
        BillPughSingleton instance = BillPughSingleton.getInstance();
        BillPughSingleton instance2 = BillPughSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }

    @Test
    public void threadSafeTest() throws InterruptedException{
        int threadCount=100;

        Set<BillPughSingleton> instanceSet=ConcurrentHashMap.newKeySet();
        CountDownLatch startLatch =new CountDownLatch(1);
        CountDownLatch eDownLatch = new CountDownLatch(threadCount);

        int corePoolSize = threadCount;
        int maxPoolSize=  threadCount;
        long keepAliveTime = 0L;

        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger counter = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("singleton-test-pool"+counter.getAndIncrement());
                return t;
            }
            
        };

        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(maxPoolSize),
         threadFactory, handler
        );
        for(int i=0;i<threadCount;i++){
            executorService.submit(()->{
                try{
                    startLatch.await();
                    BillPughSingleton instance = BillPughSingleton.getInstance();
                    instanceSet.add(instance);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }finally{
                    eDownLatch.countDown();
                }
            });
        }
        System.out.println("Releasing latch, starting all threads...");
        startLatch.countDown();

        eDownLatch.await();
        executorService.shutdown();

        System.out.println("All threads finished.");
        System.out.println("Number of unique instances created: " + instanceSet.size());
    }
}
