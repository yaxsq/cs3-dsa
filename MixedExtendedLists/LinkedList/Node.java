public class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * ONLY FOR TESTING
     * @return data stored in node
     */
    public T getData() {
        return this.data;
    }

}

