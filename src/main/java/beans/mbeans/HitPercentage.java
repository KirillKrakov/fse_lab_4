package beans.mbeans;

public class HitPercentage implements HitPercentageMBean{
    private PointCounterMBean pointCounter;

    public HitPercentage(PointCounterMBean pointCounter) {
        this.pointCounter = pointCounter;
    }

    @Override
    public double getHitPercentage() {
        int totalPoints = pointCounter.getTotalPoints();
        int hittedPoints = pointCounter.getTotalPoints() - pointCounter.getMissedPoints();
        if (totalPoints == 0) {
            return 0;
        }
        return (double) hittedPoints / totalPoints * 100;
    }
}