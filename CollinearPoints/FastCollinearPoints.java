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

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private int segmentsCount = 0;
    private int segmentSize = 10;
    private LineSegment[] segmentArray = new LineSegment[segmentSize];

    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points
        if (points == null)
            throw new IllegalArgumentException();
        int size = points.length;

        for (int i = 0; i < size; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException();
            for (int j = 0; j < size; j++) {
                if (points[j] == null)
                    throw new IllegalArgumentException();
                if (i != j) {
                    if (points[i].compareTo(points[j]) == 0)
                        throw new IllegalArgumentException("Same Points");
                }
            }
        }
    }

    private void resizeSegmentArray() {
        LineSegment[] copy = new LineSegment[segmentArray.length * 2];
        System.arraycopy(segmentArray, 0, copy, 0, segmentArray.length);
        segmentArray = copy;
    }

    private void genFastCollinearPoints(Point[] points, int size) {
        // todo()
        ArrayList<Integer> segmentArrayList = new ArrayList<Integer>();
        for (int p = 0; p < size; p++) {
            // swap point[p] with point[0] to always have current item at zeroth index
            Point tempPoint = points[p];
            points[p] = points[0];
            points[0] = tempPoint;

            // copy the array
            Point[] sorted = points.clone();
            Arrays.sort(sorted, 1, size, tempPoint.slopeOrder());

            double previousSlope = tempPoint.slopeTo(sorted[1]);

            int segmentLengthTracker = 1;

            segmentArrayList.clear();
            segmentArrayList.add(0);
            segmentArrayList.add(1);

            // what start at index 2?
            int minimumSegment = 2;
            for (int q = 2; q < size; q++) {
                double newSlope = tempPoint.slopeTo(sorted[q]);
                // slope doesn't match the end of the array?
                if (previousSlope != newSlope || q == size - 1) {
                    Point lastPoint = sorted[q - 1];
                    if (q == size - 1 && previousSlope == newSlope) {
                        lastPoint = sorted[q];
                        segmentArrayList.add(q);
                        segmentLengthTracker++;
                    }

                    // ignore -ve slopes
                    if (segmentLengthTracker > minimumSegment) {
                        Point maxP, minP;
                        maxP = minP = tempPoint;
                        for (int innerCSegTracker : segmentArrayList) {
                            if (sorted[innerCSegTracker].compareTo(maxP) > 0)
                                maxP = sorted[innerCSegTracker];

                            if (sorted[innerCSegTracker].compareTo(minP) <= 0)
                                minP = sorted[innerCSegTracker];
                        }

                        if (segmentLengthTracker == segmentArray.length)
                            resizeSegmentArray();
                        if (tempPoint.compareTo(minP) == 0) {
                            segmentArray[segmentsCount] = new LineSegment(minP, maxP);
                            segmentsCount++;
                        }
                    }
                    segmentLengthTracker = 1;
                    segmentArrayList.clear();
                    ;
                    segmentArrayList.add(0);
                    segmentArrayList.add(q);
                } else {
                    segmentLengthTracker++;
                    segmentArrayList.add(q);
                }
                previousSlope = newSlope;
            }
        }
    }


    public int numberOfSegments() {
        // the number of line segments
        return segmentsCount;
    }

    public LineSegment[] segments() {
        // the line segments
        LineSegment[] copy = new LineSegment[segmentsCount];
        int count = 0;
        for (LineSegment segment : segmentArray) {
            if (segment != null) {
                copy[count] = segment;
                count++;
            }
        }
        // were all values copied?
        assert (count == segmentsCount);
        return copy;
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
