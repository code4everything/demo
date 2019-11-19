package org.code4everything.demo.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author pantao
 * @since 2019/11/19
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
        final ForkJoinPool joinPool = ForkJoinPool.commonPool();
        final RecursiveTask<String> taskOne = new RecursiveTask<String>() {
            @Override
            protected String compute() {
                System.out.println("task one");
                return null;
            }
        };

        final RecursiveTask<String> taskTwo = new RecursiveTask<String>() {
            @Override
            protected String compute() {
                System.out.println("task two");
                return null;
            }
        };
        final ForkJoinTask<String> mainTask = new RecursiveTask<String>() {
            @Override
            protected String compute() {
                taskOne.fork();
                taskTwo.fork();
                String result = taskOne.join() + taskTwo.join();
                System.out.println("task main");
                return result;
            }
        };
        joinPool.invoke(mainTask);
    }
}
