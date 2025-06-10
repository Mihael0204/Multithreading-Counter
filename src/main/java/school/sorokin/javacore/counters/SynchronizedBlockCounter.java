package school.sorokin.javacore.counters;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private Integer counter = 0;

    @Override
    public void incrementVisitCount() {
        synchronized (this) {
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
