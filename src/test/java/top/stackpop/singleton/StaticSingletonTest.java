package top.stackpop.singleton;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class StaticSingletonTest {
    
    @Test
    public void test(){
        StaticBlockSingleton instance = StaticBlockSingleton.getInstance();
        StaticBlockSingleton instance2 = StaticBlockSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }

    @Test
    public void threadSafeTest() throws InterruptedException{
        int threadCount = 100;
        Set<StaticBlockSingleton> instanceSet = ConcurrentHashMap.newKeySet();
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endlatch = new CountDownLatch(threadCount);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(threadCount);
        for(int i=0;i<threadCount;i++){
            newFixedThreadPool.submit(()->{
                try{
                    startLatch.await();
                    StaticBlockSingleton instance = StaticBlockSingleton.getInstance();
                    instanceSet.add(instance);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally{
                    endlatch.countDown();
                }
            });
        }
        startLatch.countDown();
        endlatch.await();
        newFixedThreadPool.shutdown();
        System.out.println("Number of unique instances created: " + instanceSet.size());
    }
}
