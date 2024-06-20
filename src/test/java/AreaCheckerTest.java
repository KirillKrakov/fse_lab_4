import beans.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AreaCheckerTest {

    @Test
    public void testIsInAreaForRectangle() {
        Point p1 = new Point(-1, 2, 10,true,0,0);
        assertTrue(p1.isInArea());
        Point p2 = new Point(-5, 2, 8,false,0,0);
        assertFalse(p2.isInArea());
        Point p3 = new Point(Double.NEGATIVE_INFINITY,0,7,false,0,0);
        assertFalse(p3.isInArea());
        Point p4 = new Point(-1, 0, 8,false,0,0);
        assertTrue(p4.isInArea());
        Point p5 = new Point(0, 1, 6,false,0,0);
        assertTrue(p5.isInArea());
    }

    @Test
    public void testIsInAreaForSemiCircle() {
        Point p1 = new Point(2, 2, 3,false,0,0);
        assertTrue(p1.isInArea());
        Point p2 = new Point(4, 1, 4,false,0,0);
        assertFalse(p2.isInArea());
        Point p3 = new Point(1,Double.POSITIVE_INFINITY,2,false,0,0);
        assertFalse(p3.isInArea());
        Point p4 = new Point(3, 0, 2,false,0,0);
        assertFalse(p4.isInArea());
        Point p5 = new Point(0, 2, 5,false,0,0);
        assertTrue(p5.isInArea());
    }

    @Test
    public void testIsInAreaForTriangle() {
        Point p1 = new Point(-1, -2, 5,false,0,0);
        assertTrue(p1.isInArea());
        Point p2 = new Point(-6, -1, 12,false,0,0);
        assertFalse(p2.isInArea());
        Point p3 = new Point(Double.NaN,0,7,false,0,0);
        assertFalse(p3.isInArea());
        Point p4 = new Point(-4, 0, 8,false,0,0);
        assertTrue(p4.isInArea());
        Point p5 = new Point(0, -3, 3,false,0,0);
        assertTrue(p5.isInArea());
    }

    @Test
    public void testIsInEmptyArea() {
        Point p2 = new Point(2, -2, 12,false,0,0);
        assertFalse(p2.isInArea());
    }

}