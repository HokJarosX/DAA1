import java.util.Arrays;
class Main{
    public static void main(String[] args){
        int[] arr = new int[]{1, 4, 7, 5, 7, 2, 6, 8, 1, 4};
        arr = MergeSort.MergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
