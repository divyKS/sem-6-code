// Insertion Sort, Selection Sort, Quick Sort

import java.util.Arrays;

public class LAB1{
    public static void main(String[] args) {
        int[] myArray = {2,3,1,2,5,6,7,8,-10};
        quickSort(myArray, 0 , myArray.length - 1);
        System.out.println(Arrays.toString(myArray));
    }

    // WORST CASE TC: O(N2)
    // BEST CASE TC: O(N)
    // Efficient for small, partially sorted arrays
    // Stable sorting algorithm
    static void insertionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j >= 1; j--){
                if(arr[j - 1] > arr[j]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    // TC: O(N2)
    // Efficient for small arrays
    // Does a maximum of O(N) swaps. Useful is memory write is costly.
    // Unstable sorting algorithm
    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int indexOfSmallest = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[indexOfSmallest]){
                    indexOfSmallest = j;
                }
            }
            if(indexOfSmallest != i){
                int temp = arr[i];
                arr[i] = arr[indexOfSmallest];
                arr[indexOfSmallest] = temp;
            }
        }
    }

    // WORST CASE TC: O(N2) when the pivot divides the array into highly imbalanced parts
    // BEST CASE TC: O(N logN) when the pivot divides the array into roughly equal halves
    // Efficient for larger arrays
    // Unstable sorting algorithm
    static void quickSort(int[] arr, int s, int e){
        if(s < e){
            int pivotIndex = partition(arr, s, e);
            quickSort(arr, s, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, e);
        }
    }

    static int partition(int[] arr, int s, int e){
        int pivot = arr[e];
        int i = s - 1;
        for(int j = s; j <= e - 1; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);                
            }
        }
        swap(arr, i + 1, e);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}