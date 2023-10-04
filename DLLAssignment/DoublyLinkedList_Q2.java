public class DoublyLinkedList_Q2 {

    DoublyLinkedList_Q1[] titleCharArray;

    public DoublyLinkedList_Q2() {
        titleCharArray = new DoublyLinkedList_Q1[26];
        for (int i = 0; i < titleCharArray.length; i++) {
            titleCharArray[i] = new DoublyLinkedList_Q1();
        }
    }

    /**
     * calculates the array index according to the first character of the title
     * calls the add method to add the movie in the dll at that calculated array index
     *
     * @param title
     * @param year
     */
    public void add(String title, String year) {
        titleCharArray[(int) ((title.charAt(0)) - 65)].add(title, year);
    }

    /**
     * @param title movie to be found
     * @return first node containing that value
     */
    public Node find(String title) {
        DoublyLinkedList_Q1 listToSearch = titleCharArray[getChar(title) - 65];
//        return listToSearch.find(title);                      //could use find from Q1 too

        Node current = listToSearch.head;

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
        DoublyLinkedList_Q1 listToSearch = titleCharArray[getChar(title) - 65];

        Node head = listToSearch.head;
        Node tail = listToSearch.tail;

        if (head == null) {                                             //if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            listToSearch.head = listToSearch.tail = null;
            return;
        }

        if (head.title.equalsIgnoreCase(title) && head.next == null) {
            listToSearch.head = listToSearch.head.next;
            return;
        }

        if (head.title.equalsIgnoreCase(title)) {                                  //if the first element is to be removed
            listToSearch.head = head.next;
            listToSearch.head.prev = null;                                 //updating the prev pointer of the second node to null
            System.out.println("Head removed");
            return;
        }

        if (tail.title.equalsIgnoreCase(title) && tail.prev != null) {             //if the last element is to be removed
            listToSearch.tail = tail.prev;
            listToSearch.tail.next = null;                                 //updating the last node's pointer to null
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
     * @param title
     * @return the first character of the title in upper case
     */
    private char getChar(String title) {
        return (title.charAt(0) + "").toUpperCase().charAt(0);
    }

    /**
     * resets the list by setting head and tail to null
     */
    public void clearList() {
        titleCharArray = new DoublyLinkedList_Q1[26];
    }

    /**
     * @return amount of nodes in the list
     */
    public int length() {
        int count = 0;

        for (int i = 0; i < titleCharArray.length; i++) {
            count += titleCharArray[i].length();
        }

        return count;
    }

    /**
     * prints the contents of the list
     */
    public void print() {
        System.out.println(this.toString());
    }

    /**
     * @return string containing all the elements
     */
    public String toString() {
        String list = ">>>\n";

        for (int j = 0; j < titleCharArray.length; j++) {
            Node current = titleCharArray[j].head;                      //goes through all lists of the array
            while (current != null) {                                   //goes through all nodes in the sublists
                list = list + current.title + " " + current.year + " " + current.cast + "\n";
                current = current.next;
            }
        }
        list += "<<<\n";
        return list;
    }

}
