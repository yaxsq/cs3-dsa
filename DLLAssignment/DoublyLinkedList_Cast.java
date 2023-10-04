public class DoublyLinkedList_Cast {

    NameNode head;
    NameNode tail;

    public DoublyLinkedList_Cast() {
        this.head = null;
        this.tail = null;
    }

    public void add(String name) {
        if (head == null) {
            head = new NameNode(name);
            tail = head;
        } else {
            tail.next = new NameNode(name);
            tail.next.prev = tail;
            tail = tail.next;
        }
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
        NameNode current = head;
        String list = ">>> ";
        int i = 0;

        while (current != null) {                                   //goes through all nodes
            if (current.next != null) {
                list = list + current.name + " > ";          //appends previous values with the current one
            } else {
                list = list + current.name + " <";          //appends previous values with the current one
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

//
//    /**
//     * @param name movie to be found
//     * @return first node containing that value
//     */
//    public NameNode find(String name) {
//        NameNode current = head;
//
//        while (current != null) {                      //traversing through the list
//            if (current.name.equalsIgnoreCase(name)) {                        //if the value exists
//                return current;
//            }
//            current = current.next;                             //navigating to the next node
//        }
//
//        System.out.println("Value >" + name + "< not found");
//        return null;
//    }
//
//    /**
//     * goes through the list and updates pointers to remove the node from the list
//     *
//     * @param name value to be deleted
//     */
//    public void delete(String name) {
//        if (head == null) {                                             //if the list is empty
//            System.out.println("List is empty");
//            return;
//        }
//
//        if (head.name.equalsIgnoreCase(name)) {                                  //if the first element is to be removed
//            head = head.next;
//            head.prev = null;                                 //updating the prev pointer of the second node to null
//            System.out.println("Head removed");
//            return;
//        }
//
//        if (tail.name.equalsIgnoreCase(name) && tail.prev != null) {             //if the last element is to be removed
//            tail = tail.prev;
//            tail.next = null;                                 //updating the last node's pointer to null
//            return;
//        }
//
//        NameNode current = head;                                                       //if removing from the middle
//        while (current.next != null && !(current.next.name.equalsIgnoreCase(name))) {
//            current = current.next;                                     //traversing through all elements
//        }
////        System.out.println("LEAVING: " + current.data + " CONDITION : " + (current.next != null && !current.next.data.equals(value)));
//
//        if (current.next != null) {                         //if the node is not the last one
//            current.next = current.next.next;                 //updating the next pointer of the current node to the node after the next in front of it
//            if (current.next.next != null) {
//                current.next.next.prev = current;                 //updating the prev pointer of the node after the node to be removed to the current node
//            }
//        } else {
//            System.out.println("Value >" + name + "< not found");
//        }
//    }
//
//    /**
//     * resets the list by setting head and tail to null
//     */
//    public void clearList() {
//        head = null;
//        tail = null;
//    }
//
//    /**
//     * @return true if head is null / false otherwise
//     */
//    public boolean isEmpty() {
//        if (head == null) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * @return amount of nodes in the list
//     */
//    public int length() {
//        int count = 0;
//        NameNode current = head;
//
//        while (current != null) {
//            count++;
//            current = current.next;
//        }
//
//        return count;
//    }

}
