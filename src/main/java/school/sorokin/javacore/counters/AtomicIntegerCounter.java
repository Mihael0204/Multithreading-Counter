package school.sorokin.javacore.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        atomicInteger.incrementAndGet();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }

    @Override
    public int getVisitCount() {
        return atomicInteger.get();
    }
}
