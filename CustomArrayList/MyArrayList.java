public class MyArrayList<T> {

    //arr = (T[]) new Comparable[size]

    private T[] arr;
    private int currIndex;

    /**
     * constructor
     */

    public MyArrayList() {
        arr = (T[]) new Object[10];
        currIndex = -1;
    }

    /**
     * constructor which inputs size
     *
     * @param size int for array size
     */
    public MyArrayList(int size) {
        arr = (T[]) new Object[size];
        currIndex = -1;
    }

    public void add(T data) {
        if (currIndex < arr.length - 1) {                 //if the currentIndex is within the size, add the data to the end
            arr[++currIndex] = data;
        } else {
            System.out.println("Increasing size!");
            T[] tempArr = (T[]) new Object[arr.length + 5];     //making a new array
            for (int i = 0; i < arr.length; i++) {
                tempArr[i] = arr[i];                            //copying all values frmo the old array to the new one
            }
            currIndex = arr.length;                             //updating current index
            tempArr[currIndex++] = data;                        //adding the new value to the new array
            arr = tempArr;                                      //updating the arr reference
        }
    }

    /**
     * @param value value to be found in the array
     * @return index if found, -1 otherwise
     */
    public int find(T value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * sets the value of the element to null if found in the array
     */
    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }

        //USED FOR CLEARING A SINGLE ELEMENT
        /*  //T value is an input
        int index = find(value);

        if (index != -1) {
            arr[index] = null;
            return;
        }

        System.out.println("Value not found");
         */
    }

    /**
     * @param index location in the array
     * @return the value in that location
     */
    public T get(int index) {
        if (index < arr.length && index > 0) {
            return arr[index];
        }
        System.out.println("Invalid index");
        return null;
    }

    /**
     * @param index index of the element to be updated
     * @param value value to tbe updated to
     */
    public void update(int index, T value) {
        if (index > -1 && index < arr.length) {
            arr[index] = value;
        } else {
            System.out.println("Invalid index");
        }
    }

    public void remove(T value) {
        int index = find(value);
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] != null) {
                if (arr[i].equals(value)) {
                    arr[i] = null;
                }
            }
        }
    }

    /**
     * @return all elements in the array
     */
    public String toString() {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i] + " ";
        }

        return str;
    }

}
