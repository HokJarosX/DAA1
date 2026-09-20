public class MergeSort {
    static int[] Merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){

            if(left[i] <= right[j]){
                result[k] = left[i];
                i++;
            }
            else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length){
        result[k] = left[i];
        i++;
        k++;
        }
        while(j < right.length){
            result[k] = right[j];
            j++;
            k++;
    }
    return result;
    }

    static int[] MergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] l = new int[mid];

        for(int i = 0; i < mid; i++){
            l[i] = arr[i];
        }

        int[] r = new int[arr.length-mid];
        for(int i = mid; i < arr.length; i++){
            r[i-mid] = arr[i];
        }

        l = MergeSort(l);
        r = MergeSort(r);

        return Merge(l, r);


    }




}
