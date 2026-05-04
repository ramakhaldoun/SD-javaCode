import java.util.Arrays;

/**
 * Demonstrates two classic sorting algorithms: Quick Sort and Merge Sort.
 *
 * @author  Rama Khaldoun
 * @version 1.0
 */
public class SortExample {

    /**
     * Entry point of the program. Sorts two sample arrays and prints the results.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Unsorted arrays for testing
        Integer[] array1 = { 12, 13, 24, 10, 3, 6, 90, 70 };
        int[] array2 = { 2, 6, 3, 5, 1 };

        // Sort the first array using Quick Sort
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        // Sort the second array using Merge Sort
        mergeSort(array2, array2.length);
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an Integer array in ascending order using the Quick Sort algorithm.
     *
     * @param arr  the array to be sorted
     * @param low  the starting index of the sub-array
     * @param high the ending index of the sub-array
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        // Check for empty or null array
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        // Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Partition: make left < pivot and right > pivot
        int i = low;
        int j = high;
        while (i <= j) {
            // Move i forward while elements are less than pivot
            while (arr[i] < pivot) {
                i++;
            }
            // Move j backward while elements are greater than pivot
            while (arr[j] > pivot) {
                j--;
            }
            // Swap the elements and move both iterators
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Recursively sort the two sub-arrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an Integer array.
     *
     * @param array the array containing the elements
     * @param x     the index of the first element
     * @param y     the index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an int array in ascending order using the Merge Sort algorithm.
     *
     * @param a the array to be sorted
     * @param n the length of the array (or sub-array) to sort
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // Copy data to left and right sub-arrays
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }

        // Recursively sort each half
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        // Merge the sorted halves
        merge(a, left, right, mid, n - mid);
    }

    /**
     * Merges two sorted sub-arrays into a single sorted array.
     *
     * @param a     the destination array to hold the merged result
     * @param l     the left sorted sub-array
     * @param r     the right sorted sub-array
     * @param left  the length of the left sub-array
     * @param right the length of the right sub-array
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks whether an int array is sorted in ascending order.
     *
     * @param x the array to check
     * @return  true if the array is sorted, false otherwise
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}