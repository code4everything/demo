package com.zhazhapan.demo.test;

import com.zhazhapan.util.ThreadPool;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author pantao
 * @since 2018-07-22
 */
public class ThreadExecutorTest {

    @Test
    public void testSubmit() throws ExecutionException, InterruptedException {
        ThreadPool.init();
        Future<?> future = ThreadPool.executor.submit(() -> System.out.println("test submit"), "test result");
        System.out.println(future.get());
        ThreadPool.executor.shutdown();
    }
}
