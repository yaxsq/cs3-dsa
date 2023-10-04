public class DoubleLinkedList {

    private Node head;

    public DoubleLinkedList() {
        this.head = null;
    }

    public DoubleLinkedList(int[] arr) {
        this();
        for (int i = 0; i < arr.length; i++) {
            this.add(arr[i]);
        }
    }

    /**
     * inserts the value while maintaining an ascending order
     *
     * @param num value to be inserted
     */
    public void addSorted(int num) {
        Node newNode = new Node(num);

        if (head == null) {
            head = newNode;
        } else if (num < head.data) {           //if num is less than the first element
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {                               //traversing the list to find an appropriate node
            Node current = head;
            while (current.next != null && current.next.data < num) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }

    /**
     * adds the parameter as a new node at the end
     * @param num
     */
    public void add(int num) {
        Node current = head;

        if (head == null) {
            head = new Node(num);
            return;
        }

        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(num);
    }

    /**
     * adds a new node which replaces the head
     *
     * @param num
     */
    public void addAsHead(int num) {
        if (head != null) {
            head.prev = new Node(num);
            head.prev.next = head;
            head = head.prev;
        } else {
            head = new Node(num);
        }
    }

    /**
     * adds a new node which replaces the tail
     *
     * @param num
     */
    public void addAsTail(int num) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(num);
    }

    /**
     * @param num value to be found
     * @return first node containing that value
     */
    public Node find(int num) {
        Node current = head;

        while (current != null) {                      //traversing through the list
            if (current.data == num) {                        //if the value exists
                return current;
            }
            current = current.next;                             //navigating to the next node
        }

        System.out.println("Value >" + num + "< not found");
        return null;
    }

    /**
     * goes through the list and updates pointers to remove the node from the list
     *
     * @param num value to be deleted
     */
    public void delete(int num) {
        if (head == null) {                                             //if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (head.data == num) {                                  //if the first element is to be removed
            head = head.next;
            head.prev = null;                                 //updating the prev pointer of the second node to null
//            System.out.println("Head removed");
            return;
        }

        Node current = head;
        while (current.next != null && !(current.next.data == num)) {
            current = current.next;                                     //traversing through all elements
        }
//        System.out.println("LEAVING: " + current.data + " CONDITION : " + (current.next != null && !current.next.data.equals(value)));

        if (current.next != null) {                         //if the node is not the last one
            current.next = current.next.next;                 //updating the next pointer of the current node to the node after the next in front of it
            if (current.next.next != null) {
                current.next.next.prev = current;                 //updating the prev pointer of the node after the node to be removed to the current node
            }
        } else {
            System.out.println("Value >" + num + "< not found");
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
        Node current = head;

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
        Node current = head;
        Node prev = null;
        Node temp;

        while (current != null) {
            temp = current.next;                                //temp becomes the next node
            current.next = prev;                                //the next node becomes the previous node
            prev = current;                                     //the previous node (second) becomes the current (first) node
            current = temp;                                     //the current node (first) becomes the temp node
        }
        head = prev;                                            //head is set to the last node (current node after traversing)
    }

    /**
     * sets head to head.next
     *
     * @return head node
     */
    public Node popHead() {
        Node temp = head;
        head = head.next;                               //if list has 1 ele, head is going to be null
        return temp;
    }

    /**
     * removes the first occurrence of  i
     *
     * @param i int to remove
     */
    public void removeFirst(int i) {
        Node temp = find(i);
        Node current = head;

        if (temp == null) {
            return;
        }

        if (temp == head) {
            popHead();
            return;
        }

        while (current.next != temp) {
            current = current.next;
        }

        current.next = current.next.next;
        if (current.next != null) {
            current.next.next.prev = current;
        }
    }

    /**
     * removes all instances of i
     *
     * @param i int to remove
     */
    public void removeAll(int i) {
        while (find(i) != null) {
            removeFirst(i);
        }
    }

    /**
     * appends the parameter to the end of the current list
     * @param l
     */
    public void addAll(DoubleLinkedList l) {
        if (this.head == null) {
            this.head = l.head;
            return;
        }

        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = l.head;
    }

    /**
     * @return last node
     */
//    public Node getTail() {
//        return tail;
//    }

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
        String list = "";

        while (current != null) {                                   //goes through all nodes
            if (current.next != null) {
                list = list + current.data + " > ";          //appends previous values with the current one
            } else {
                list = list + current.data + " <";          //appends previous values with the current one
            }
            current = current.next;                                 //updates current to the next node
        }
        return list;
    }

}
