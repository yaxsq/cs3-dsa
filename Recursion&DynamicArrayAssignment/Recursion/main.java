public class main {

    private static int countTask2 = 0;
    private static int stackCall = 0;

    public static void main(String[] args) {
        //TOWER OF HANOI
        towerOfHanoi(4, 0, 3, 2);
        System.out.println("\nTOI Iterations: " + countTask2);

        //FIND MAX
        int[] arr = {4, 7, 2, 1, 7, 8, 3, 0, 9};
        System.out.println("MAX > " + findMax(arr, 0) + "\n");

        //POWER
        System.out.println("2^0   " + power(2, 0));
        System.out.println("2^1   " + power(2, 1));
        System.out.println("2^2   " + power(2, 2));
        System.out.println("2^8   " + power(2, 8));
        System.out.println("2^-1  " + power(2, -1));
        System.out.println("2^-3  " + power(2, -3));

    }

    private static void towerOfHanoi(int n, int from, int to, int aux) {
        countTask2++;
        stackCall++;
        System.out.println("STACK CALL >>>>>>>>>> " + stackCall);
        if (n == 1) {
            System.out.println("D1 goes from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        stackCall--;
        System.out.println("D" + n + " goes from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, to, from);
        stackCall--;
    }

    private static int findMax(int[] arr, int index) {
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        return Math.max(arr[index], findMax(cutArray(arr, 1, arr.length), 0));
    }

    private static int power(int base, int power) {
        if (power == 0) {
            return 1;
        }
         else if (power == 1) {
            return base;
        }
        if (power > 1) {
            return base  * power(base, power-1);
        }
        return 0;
    }

    /**
     * @param arr   array to be cut
     * @param start starting index - inclusive
     * @param end   ending index - exclusive
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

}
