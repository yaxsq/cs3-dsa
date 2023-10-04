public class DynamicArray<T> {

    private T[] arr;
    private int currIndex;

    /**
     * constructor
     */

    public DynamicArray() {
        arr = (T[]) new Object[1];
        currIndex = -1;
    }

    /**
     * constructor which inputs size
     *
     * @param size int for array size
     */
    public DynamicArray(int size) {
        arr = (T[]) new Object[size];
        currIndex = -1;
    }

    public void add(T data) {
        if (currIndex < arr.length - 1) {                 //if the currentIndex is within the size, add the data to the end
            arr[++currIndex] = data;
        } else {
            System.out.println("Increasing size!");
            T[] tempArr = (T[]) new Object[arr.length + 1];     //making a new array
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
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * sets the value of every element to null
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
        if (index < arr.length && index >= 0) {
            return arr[index];
        }
        System.out.println("Get - Invalid index");
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
            System.out.println("Update - Invalid index");
        }
    }

    /**
     * removes every instance of the value
     *
     * @param value value to be removed
     */
    public void removeAll(T value) {
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] != null) {
                if (arr[i].equals(value)) {
                    arr[i] = null;
                }
            }
        }
    }

    /**
     * @return true if array has no elements
     */
    public boolean isEmpty() {
        if (arr.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * @return the amount of non-null elements in the array
     */
    public int length() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * print the elements which are not null
     */
    public void print() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    /**
     * copies the previous array into a temporary array with size+1 and adds the value to the start
     *
     * @param data value to be inserted at [0]
     */
    public void addToFront(T data) {
//        if (this.length() == arr.length) {                          //if list is fully occupied
//            System.out.println("AT LIMIT");
        T[] tempArr = (T[]) new Object[arr.length + 1];             //making a new array
        for (int i = 0; i < arr.length; i++) {
            tempArr[i + 1] = arr[i];                                //copying all values from the old array to the new one
        }
        tempArr[0] = data;                                          //setting the first element to the value
        arr = tempArr;
//        } else if (this.length() < arr.length) {                    //if list has at least one empty element
//            if (arr[0] == null) {                                       //if first element is empty
//                System.out.println("FIRST ELE EMPTY");
//                arr[0] = data;
//            } else {
//                System.out.println("SHIFTING");
//                T temp;
//                for (int i = 0; i < arr.length-1; i++) {                 //if an empty element exists somewhere else in the list
//                    arr[i] = arr[i+1];
//                }
//            }
//        }
    }

    /**
     * copies the previous array into a temporary array with size+1 and adds the value to the end
     *
     * @param data value to be inserted at [arr.length-1]
     */
    public void addToEnd(T data) {
//        if (this.length() == arr.length) {                          //if array is fully occupied
//            System.out.println("AT LIMIT");
        T[] tempArr = (T[]) new Object[arr.length + 1];            //making a new array
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];                                   //copying all values from the old array to the new one
        }
        tempArr[tempArr.length - 1] = data;                        //adding the new element to the end
        arr = tempArr;
//        } else if (this.length() < arr.length) {
//            if (arr[arr.length - 1] == null) {
//                arr[arr.length - 1] = data;
//            }
//        }
    }

    /**
     * reverses the array
     */
    public void reverse() {
        int j = 0;
        T[] tempArr = (T[]) new Object[arr.length];             //making a new array
        for (int i = arr.length - 1; i > -1; i--) {
            if (j < arr.length) {
                tempArr[j++] = arr[i];
            }
        }
        arr = tempArr;
    }

    /**
     * removes the first occurrence of the value by moving in reverse
     *
     * @param value value to be removed
     */
    public void removeFirst(T value) {
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i].equals(value)) {
                arr[i] = null;
                return;
            }
        }
        System.out.println("Value not found");
    }

    public void sortStudents(DynamicArray<Student> students) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (students.get(i).compareTo(students.get(j)) > 0) {
                    Student tempStu = students.get(j);
                    students.update(j, students.get(i));
                    students.update(i, tempStu);
                }
            }
        }
    }

    public void printStudents(DynamicArray<Student> students) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
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
