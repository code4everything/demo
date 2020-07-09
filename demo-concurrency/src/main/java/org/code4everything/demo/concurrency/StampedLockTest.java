package org.code4everything.demo.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author pantao
 * @since 2020/5/20
 */
public class StampedLockTest {

    /**
     * non reentrant
     */
    private final StampedLock lock = new StampedLock();

    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        StampedLockTest test = new StampedLockTest();
        test.deadLock();
    }

    public void deadLock() {
        final long writeStamp = lock.writeLock();
        try {
            System.out.println("will dead lock...");

            final long readStamp = lock.readLock();
            // no reentrant feature
            try {
                System.out.println("dead failed");
            } finally {
                lock.unlockRead(readStamp);
            }
        } finally {
            lock.unlockWrite(writeStamp);
        }
    }
}
