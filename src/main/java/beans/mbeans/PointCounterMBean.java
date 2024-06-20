package beans.mbeans;

public interface PointCounterMBean {
    int getTotalPoints();
    int getMissedPoints();
    void incrementTotalPoints();
    void incrementMissedPoints();
    void resetConsecutiveMisses();
    void resetAndInitializeCounts();
}