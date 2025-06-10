package school.sorokin.javacore.counters;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter {
    private ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    @Override
    public void incrementVisitCount() {
        lock.lock();
        try {
            counter++;
            Thread.sleep(100);
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getVisitCount() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
