import java.util.Arrays;

public class DeterministicSelect {

    static int depth = 0, maxDepth = 0;
    static long comparisons = 0;

    static void reset() { depth = 0; maxDepth = 0; comparisons = 0; }

    public static int select(int[] arr, int left, int right, int k) {
        depth++;
        if (depth > maxDepth) maxDepth = depth;

        int result;
        if (left == right) {
            result = arr[left];
        } else {
            int pivot = medianOfMedians(arr, left, right);
            int pivotIndex = partition(arr, left, right, pivot);

            if (k == pivotIndex) result = arr[k];
            else if (k < pivotIndex) result = select(arr, left, pivotIndex - 1, k);
            else result = select(arr, pivotIndex + 1, right, k);
        }
        depth--;
        return result;
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) return findMedian(arr, left, right);

        int numGroups = (n + 4) / 5;
        int[] medians = new int[numGroups];
        for (int i = 0; i < numGroups; i++) {
            int groupLeft = left + i * 5;
            int groupRight = Math.min(groupLeft + 4, right);
            medians[i] = findMedian(arr, groupLeft, groupRight);
        }
        return select(medians, 0, numGroups - 1, numGroups / 2);
    }

    private static int findMedian(int[] arr, int left, int right) {
        Arrays.sort(arr, left, right + 1);
        return arr[left + (right - left) / 2];
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        for (int i = left; i <= right; i++) {
            comparisons++;
            if (arr[i] == pivot) { swap(arr, i, right); break; }
        }
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            comparisons++;
            if (arr[i] < pivot) { swap(arr, storeIndex, i); storeIndex++; }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}