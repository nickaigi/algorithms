/*
 * A faster, sorting-based solution. Remarkably, it is possible to solve the problem much faster than the brute-force
 * solution described above. Given a point p, the following method determines whether p participates in a set of 4 or
 * more collinear points.
 *      - Think of p as the origin.
 *      - For each other point q, determine the slope it makes with p.
 *      - Sort the points according to the slopes they makes with p.
 *      - Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. If so,
 *        these points, together with p, are collinear.
 *
 * Applying this method for each of the n points in turn yields an efficient algorithm to the problem. The algorithm
 * solves the problem because points that have equal slopes with respect to p are collinear, and sorting brings such
 * points together. The algorithm is fast because the bottleneck operation is sorting.
 * */

public class FastCollinearPoints {
    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points
        if (points == null)
            throw new IllegalArgumentException();
    }

    public int numberOfSegments() {
        // the number of line segments
    }

    public LineSegment[] segments() {
        // the line segments
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
