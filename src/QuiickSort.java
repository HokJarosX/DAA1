import java.util.Random;

class QuickSort {

    static Random rnd = new Random();

    static int depth = 0, maxDepth = 0;
    static long comparisons = 0;

    static void reset() { depth = 0; maxDepth = 0; comparisons = 0; }

    public static void quickSort(int[] arr, int l, int r) {
        depth++;
        if (depth > maxDepth) maxDepth = depth;

        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
        depth--;
    }

    public static int partition(int[] arr, int l, int r) {
        int randomIndex = l + rnd.nextInt(r - l + 1);
        swap(randomIndex, r, arr);

        int pivot = arr[r];
        int ptr = l - 1;

        for (int i = l; i < r; i++) {
            comparisons++;
            if (arr[i] < pivot) {
                ptr++;
                swap(ptr, i, arr);
            }
        }
        swap(ptr + 1, r, arr);
        return ptr + 1;
    }

    static void swap(int ptr, int i, int[] arr) {
        int temp = arr[ptr];
        arr[ptr] = arr[i];
        arr[i] = temp;
    }
}