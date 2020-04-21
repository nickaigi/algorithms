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
        if (points == null)
            throw new IllegalArgumentException();
        int size = points.length;
        for (int i = 0; i < size; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("Null Points not allowed");
            }

            for (int j = i + 1; j < size; j++) {
                if (points[j] == null) {
                    throw new IllegalArgumentException("Null Points not allowed");
                }
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Same Points");
                }
            }
        }
    }

    private void genCollinearPoints(Point[] points, int size) {
        for (int p = 0; p < size; p++) {
            for (int q = 0; q < size; q++) {
                if (p == q)
                    continue;
                if (points[p].compareTo(points[q]) <= 0)
                    continue;
                double pSlopeQ = points[p].slopeTo(points[q]);
                for (int r = 0; r < size; r++) {
                    if (r == q || r == p)
                        continue;
                    if (points[p].compareTo(points[r]) <= 0)
                        continue;
                    if (points[q].compareTo(points[r]) <= 0)
                        continue;

                    double pSlopeR = points[p].slopeTo(points[r]);
                    if (pSlopeQ != pSlopeR)
                        continue;

                    for (int s = 0; s < size; s++) {
                        if (s == r || s == q || s == p)
                            continue;
                        if (points[p].compareTo(points[s]) <= 0)
                            continue;
                        if (points[q].compareTo(points[s]) <= 0)
                            continue;
                        if (points[r].compareTo(points[s]) <= 0)
                            continue;

                        double pSlopeS = points[p].slopeTo(points[s]);
                        if (pSlopeS != pSlopeR)
                            continue;

                        if (segmentsCount == segmentArray.length)
                            resizeSegArr();

                        segmentArray[segmentsCount++] = new LineSegment(points[p], points[s]);

                    }
                }
            }
        }
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
        LineSegment[] segmentsCopied = new LineSegment[segmentsCount];
        int count = 0;
        for (LineSegment segment : segmentArray) {
            if (segment != null) {
                segmentsCopied[count] = segment;
                count++;
            }
        }
        assert (count == segmentsCount);
        return segmentsCopied;
    }

    private void resizeSegArr() {
        LineSegment[] temp = new LineSegment[segmentArray.length * 2];
        System.arraycopy(segmentArray, 0, temp, 0, segmentArray.length);
        segmentArray = temp;
    }

    public static void main(String[] args) {
        Point p = new Point(5, 5);
        Point q = new Point(10, 10);
        Point r = new Point(15, 15);
        Point s = new Point(20, 20);

        Point[] points = {p, q, r, s};
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);

    }
}
