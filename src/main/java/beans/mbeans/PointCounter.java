package beans.mbeans;

import beans.Point;
import beans.ResultTable;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PointCounter extends NotificationBroadcasterSupport implements PointCounterMBean{
    private AtomicInteger totalPoints = new AtomicInteger(0);
    private AtomicInteger missedPoints = new AtomicInteger(0);
    private int consecutiveMisses = 0;
    private long sequenceNumber = 1;
    private ResultTable resultTable;

    public PointCounter(ResultTable resultTable) {
        this.resultTable = resultTable;
        initializeCounts();
    }

    private void initializeCounts() {
        totalPoints.set(0);
        missedPoints.set(0);
        List<Point> results = resultTable.getResults();
        for (Point point : results) {
            totalPoints.incrementAndGet();
            if (!point.isHit()) {
                missedPoints.incrementAndGet();
            }
        }
    }

    @Override
    public int getTotalPoints() {
        return totalPoints.get();
    }

    @Override
    public int getMissedPoints() {
        return missedPoints.get();
    }

    @Override
    public void incrementTotalPoints() {
        totalPoints.incrementAndGet();
    }

    @Override
    public void incrementMissedPoints() {
        missedPoints.incrementAndGet();
        consecutiveMisses++;
        if (consecutiveMisses == 3) {
            Notification n = new Notification("ConsecutiveMisses", this, sequenceNumber++,
                    System.currentTimeMillis(), "the user made 3 misses in a row");
            sendNotification(n);
            consecutiveMisses = 0;
        }
    }

    @Override
    public void resetConsecutiveMisses() {
        consecutiveMisses = 0;
    }

    @Override
    public void resetAndInitializeCounts() {
        totalPoints.set(0);
        missedPoints.set(0);
        consecutiveMisses = 0;
        initializeCounts();
    }
}