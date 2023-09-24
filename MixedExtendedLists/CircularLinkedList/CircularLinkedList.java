public class CircularLinkedList {

    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void insert(String player) {
        if (head == null) {
            head = new Node<>(player);
            head.next = head;
            return;
        }

        Node<String> current = head;

//        if (current.next == head) {
//            current.next = new Node<String>(player);
//            current.next.next = head;
//            return;
//        }

        while (current.next != head) {                      //traversing through the list to find the end
            current = current.next;
        }
        current.next = new Node<>(player);
        current.next.next = head;                           //setting the latest element's next pointer to head
    }

    public String playGame() {
        while (head.next != head) {
            int rand = (int) (Math.random() * this.length() + 1);
            System.out.println("RAND: " + rand);

            for (int i = 0; i < rand; i++) {
                head = head.next;
            }
            if (this.length() > 1) {
                System.out.println("PLAYING: " + this.toString());
                System.out.println("REMOVING: " + head.next.data);
                head.next = head.next.next;                 //removing reference of the next element
            }
        }

        return (String) head.data;
    }

    public void delete(Node prev, Node temp) {
        if (head == null) {
            return;
        }

        if (temp == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = head.next;
            prev.next = head;
        } else {
            while (prev.next != head && prev.next != temp) {
                prev = prev.next;
            }

            if (prev.next == temp) {
                prev.next = temp.next;
            }
        }
    }

    /**
     * @return amount of nodes in the list
     */
    public int length() {
        int count = 0;

        if (head != null) {
            Node current = head;

            do {
                count++;
                current = current.next;
            } while (current != head);

        }
        return count;
    }

    public Node getIntNode(int value) {
        if (head == null) {
            return null;
        }

        Node current = head;
        do {
            if ((int)current.data == value) {
                return current;
            }
            current = current.next;
        } while (current != head);

        return null;
    }

    /**
     * @return string containing all the elements
     */
    public String toString() {
        String list = "";

        if (head != null) {
            Node current = head;
            do {
                list = list + current.data + " > ";
                current = current.next;
            } while (current != head);
        }

        return list;
    }

}
