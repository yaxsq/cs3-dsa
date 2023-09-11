public class LinkedList<T> {

    private Node<T> head;


    public LinkedList() {
        this.head = null;
    }

    /**
     * inserts the value to the end of the list by creating a new node
     *
     * @param value
     */
    public void insert(T value) {
        if (head == null) {                                 //if the list is empty
            head = new Node<>(value);
            return;
        }

        Node<T> current = head;
        while (current.next != null) {                      //traversing through the list to find the end
            current = current.next;
        }
        current.next = new Node<T>(value);
    }

    public boolean find(T value) {
        Node<T> current = head;

        while (current != null) {                      //traversing through the list
            if (current.data.equals(value)) {                        //if the value exists
                return true;
            }
            current = current.next;                             //navigating to the next node
        }

        return false;
    }

    /**
     * resets the list
     */
    public void clear() {
        head = null;
    }

    /**
     * deletes the first instance of the value in the parameter
     *
     * @param value data to be removed
     */
    public void delete(T value) {
        if (head == null) {                                             //if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (head.data.equals(value)) {                                  //if the first element is to be removed
            head = head.next;
            System.out.println("Head removed");
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;                                     //traversing through all elements
        }
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Value not found");
        }

    }

    /**
     * @return string containing all the elements
     */
    public String toString() {
        Node<T> current = head;
        String list = "";

        while (current != null) {                       //goes through all nodes
            list = list + current.data.toString() + " " + current.getData() + " > ";          //appends previous values with the current one
            current = current.next;                     //updates current to the next node
        }
        return list;
    }

}