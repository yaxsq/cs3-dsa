package L20Q1;

class LL {

    private Node head;


    public LL() {
        this.head = null;
    }

    /**
     * inserts the v to the end of the list by creating a new node
     *
     * @param v
     */
    public void insert(Vertex v) {
        if (head == null) {                                 //if the list is empty
            head = new Node(v);
            return;
        }

        Node current = head;
        while (current.next != null) {                      //traversing through the list to find the end
            current = current.next;
        }
        current.next = new Node(v);
    }

    public boolean find(Vertex v) {
        Node current = head;

        while (current != null) {                                    // traversing through the list
            if (current.v != null) {
                if (current.v.name.equalsIgnoreCase(v.name)) {            // if the value exists
                    return true;
                }
            }
            current = current.next;                                  // navigating to the next node
        }

        return false;
    }

    /**
     * @param v
     * @return
     */
    public Vertex get(Vertex v) {
        if (find(v)) {
            Node current = head;

            while (current != null) {                                    // traversing through the list
                if (current.v.name.equalsIgnoreCase(v.name)) {            // if the value exists
                    return current.v;
                }
                current = current.next;                                  // navigating to the next node
            }
        }

        return null;
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
     * @param v data to be removed
     */
    public void delete(Vertex v) {
        if (head == null) {                                             //if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (head.v.name.equalsIgnoreCase(v.name)) {                                  //if the first element is to be removed
            head = head.next;
            System.out.println("Head removed");
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.v.equals(v)) {
            current = current.next;                                     //traversing through all elements
        }
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Value not found");
        }

    }

    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * @return string containing all the elements
     */
    public String toString() {
        Node current = head;
        String list = "";

        while (current != null) {                       //goes through all nodes
            list += current.toString() + " > ";          //appends previous values with the current one
            current = current.next;                     //updates current to the next node
        }

        return list;
    }

}