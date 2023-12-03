public class Main {

    public static void main(String[] args) {

        Integer[] arr = new Integer[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50);           // building a random int array
        }
        System.out.print("UNSORTED: ");
        print(arr);

        Sorting sort = new Sorting();
        sort.buildHeap(arr);                            // converting into a heap
        System.out.print("SORTED:   ");
        print(arr);

        print(arr);
        sort.delete(sort.arr[1]);                            // delete
        print(arr);
        sort.delete(sort.arr[4]);
        print(arr);
        sort.delete(sort.arr[5]);
        print(arr);

    }

    private static void print(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " > ");
        }
        System.out.println();
    }

}