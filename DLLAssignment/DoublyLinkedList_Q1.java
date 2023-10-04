public class DoublyLinkedList_Q1 {

    Node head;
    Node tail;

    public DoublyLinkedList_Q1() {
        this.head = null;
        this.tail = null;
    }

    /**
     * inserts the value while maintaining an ascending order
     */
    public void add(String title, String year) {
        if (head == null) {
            head = new Node(title, year);
            tail = head;
        } else {
            tail.next = new Node(title, year);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    /**
     * @param title movie to be found
     * @return first node containing that value
     */
    public Node find(String title) {
        Node current = head;

        while (current != null) {                      //traversing through the list
            if (current.title.equalsIgnoreCase(title)) {                        //if the value exists
                return current;
            }
            current = current.next;                             //navigating to the next node
        }

        System.out.println("Value >" + title + "< not found");
        return null;
    }

    /**
     * goes through the list and updates pointers to remove the node from the list
     *
     * @param title value to be deleted
     */
    public void delete(String title) {
        if (head == null) {                                             //if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (head.title.equalsIgnoreCase(title)) {                                  //if the first element is to be removed
            head = head.next;
            head.prev = null;                                 //updating the prev pointer of the second node to null
            System.out.println("Head removed");
            return;
        }

        if (tail.title.equalsIgnoreCase(title) && tail.prev != null) {             //if the last element is to be removed
            tail = tail.prev;
            tail.next = null;                                 //updating the last node's pointer to null
            return;
        }

        Node current = head;                                                       //if removing from the middle
        while (current.next != null && !(current.next.title.equalsIgnoreCase(title))) {
            current = current.next;                                     //traversing through all elements
        }
//        System.out.println("LEAVING: " + current.data + " CONDITION : " + (current.next != null && !current.next.data.equals(value)));

        if (current.next != null) {                         //if the node is not the last one
            current.next = current.next.next;                 //updating the next pointer of the current node to the node after the next in front of it
            if (current.next.next != null) {
                current.next.next.prev = current;                 //updating the prev pointer of the node after the node to be removed to the current node
            }
        } else {
            System.out.println("Value >" + title + "< not found");
        }
    }

    /**
     * resets the list by setting head and tail to null
     */
    public void clearList() {
        head = null;
        tail = null;
    }

    /**
     * @return true if head is null / false otherwise
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * @return amount of nodes in the list
     */
    public int length() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * prints the contents of the list
     */
    public void print() {
        System.out.println(">>> " + this.toString());
    }

    /**
     * @return string containing all the elements
     */
    public String toString() {
        Node current = head;
        String list = ">>> ";
        int i = 0;

        while (current != null) {                                   //goes through all nodes
            if (current.next != null) {
                list = list + current.title + " " + current.year + " " + current.cast + " > ";          //appends previous values with the current one
            } else {
                list = list + current.title + " " + current.year + " " + current.cast + " <";          //appends previous values with the current one
            }
            i++;
            if (i == 3) {
                i = 0;
                list += " <<\n";
            }
            current = current.next;                                 //updates current to the next node
        }
        list += "<<<";
        return list;
    }

}
