import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 100000;
        Random rnd = new Random();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(1000000);

        // MergeSort
        int[] a = arr.clone();
        MergeSort.reset();
        long t0 = System.nanoTime();
        MergeSort.MergeSort(a);
        long t1 = System.nanoTime();
        System.out.println("MergeSort: time=" + (t1 - t0) + " ns, maxDepth=" + MergeSort.maxDepth
                + ", comparisons=" + MergeSort.comparisons);

        // QuickSort
        int[] b = arr.clone();
        QuickSort.reset();
        long t2 = System.nanoTime();
        QuickSort.quickSort(b, 0, b.length - 1);
        long t3 = System.nanoTime();
        System.out.println("QuickSort: time=" + (t3 - t2) + " ns, maxDepth=" + QuickSort.maxDepth
                + ", comparisons=" + QuickSort.comparisons);


        int[] c = arr.clone();
        DeterministicSelect.reset();
        int k = n / 2;
        long t4 = System.nanoTime();
        DeterministicSelect.select(c, 0, c.length - 1, k);
        long t5 = System.nanoTime();
        System.out.println("Select: time=" + (t5 - t4) + " ns, maxDepth=" + DeterministicSelect.maxDepth
                + ", comparisons=" + DeterministicSelect.comparisons);


        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) pts[i] = new Point(rnd.nextDouble() * 1000, rnd.nextDouble() * 1000);

        ClosestPair.reset();
        long t6 = System.nanoTime();
        ClosestPair.closestPair(pts);
        long t7 = System.nanoTime();
        System.out.println("ClosestPair: time=" + (t7 - t6) + " ns, maxDepth=" + ClosestPair.maxDepth
                + ", comparisons=" + ClosestPair.comparisons);
    }
}