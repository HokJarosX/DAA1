import java.util.*;

public class Arraygenerator {

    static Random rnd = new Random(42);

    public static int[] randomArray(int n, int bound) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(bound) - bound / 2;
        return arr;
    }

    public static int[] sortedArray(int n) {
        int[] arr = randomArray(n, Math.max(10, n * 10));
        Arrays.sort(arr);
        return arr;
    }

    public static int[] reverseSortedArray(int n) {
        int[] arr = sortedArray(n);
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;
        }
        return arr;
    }

    public static int[] duplicateHeavyArray(int n) {
        int[] arr = new int[n];
        int distinctValues = Math.max(1, n / 20);
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(distinctValues);
        return arr;
    }

    public static Point[] randomPoints(int n, double bound) {
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) {
            pts[i] = new Point(rnd.nextDouble() * bound, rnd.nextDouble() * bound);
        }
        return pts;
    }
}