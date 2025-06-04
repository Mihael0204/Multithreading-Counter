package school.sorokin.javacore.counters;

public class UnsynchronizedCounter implements SiteVisitCounter {
    private int counter = 0;
    @Override
    public void incrementVisitCount() {
        counter++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
