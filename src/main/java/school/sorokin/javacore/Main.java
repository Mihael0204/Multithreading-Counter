package school.sorokin.javacore;

import school.sorokin.javacore.counters.*;

public class Main {
    public static void main(String[] args) {
        SiteVisitCounter unsynchronizedCounter = new UnsynchronizedCounter();
        SiteVisitCounter volatileCounter = new VolatileCounter();
        SiteVisitCounter atomicIntegerCounter = new AtomicIntegerCounter();
        SiteVisitCounter synchronizedBlockCounter = new SynchronizedBlockCounter();
        SiteVisitCounter reetrantLockCounter = new ReentrantLockCounter();

        MultithreadingSiteVisitor unsync = new MultithreadingSiteVisitor(unsynchronizedCounter);
        unsync.visitMultithread(100);
        unsync.waitUntilAllVisited();
        System.out.println(unsync.getTotalTimeOfHandling());

        MultithreadingSiteVisitor volat = new MultithreadingSiteVisitor(volatileCounter);
        volat.visitMultithread(100);
        volat.waitUntilAllVisited();
        System.out.println(volat.getTotalTimeOfHandling());

        MultithreadingSiteVisitor atomic = new MultithreadingSiteVisitor(atomicIntegerCounter);
        atomic.visitMultithread(100);
        atomic.waitUntilAllVisited();
        System.out.println(atomic.getTotalTimeOfHandling());

        MultithreadingSiteVisitor syncronized = new MultithreadingSiteVisitor(synchronizedBlockCounter);
        syncronized.visitMultithread(100);
        syncronized.waitUntilAllVisited();
        System.out.println(syncronized.getTotalTimeOfHandling());

        MultithreadingSiteVisitor reetrant = new MultithreadingSiteVisitor(reetrantLockCounter);
        reetrant.visitMultithread(100);
        reetrant.waitUntilAllVisited();
        System.out.println(reetrant.getTotalTimeOfHandling());

        /*
        Счетчики без синхронизации, с ключевым словом volatile и Atomic являются самыми быстрыми реализациями,
        при этом реализации без синхронизации и с volatile - являются неправильными, так как их операции
        все еще неатомарные.

        Unsynchronized работает неправильно, так как counter++ неатомарный, но работает быстро.

        Volatile также работает неправильно, т.к. не делает counter++ атомарным, а всего лишь видимым его
        других потоков.

        AtomicInteger работает правильно, и самое главное быстро для этой реализации. Метод incrementAndGet()
        полностью атомарный и не требует блокировок.

        Syncronized блок кода работает правильно, но имеет большие накладные расходы на синхронизацию,
        так как каждый поток ждет, пока монитор освободиться

        ReentrantLock работает правильно, явная блокировка исключает одномоментный доступ потоков к ресурсу.
        Скорость немного быстрее чем Syncronized, но медленнее AtomicInteger. Хорош для гибкой блокировки.
         */
    }
}
