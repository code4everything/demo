package org.code4everything.demo.concurrency;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import org.code4everything.boot.base.function.VoidFunction;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author pantao
 * @since 2019/10/7
 */
public class SynchronizedTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 对象锁测试
        Console.log("对象锁测试\r\n===========================================");
        ObjectLock objectLock = new ObjectLock();
        Future<Integer> objectMethodFuture = ThreadUtil.execAsync(defaultCallable(objectLock::methodSync));
        Future<Integer> objectBlockFuture = ThreadUtil.execAsync(defaultCallable(objectLock::blockSync));
        waitForComplete(objectMethodFuture, objectBlockFuture);

        // 类锁测试
        Console.log("\r\n类锁测试\r\n===========================================");
        Future<Integer> classMethodFuture = ThreadUtil.execAsync(defaultCallable(ClassLock::methodSync));
        Future<Integer> classBlockFuture = ThreadUtil.execAsync(defaultCallable(ClassLock::blockSync));
        Future<Integer> classSyncFuture = ThreadUtil.execAsync(defaultCallable(new ClassLock()::classSync));
        waitForComplete(classMethodFuture, classBlockFuture, classSyncFuture);

        // 类锁与对象锁是否互斥测试
        Console.log("\r\n类锁与对象锁是否互斥测试\r\n===========================================");
        ClassObjectLock classObjectLock = new ClassObjectLock();
        Future<Integer> classLockFuture = ThreadUtil.execAsync(defaultCallable(classObjectLock::classSync));
        Future<Integer> objectLockFuture = ThreadUtil.execAsync(defaultCallable(classObjectLock::objectSync));
        waitForComplete(classLockFuture, objectLockFuture);
    }

    private static void waitForComplete(Future<?>... futures) throws ExecutionException, InterruptedException {
        for (Future<?> future : futures) {
            future.get();
        }
    }

    private static Callable<Integer> defaultCallable(VoidFunction function) {
        return () -> {
            function.call();
            return 1;
        };
    }

    private static void printAndSleep() {
        Console.log("我是线程：" + Thread.currentThread().getName());
        ThreadUtil.sleep(1000);
        Console.log("线程[{}]运行结束", Thread.currentThread().getName());
    }

    /**
     * 同一个类的类锁和其对象锁并不是同一把锁，即这两种不同的同步方法可同时被不同线程访问
     */
    private static class ClassObjectLock {

        private void classSync() {
            synchronized (ClassObjectLock.class) {
                printAndSleep();
            }
        }

        private synchronized void objectSync() {
            printAndSleep();
        }
    }

    /**
     * 持有相同类锁的同步方法在多个线程中互斥，即同一时刻只能被一个线程访问
     */
    private static class ClassLock {

        private static synchronized void methodSync() {
            printAndSleep();
        }

        private static void blockSync() {
            synchronized (ClassLock.class) {
                printAndSleep();
            }
        }

        private void classSync() {
            synchronized (ClassLock.class) {
                printAndSleep();
            }
        }
    }

    /**
     * 持有相同对象锁的同步方法在多个线程中互斥，即同一时刻只能被一个线程访问
     */
    private static class ObjectLock {

        private synchronized void methodSync() {
            printAndSleep();
        }

        private void blockSync() {
            synchronized (this) {
                printAndSleep();
            }
        }
    }
}
