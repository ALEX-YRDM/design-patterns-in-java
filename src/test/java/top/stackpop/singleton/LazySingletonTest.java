package top.stackpop.singleton;

import org.junit.Test;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazySingletonTest {
    @Test
    public void test(){
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }

    @Test
    public void threadSafeTest() throws InterruptedException{
        /**
         *  may occur:  Number of unique instances created: 2
         * Number of unique instances created: 3
         * 线程不安全
         */
        int threadCount = 100;
        Set<LazySingleton> instanceSet = ConcurrentHashMap.newKeySet();
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endlatch = new CountDownLatch(threadCount);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(threadCount);
        for(int i=0;i<threadCount;i++){
            newFixedThreadPool.submit(()->{
                try{
                    startLatch.await();
                    LazySingleton instance = LazySingleton.getInstance();
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
