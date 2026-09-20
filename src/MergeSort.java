public class MergeSort {

    static int depth = 0, maxDepth = 0;
    static long comparisons = 0;

    static void reset() { depth = 0; maxDepth = 0; comparisons = 0; }

    static int[] Merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            comparisons++;
            if(left[i] <= right[j]){
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){ result[k] = left[i]; i++; k++; }
        while(j < right.length){ result[k] = right[j]; j++; k++; }
        return result;
    }

    static int[] MergeSort(int[] arr){
        depth++;
        if (depth > maxDepth) maxDepth = depth;

        if (arr.length <= 1) {
            depth--;
            return arr;
        }
        int mid = arr.length / 2;
        int[] l = new int[mid];
        for (int i = 0; i < mid; i++) l[i] = arr[i];

        int[] r = new int[arr.length - mid];
        for (int i = mid; i < arr.length; i++) r[i - mid] = arr[i];

        l = MergeSort(l);
        r = MergeSort(r);
        int[] res = Merge(l, r);

        depth--;
        return res;
    }
}