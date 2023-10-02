public class ArrayStack<T extends Comparable<T>> {

    private T[] stackList;
    private int top;

    public ArrayStack(int size) {
        stackList = (T[]) new Comparable[size];
        top = -1;
    }

    public void push(T c) {
        if (top + 1 < stackList.length) {
            stackList[++top] = c;                           //increases top and updates the new node to the value
//            System.out.println("PUSHED " + stackList[top]);
        } else {
            System.out.println("STACK FULL");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            T data = stackList[top];
            stackList[top--] = null;
            return data;                        //returns the data at top and decreases it
        }
        return null;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (top == stackList.length - 1) {
            return true;
        }
        return false;
    }

    public void print() {
        System.out.print(">>> ");
        for (int i = 0; i < stackList.length; i++) {
            System.out.print(stackList[i] + " < ");
        }
        System.out.println();
    }

}
