import java.util.Random;
import java.util.Scanner;

/* Implement data sorting by Merge sort. Sort the data in ascending order.

Determine a running time dependence on the input size when data is randomly distributed. Use 3 small input sizes (20-150) and 3 large input sizes (>10 000); with the same data size run at least 10 tests.

Present the test results in a table and with graphs.

Perform analysis of test results, compare results with theoretical estimates.

Present conclusions.*/

// SVETLANA TRETJAKOVA HW2 IN ALGORITHMS
// MAIN RESOURCE WHICH I USED WAS geeksforgeeks.org theme - merge sort. As it was allowed by you to use other materials
// other functionality - loops etc. was made by me and help of stackoverflow
// time is calculated in nanoseconds

class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        System.arraycopy(arr, l + 0, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
    // create a method
    public MergeSort display() {
        System.out.println("Calculating Method execution time:");
        return null;
    }
    // Driver code
    public static void main(String[] args)
    {
        Random r = new Random();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of your array");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        //System.out.println("Given Array");
        //printArray(arr);

        // get the start time
        long start = System.nanoTime();
        // call the method

        MergeSort ob = new MergeSort();
        for(int i=0; i<10; i++){
            ob.sort(arr, 0, arr.length - 1);
            // get the end time
            long end = System.nanoTime();

            // execution time
            long execution = end - start;
            System.out.println("Execution time: " + execution + " nanoseconds");
        }
        //System.out.println("\nSorted array");
        //printArray(arr);
    }
}

