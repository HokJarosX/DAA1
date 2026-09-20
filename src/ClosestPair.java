import java.util.*;

public class ClosestPair {

    static int depth = 0, maxDepth = 0;
    static long comparisons = 0;

    static void reset() { depth = 0; maxDepth = 0; comparisons = 0; }

    static double distance(Point a, Point b) {
        comparisons++;
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    static Result bruteForce(Point[] points, int lo, int hi) {
        double minDist = Double.MAX_VALUE;
        Point bp1 = null, bp2 = null;
        for (int i = lo; i < hi; i++) {
            for (int j = i + 1; j < hi; j++) {
                double d = distance(points[i], points[j]);
                if (d < minDist) { minDist = d; bp1 = points[i]; bp2 = points[j]; }
            }
        }
        return new Result(minDist, bp1, bp2);
    }

    static Result stripClosest(List<Point> strip, Result best) {
        double minDist = best.dist;
        Point bp1 = best.p1, bp2 = best.p2;
        int n = strip.size();
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && (strip.get(j).y - strip.get(i).y) < minDist) {
                double d = distance(strip.get(i), strip.get(j));
                if (d < minDist) { minDist = d; bp1 = strip.get(i); bp2 = strip.get(j); }
                j++;
            }
        }
        return new Result(minDist, bp1, bp2);
    }

    static Result closestPairRec(Point[] points, int lo, int hi) {
        depth++;
        if (depth > maxDepth) maxDepth = depth;

        int n = hi - lo;
        Result out;
        if (n <= 3) {
            out = bruteForce(points, lo, hi);
        } else {
            int mid = lo + n / 2;
            Point midPoint = points[mid];

            Result left = closestPairRec(points, lo, mid);
            Result right = closestPairRec(points, mid, hi);
            Result best = left.dist <= right.dist ? left : right;

            List<Point> strip = new ArrayList<>();
            for (int i = lo; i < hi; i++) {
                if (Math.abs(points[i].x - midPoint.x) < best.dist) strip.add(points[i]);
            }
            strip.sort((a, b) -> Double.compare(a.y, b.y));

            Result stripBest = stripClosest(strip, best);
            out = stripBest.dist < best.dist ? stripBest : best;
        }
        depth--;
        return out;
    }

    public static Result closestPair(Point[] points) {
        Point[] sorted = points.clone();
        Arrays.sort(sorted, (a, b) -> Double.compare(a.x, b.x));
        return closestPairRec(sorted, 0, sorted.length);
    }
}