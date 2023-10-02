public class LinkedStack<T> {

    LinkedStackNode<T> top;

    public void push(T c) {
        if (top == null) {
            top = new LinkedStackNode<>(c);                     //if null, creates a new node and sets it to top
        } else {
            LinkedStackNode node = new LinkedStackNode(c);
            node.next = top;                                    //makes a new node and updates top to the new node
            top = node;
        }
//        System.out.println("PUSHED " + top.value);
    }

    public T pop() {
        if (top == null) {
            System.out.println("EMPTY STACK");
            return null;
        } else {
            T data = top.value;
            top = top.next;
            return data;
        }
    }

    public T peek() {
        if (top == null) {
            System.out.println("EMPTY STACK");
            return null;
        } else {
            return top.value;
        }
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public int size() {
        int i = 0;
        LinkedStackNode lsn = top;

        while (lsn != null) {
            i++;
            lsn = lsn.next;
        }
        return i;
    }

    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String list = ">>> ";
        LinkedStackNode<T> node = top;
        while (node != null) {
            list += node.value + " < ";
            node = node.next;
        }
        return list;
    }
}
