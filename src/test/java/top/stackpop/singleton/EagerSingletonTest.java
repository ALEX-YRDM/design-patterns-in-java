package top.stackpop.singleton;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class EagerSingletonTest {

    @Test
    public void Test(){
        EagerSingleton instance = EagerSingleton.getInstance();
        EagerSingleton instance2 =EagerSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }

    @Test
    public void threadSafeTest() throws InterruptedException{
        int threadCount = 100;

        Set<EagerSingleton> instanceSet = ConcurrentHashMap.newKeySet();
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endlatch = new CountDownLatch(threadCount);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(threadCount);
        for(int i=0;i<threadCount;i++){
            newFixedThreadPool.submit(()->{
                try{
                    startLatch.await();
                    EagerSingleton instance = EagerSingleton.getInstance();
                    instanceSet.add(instance);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally{
                    endlatch.countDown();
                }
                

            });
        }
        // 6. “扣动发令枪”，所有等待的线程同时开始执行
        System.out.println("Releasing latch, starting all threads...");
        startLatch.countDown();

        // 7. 主线程等待，直到所有子线程都越过“终点线”
        endlatch.await();

        // 8. 清理资源
        newFixedThreadPool.shutdown();

        // 9. 验证结果
        System.out.println("All threads finished.");
        System.out.println("Number of unique instances created: " + instanceSet.size());
        

    }
}
