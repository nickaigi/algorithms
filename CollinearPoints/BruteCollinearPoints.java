/*
 * Write a program BruteCollinearPoints.java that examines 4 points at a time and checks whether they all lie on the
 * same line segment, returning all such line segments. To check whether the 4 points p, q, r, and s are collinear,
 * check whether the three slopes between p and q, between p and r, and between p and s are all equal
 * */
public class BruteCollinearPoints {
    private int segmentsCount = 0;
    private LineSegment[] segmentArray;

    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        if (points == null) throw new IllegalArgumentException();
    }

    private void genCollinearPoints(Point[] points, int size) {
    }

    public int numberOfSegments() {
        // the number of line segments
        return segmentsCount;
    }

    public LineSegment[] segments() {
        /*
         * The method segments() should include each line segment containing 4 points exactly once. If 4 points appear
         * on a line segment in the order p→q→r→s, then you should include either the line segment p→s or s→p
         * (but not both) and you should not include sub-segments such as p→r or q→r. For simplicity, we will not supply
         * any input to BruteCollinearPoints that has 5 or more collinear points.
         */
        // the line segments
    }
}
