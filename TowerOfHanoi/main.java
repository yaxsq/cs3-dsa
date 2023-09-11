public class main {

//    private static int countTask1 = 0;
    private static int countTask2 = 0;

    public static void main(String[] args) {

        //RECURSIVE FUNCTION
        int[] arr = new int[30];
        fillRandInt(arr);

        System.out.println("BINARY: " + binaryRecursiveSearch(arr, getRandElement(arr)));

        /*
        System.out.println("COUNT: " + countTask1);
        countTask1 = 0;

        System.out.println("BINARY: " + binaryRecursiveSearch(arr, getRandElement(arr)));
        System.out.println("COUNT: " + countTask1);
        countTask1 = 0;

        System.out.println("BINARY: " + binaryRecursiveSearch(arr, getRandElement(arr)));
        System.out.println("COUNT: " + countTask1);
        countTask1 = 0;
         */

        /****/

        //BINARY RECURSIVE FUNCTION
        //TOWER OF HANOI

        towerOfHanoi(6, 0, 3, 2);
        System.out.println("\nTOI Iterations: " + countTask2);

    }

    private static void towerOfHanoi(int n, int from, int to, int aux) {
        countTask2++;
        if (n == 1) {
            System.out.println("D1 goes from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("D" + n + " goes from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }

    private static int binaryRecursiveSearch(int[] arr, int n) {
//        countTask1++;

        if (arr.length == 0) {
            return 0;
        } else if (arr.length < 1 && arr[0] == n) {                //if the only element is n
            return 1;
        } else if (arr[arr.length / 2] == n) {              //if the mid is n
            return 1;
        } else if (n < arr[arr.length / 2]) {                        //if lower half
            return (1 + binaryRecursiveSearch(cutArray(arr, 0, arr.length / 2), n));
        } else if (n >= arr[arr.length / 2]) {                        //if upper half
            return (1 + binaryRecursiveSearch(cutArray(arr, (arr.length / 2) + 1, arr.length), n));
        } else {
            System.out.println("Not found");
            System.exit(1);
            return -1;
        }
    }

    /**
     * @param arr   array to be cut
     * @param start starting index
     * @param end   ending index
     * @return new array with elements from the previous array's start and end index
     */
    private static int[] cutArray(int[] arr, int start, int end) {
        int[] tempArr = new int[end - start];
        int index = 0;

        for (int i = start; i < end; i++) {
            if (index < tempArr.length) {
                tempArr[index++] = arr[i];
            }
        }

        return tempArr;
    }

    /**
     * fills the array with random values upto its size*
     *
     * @param arr array to fill values in
     */
    private static void fillRandInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.round(Math.random() * (101)));      //setting each value to a random int bw 0 and 100
        }
    }

    private static int getRandElement(int[] arr) {
        return arr[(int) (Math.floor(Math.random() * arr.length))];
    }

}
