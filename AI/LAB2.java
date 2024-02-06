// Bubble Sort, Merge Sort

import java.util.Arrays;

public class LAB2{
    public static void main(String[] args) {
        int[] myArray = {2, 5, 4,  8, 9};
        // bubbleSort(myArray);
        mergeSort(myArray, 0, myArray.length - 1);
        System.out.println(Arrays.toString(myArray));
    }

    // WORST CASE TC: O(N2)
    // Stable sorting algorithm
    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // WORST CASE TC: O(N logN)
    // Stable sorting algorithm
    static void mergeSort(int[] arr, int s, int e){
        if(s < e){
            int m = (s + e)/2;
            mergeSort(arr, s, m);
            mergeSort(arr, m+1, e);
            mergeInPlace(arr, s, m, e);
        } else {
            return;
        }
    }

    static void mergeInPlace(int[] arr, int s, int m, int e){
        // left array -> [s, m - 1]
        // right array -> [m, e]
        int i = s, j = m, k = 0;
        int[] merged = new int[e - s + 1];

        while(i <= m - 1 && j <= e){
            if(arr[i] <= arr[j]){
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }

        while(i <= m - 1){
            merged[k++] = arr[i++];
        }

        while(j <= e){
            merged[k++] = arr[j++];
        }

        k = 0;
        while(s < e){
            arr[s++] = merged[k++];
        }
    }


}