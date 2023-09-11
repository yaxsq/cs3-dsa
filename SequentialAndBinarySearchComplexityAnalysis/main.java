import java.util.Collection;

public class main {

    private static final int n = 100;                                 //array size

    public static void main(String[] args) {

        int[] arr = new int[n];
        fillRandInt(arr);                               //setting up the array
        removeDuplicates(arr);
        sort(arr);

        int search = getRandElement(arr);

        long T1Linear = System.nanoTime();                      //time log
        int linearIterations = linearSearch(arr, search);
        long T2Linear = System.nanoTime();                      //time log

        long T1Binary = System.nanoTime();                      //time log
        int binaryIterations = binarySearch(arr, search);
        long T2Binary = System.nanoTime();                      //time log

        System.out.println("N: " + n);
        System.out.println("Searching for: " + search);
        System.out.println("LINEAR ITERATIONS: " + linearIterations);
        System.out.println("BINARY ITERATIONS: " + binaryIterations);
        System.out.println("Linear time in NS: " + (T2Linear - T1Linear));
        System.out.println("Binary time in NS: " + (T2Binary - T1Binary));

    }


    /**
     * fills the array with random values upto its size
     *
     * @param arr array to fill values in
     */
    private static void fillRandInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.round(Math.random() * (n + 1)));      //setting each value to a random int
        }
    }

    /**
     * sets duplicate values to zero in the array input
     *
     * @param arr array to remove duplicate values from
     */
    private static void removeDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            linearSearchForDupes(arr, arr[i]);          //searches for every value in the array to find a separate instance of it
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
//                    arr[j] = 0;                                     //setting every duplicate to zero
                    arr[j] = (int) (1 + Math.round(Math.random() * (n + 1)));      //setting duplicate value to a random int
                }
            }
        }
    }

    /**
     * @param arr array to search from
     * @param n   value to be searched
     * @return iterations it took for that value
     */
    private static int linearSearch(int[] arr, int n) {
        int count = 0;                                              //counts iterations

        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == n) {
                return count;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] arr, int n) {
        int count = 0;
        int start = 0, stop = arr.length, mid = (arr.length / 2);

        while (stop > start) {                                      //while array still exists
            if (arr[mid] == n) {
                return count++;                                     //return if value is in the middle
            } else {
                count++;
                if (n < arr[mid]) {                                 //if value lies towards the left
                    stop = mid;
                    mid = (start + stop) / 2;                           //shifting the search to the left
                } else {
                    start = mid;
                    mid = (start + stop) / 2;
                }
            }
        }

        return count;
    }

    /**
     * sorts the ints in an array in ascending order
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * @param arr
     * @return a random value from the array
     */
    private static int getRandElement(int[] arr) {
        return arr[(int) (Math.floor(Math.random() * arr.length))];
    }


    /*
    private void linearSearchForDupes(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                arr[i] = Integer.parseInt(null);
            }
        }
    }
     */

}
