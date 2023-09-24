public class DoubleLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        this.head = null;
    }

    /**
     * inserts the value at the end of the list
     *
     * @param value value to be inserted
     */
    public void insertInOrder(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (value.compareTo(head.data) <= 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (value.compareTo(tail.data) >= 0) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && value.compareTo(current.next.data) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    /**
     * @param value value to be found
     * @return node containing that value
     */
    public Node<T> find(T value) {
        Node<T> current = head;

        while (current != null) {                      //traversing through the list
            if (current.data.equals(value)) {                        //if the value exists
                return current;
            }
            current = current.next;                             //navigating to the next node
        }
        System.out.println("Value >" + value + "< not found");

        return null;
    }

    /**
     * goes through the list and updates pointers to remove the node from the list
     *
     * @param value value to be deleted
     */
    public void delete(T value) {
        if (head == null) {                                             //if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (head.data.equals(value)) {                                  //if the first element is to be removed
            head = head.next;
            head.prev = null;                                 //updating the prev pointer of the second node to null
            System.out.println("Head removed");
            return;
        }

        if (tail.data.equals(value) && tail.prev != null) {             //if the last element is to be removed
            tail = tail.prev;
            tail.next = null;                                 //updating the last node's pointer to null
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;                                     //traversing through all elements
        }
//        System.out.println("LEAVING: " + current.data + " CONDITION : " + (current.next != null && !current.next.data.equals(value)));

        if (current.next != null) {                         //if the node is not the last one
            current.next = current.next.next;                 //updating the next pointer of the current node to the node after the next in front of it
            if (current.next.next != null) {
                current.next.next.prev = current;                 //updating the prev pointer of the node after the node to be removed to the current node
            }
        } else {
            System.out.println("Value >" + value + "< not found");
        }
    }

    /**
     * resets the list by setting head to null
     */
    public void clearList() {
        head = null;
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
        Node<T> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * reverses the list
     */
    public void reverseList() {
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> temp;

        while (current != null) {
            temp = current.next;                                //temp becomes the next node
            current.next = prev;                                //the next node becomes the previous node
            prev = current;                                     //the previous node (second) becomes the current (first) node
            current = temp;                                     //the current node (first) becomes the temp node
        }
        head = prev;                                            //head is set to the last node (current node after traversing)
    }

    /**
     * prints the list from the first node to the last node and then back to the first node
     */
    public void loopAround() {
        Node<T> current = head;

        while (current.next != null) {                              //traversing to the end
            System.out.print(current.data + " > ");
            current = current.next;
        }
//        System.out.print("< REVERSING >");

        while (current != null) {                               //traversing in reverse
            System.out.print(current.data + " > ");
            current = current.prev;
        }
        System.out.println();
    }

    public static DoubleLinkedList sortedMerge(DoubleLinkedList L1, DoubleLinkedList L2) {
        DoubleLinkedList merged = new DoubleLinkedList();
        Node current1 = L1.head;
        Node current2 = L2.head;

        while (current1 != null && current2 != null) {
            if ((int)current1.data < (int)current2.data) {
                merged.insertInOrder((int)current1.data);
                current1 = current1.next;
            } else {
                merged.insertInOrder((int)current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            merged.insertInOrder((Comparable) current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            merged.insertInOrder((Comparable) current2.data);
            current2 = current2.next;
        }

        return merged;
    }

    public static void append(DoubleLinkedList l1, DoubleLinkedList l2) {
        if (l1 == null || l1.head == null || l2 == null || l2.head == null) {
            return;
        }

        Node current1 = l1.head;
        while (current1.next != null) {
            current1 = current1.next;
        }

        current1.next = l2.head;
        l2.head.prev = current1;

        l2.head = null;
    }

    public static void removeDuplicates(DoubleLinkedList dll) {
        if (dll.head == null) {
            return;
        }

        Node current = dll.head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                }
            } else {
                current = current.next;
            }
        }
    }

    public DoubleLinkedList[] splitList() {
        DoubleLinkedList[] result = new DoubleLinkedList[2];

        if (head == null || head.next == null) {
            result[0] = this;                                                   //stores the first element or null
            result[1] = new DoubleLinkedList();                                 //stores null for the second half for both cases
            return result;
        }

        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        result[0] = new DoubleLinkedList();
        result[0].head = head;
        result[1] = new DoubleLinkedList();
        result[1].head = n1.next;
        n1.next = null;                                                     //resetting first list

        return result;
    }

    /**
     * @return last node
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * @return string containing all the elements
     */
    public String toString() {
        Node<T> current = head;
        String list = "";

        while (current != null) {                                   //goes through all nodes
            if (current.next != null) {
                list = list + current.data.toString() + " > ";          //appends previous values with the current one
            } else {
                list = list + current.data.toString() + " <";          //appends previous values with the current one
            }
            current = current.next;                                 //updates current to the next node
        }
        return list;
    }

}


/*

        if (current.next != null) {                         //if the node is not the last one
            current.next = current.next.next;                 //updating the next pointer of the current node to the node after the next in front of it
            if (current.next.next == null) {
                current.prev.prev = current.prev;
            }
            else {
                current.next.next.prev = current;                 //updating the prev pointer of the node after the node to be removed to the current node
            }
        } else if ((current.next.next == null || current.next == null) && current.data.equals(value)) {            //if we have found the node

        } else {
            System.out.println("Value not found");              //UPDATE TAIL AT END
        }



        if (head == null) {                                 //if the list is empty
            head = new Node<>(value);
            return;
        }

        Node<T> current = head;
        while (current.next != null) {                      //traversing through the list to find the end
            if (value.compareTo(current.data) == 0) {
                current.next = new Node<T>(value);
                current.next = current.next.next;
                current.next.next.prev = current.next;
            } else if (value.compareTo(current.data) == -1) {
                current.prev = new Node<T>(value);
                current.prev.
            }
            current = current.next;
        }
        current.next = new Node<T>(value);
        current.next.prev = current;                        //setting the prev pointer of the new node to the last one
        tail = current.next;


 */