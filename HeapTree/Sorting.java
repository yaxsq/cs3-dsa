public class Sorting<T extends Comparable<T>> {

    T[] arr;

    public void buildHeap(T[] arr) {
        this.arr = arr;

        for (int i = (arr.length / 2) - 1; i > -1; i--) {
            heapify(i);
        }
    }

    public void delete(T value) {
        int index = find(value);                    // getting index of value to be deleted

        if (index == -1) {
            System.out.println("Invalid value");
            return;
        }

        arr[index] = arr[arr.length-1];
        arr[arr.length-1] = null;
        heapify(index);
    }


    private int find(T value) {
        for (int i = 0; i < arr.length; i++ ) {
            if (arr[i] == null) {
                continue;
            }
            if (arr[i].equals(value) || arr[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }

    private void heapify(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        try {
            if (left < arr.length && arr[left].compareTo(arr[largest]) > 0) {           // checks if left is higher, then saves largest
                largest = left;
            }

            if (right < arr.length && arr[right].compareTo(arr[largest]) > 0) {         // checks if right is higher then overwrites largest
                largest = right;
            }

            if (largest != i) {                             // if i and largest are not the same / if there is a larger element at left or right
                T temp = arr[i];
                arr[i] = arr[largest];                      // swapping
                arr[largest] = temp;

                heapify(largest);                               // calls itself again to go through all children
            }
        } catch (NullPointerException ex) {}
    }

//    private int getLastIndex() {
//        for (int i = arr.length-1; i > -1; i--) {
//            if (arr[i] != null || (int)arr[1] != 0) {
//                return i;
//            }
//        }
//        return -1;
//    }

    private int left(int i) {
        return (2*i)+1;
    }

    private int right(int i) {
        return (2*i)+2;
    }

    private int parent(int i) {
        return (i-1)/2;
    }

}

//        for (int i = 0; i < arr.length; i++) {
//            int parent = parent(i);
//            while (parent >= 0) {
//                if (i > parent) {
//                    T temp = arr[i];
//                    arr[i] = arr[parent];
//                    arr[parent] = temp;
//                }
//            }
//        }


//    public void delete(T value) {
//        int index = find(value);                        // getting index of value to be deleted
//
//        if (index > -1) {
//            int iLast = getLastIndex();                 // getting index of the last element input
//
//            T temp = arr[index];
//            arr[index] = arr[iLast];                    // replacing the deletion node with the last node
//            arr[iLast] = temp;
//
//            arr[iLast] = null;                          // deleting the last node
//
//            buildHeap(arr);                             // fixing the heap
//        } else {
//            System.out.println("Invalid value");
//        }
//    }
